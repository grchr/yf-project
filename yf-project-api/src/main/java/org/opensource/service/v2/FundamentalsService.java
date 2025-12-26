package org.opensource.service.v2;

import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooCrumbException;
import org.opensource.model.response.fundamentals.YahooFundamentals;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;
import java.time.Instant;

public class FundamentalsService extends YahooServiceSync<YahooFundamentals> implements IYahooEndpointServiceExecutable {

  public FundamentalsService() {
    super();
  }

  public FundamentalsService(okhttp3.OkHttpClient client, String lastUsedCrumb) {
    super(client, lastUsedCrumb);
  }

  @Override
  public YahooFundamentals execute(String ticker) {

    try {
      // Get crumb (cookies captured here)
      lastUsedCrumb = getCrumb();
      System.out.println("Crumb: " + lastUsedCrumb);
      // Use crumb + cookies
      String url = prepareUrl(ticker, lastUsedCrumb);
      System.out.println("URL: " + url);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooFundamentals.class);
      }
    } catch (IOException e) {
      return new YahooFundamentals();
    } catch (YahooCrumbException e) {
      System.out.println("Failed to get crumb: " + e.getMessage());
      return new YahooFundamentals();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "annualTotalRevenue,annualNetIncome,annualOperatingIncome";
    long period2 = Instant.now().getEpochSecond();
    return String.format(
            "https://query2.finance.yahoo.com/ws/fundamentals-timeseries/v1/finance/timeseries/%s?symbol=%s&type=%s&period1=0&period2=%s&crumb=%s",
            encode(ticker), encode(ticker), modules, period2, encode(crumb)
    );
  }
}
