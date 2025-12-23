package org.opensource.service.v1;

import org.opensource.model.response.profile.YahooCompanyProfile;
import org.opensource.model.web.CrumbCookie;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

public class CompanyProfileService extends YahooService<YahooCompanyProfile> implements IYahooEndpointServiceExecutable {

  public YahooCompanyProfile execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      CrumbCookie crumbCookie = getCrumbCookie(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(crumbCookie.getCookie(), dataConn);
      return getResult(dataConn, YahooCompanyProfile.class);
    } catch (IOException e) {
      return new YahooCompanyProfile();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) throws UnsupportedEncodingException {
    String modules = "assetProfile%2CsecFilings&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true";
    return String.format(
            "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
