package org.opensource.service.v1;

import org.apache.commons.lang3.StringUtils;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.profile.YahooCompanyProfile;
import org.opensource.model.web.CrumbCookie;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;
import java.net.HttpURLConnection;

public class CompanyProfileService extends YahooService<YahooCompanyProfile> implements IYahooEndpointServiceExecutable {

  public CompanyProfileService() {
    super();
  }

  public CompanyProfileService(CrumbCookie lastUsedCrumbCookie) {
    super(lastUsedCrumbCookie);
  }

  public YahooCompanyProfile execute(String ticker) throws YahooServiceException {
    try {
      if (lastUsedCrumbCookie == null || StringUtils.isEmpty(lastUsedCrumbCookie.getCrumb()) || StringUtils.isEmpty(lastUsedCrumbCookie.getCookie())) {
        logger.debug("Fetching new crumb and cookie for ticker: {}", ticker);
        HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
        lastUsedCrumbCookie = getCrumbCookie(crumbConn);
      }
      String quoteSummaryUrl = prepareUrl(ticker, lastUsedCrumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(lastUsedCrumbCookie.getCookie(), dataConn);
      return getResult(dataConn, YahooCompanyProfile.class);
    } catch (IOException e) {
      throw new YahooServiceException("Failed to retrieve data for ticker: " + ticker);
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "assetProfile%2CsecFilings&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true";
    return String.format(
            "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
