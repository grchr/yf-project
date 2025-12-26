package org.opensource.service.v2;

import okhttp3.Request;
import okhttp3.Response;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;

public class ChartsService extends YahooServiceSync<YahooEventChart> implements IYahooEndpointServiceExecutable {

  @Override
  public YahooEventChart execute(String ticker) {

    try {
      // Get crumb (cookies captured here)
      String crumb = getCrumb();
      System.out.println("Crumb: " + crumb);
      // Use crumb + cookies
      String url = prepareUrl(ticker, crumb);
      System.out.println("URL: " + url);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooEventChart.class);
      }
    } catch (IOException e) {
      return new YahooEventChart();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "dividends,split";
    return String.format(
            "https://query2.finance.yahoo.com/v8/finance/chart/%s?range=max&interval=1d&events=%s&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
