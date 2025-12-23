package org.opensource.service;

import org.opensource.model.response.fundamentals.YahooFundamentals;
import org.opensource.model.web.CrumbCookie;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.time.Instant;

public class FundamentalsService extends YahooService<YahooFundamentals> implements IYahooEndpointServiceExecutable {

  public YahooFundamentals execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      CrumbCookie crumbCookie = getCrumbCookie(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(crumbCookie.getCookie(), dataConn);
      return getResult(dataConn, YahooFundamentals.class);
    } catch (IOException e) {
      return new YahooFundamentals();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) throws UnsupportedEncodingException {
    String modules = "annualTotalRevenue,annualNetIncome,annualOperatingIncome";
    long period2 = Instant.now().getEpochSecond();
    return String.format(
            "https://query2.finance.yahoo.com/ws/fundamentals-timeseries/v1/finance/timeseries/%s?symbol=%s&type=%s&period1=0&period2=%s&crumb=%s",
            encode(ticker), encode(ticker), modules, period2, encode(crumb)
    );
  }

}
