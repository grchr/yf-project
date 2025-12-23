package org.opensource.service;

import org.opensource.model.profile.YahooCompanyProfile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

public class CompanyProfileService extends YahooService<YahooCompanyProfile> implements IYahooEndpointServiceExecutable {

  public YahooCompanyProfile execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      String crumb = getCrumb(crumbConn);
      String cookieHeader = retrieveCookies(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumb);
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(cookieHeader, dataConn);
      return getResult(dataConn, YahooCompanyProfile.class);
    } catch (IOException e) {
      return new YahooCompanyProfile();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) throws UnsupportedEncodingException {
    String modules = encode("assetProfile%2CsecFilings&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true");
    return String.format(
            "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
