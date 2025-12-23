package org.opensource.service;

import org.opensource.model.charts.YahooChart;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

public class ChartsService extends YahooService<YahooChart> implements IYahooEndpointServiceExecutable {

  public YahooChart execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      String crumb = getCrumb(crumbConn);
      String cookieHeader = retrieveCookies(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumb);
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(cookieHeader, dataConn);
      return getResult(dataConn, YahooChart.class);
    } catch (IOException e) {
      return new YahooChart();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) throws UnsupportedEncodingException {
    String modules = "dividends,split";
    return String.format(
            "https://query1.finance.yahoo.com/v8/finance/chart/%s?range=max&interval=1d&events=%s&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
