package org.opensource.service.v2;

import okhttp3.Request;
import org.opensource.exceptions.YahooAsyncRequestException;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.fundamentals.YahooFundamentals;
import org.opensource.model.web.YahooRequestFactory;
import org.opensource.model.web.YahooSessionFactory;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;

public class FundamentalsServiceAsync extends YahooServiceAsync<YahooFundamentals> implements IYahooEndpointServiceAsyncExecutable {

  public FundamentalsServiceAsync() {
    super();
  }

  public FundamentalsServiceAsync(org.opensource.model.web.YahooSession session) {
    super(session);
  }

  @Override
  public CompletableFuture<YahooFundamentals> executeAsync(String ticker) throws YahooServiceException {
    try {
      if (this.session == null) {
        this.session = YahooSessionFactory.getYahooSession();
      }

      return session.crumbAsync().thenCompose((String crumb) -> {
        String url = prepareUrl(ticker, crumb);
        Request request = YahooRequestFactory.createYahooRequest(url);
        return getResultAsync(request, YahooFundamentals.class);
      }).exceptionally((Throwable throwable) -> {
        logger.error("Failed to retrieve data for ticker: " + ticker, throwable);
        throw new YahooAsyncRequestException("Failed to retrieve data for ticker: " + ticker, throwable);
      });

    } catch (YahooAsyncRequestException e) {
      CompletableFuture<YahooFundamentals> failedFuture = new CompletableFuture<>();
      failedFuture.completeExceptionally(
              new YahooServiceException("Failed to retrieve crumb from session for ticker: " + ticker, e)
      );
      return failedFuture;
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
