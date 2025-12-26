package org.opensource.service.v1;

import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.web.CrumbCookie;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;
import java.net.HttpURLConnection;

public class ChartsService extends YahooService<YahooEventChart> implements IYahooEndpointServiceExecutable {

  public YahooEventChart execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      CrumbCookie crumbCookie = getCrumbCookie(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumbCookie.getCrumb());
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(crumbCookie.getCookie(), dataConn);
      return getResult(dataConn, YahooEventChart.class);
    } catch (IOException e) {
      return new YahooEventChart();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "dividends,split";
    return String.format(
            "https://query1.finance.yahoo.com/v8/finance/chart/%s?range=max&interval=1d&events=%s&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
