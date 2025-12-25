package org.opensource.service.v2;

import okhttp3.Request;
import okhttp3.Response;
import org.opensource.model.response.fundamentals.YahooFundamentals;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;
import java.time.Instant;

public class FundamentalsService extends YahooServiceSync<YahooFundamentals> implements IYahooEndpointServiceExecutable {

  @Override
  public YahooFundamentals execute(String ticker) {

    try {
      // Get crumb (cookies captured here)
      String crumb = getCrumb();
      System.out.println("Crumb: " + crumb);
      // Use crumb + cookies
      String url = prepareUrl(ticker, crumb);
      System.out.println("URL: " + url);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooFundamentals.class);
      }
    } catch (IOException e) {
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
