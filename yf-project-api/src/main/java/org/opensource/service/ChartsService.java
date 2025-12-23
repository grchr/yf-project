package org.opensource.service;

import org.opensource.model.response.charts.YahooChart;
import org.opensource.model.web.CrumbCookie;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

public class ChartsService extends YahooService<YahooChart> implements IYahooEndpointServiceExecutable {

  public YahooChart execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      CrumbCookie crumbCookie = getCrumbCookie(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(crumbCookie.getCookie(), dataConn);
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
