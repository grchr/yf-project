package org.opensource.service.v2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooCrumbException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;

public class ChartsService extends YahooServiceSync<YahooEventChart> implements IYahooEndpointServiceExecutable {

  public ChartsService() {
    super();
  }

  public ChartsService(OkHttpClient client, String lastUsedCrumb) {
    super(client, lastUsedCrumb);
  }

  @Override
  public YahooEventChart execute(String ticker) {

    try {
      // Get crumb (cookies captured here)
      lastUsedCrumb = getCrumb();
      System.out.println("Crumb: " + lastUsedCrumb);
      // Use crumb + cookies
      String url = prepareUrl(ticker, lastUsedCrumb);
      System.out.println("URL: " + url);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooEventChart.class);
      }
    } catch (IOException e) {
      return new YahooEventChart();
    } catch (YahooCrumbException e) {
      System.out.println("Failed to get crumb: " + e.getMessage());
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
