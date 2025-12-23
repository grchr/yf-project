package org.opensource.service;

import org.opensource.model.fundamentals.YahooFundamentals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.time.Instant;

public class FundamentalsService extends YahooService<YahooFundamentals> implements IYahooEndpointServiceExecutable {

  public YahooFundamentals execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      String crumb = getCrumb(crumbConn);
      String cookieHeader = retrieveCookies(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumb);
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(cookieHeader, dataConn);
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
