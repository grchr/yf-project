package org.opensource.service.v2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooServiceException;
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
  public YahooEventChart execute(String ticker) throws YahooServiceException {

    try {
      // Get crumb (cookies captured here)
      lastUsedCrumb = getCrumb();
      // Use crumb + cookies
      String url = prepareUrl(ticker, lastUsedCrumb);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooEventChart.class);
      }
    } catch (IOException e) {
      throw new YahooServiceException("Failed to retrieve data for ticker: " + ticker);
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
