package org.opensource.service.v2;

import okhttp3.Request;
import org.opensource.exceptions.YahooAsyncRequestException;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.exceptions.YahooSessionException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.web.YahooRequestFactory;
import org.opensource.model.web.YahooSession;
import org.opensource.model.web.YahooSessionFactory;

import java.util.concurrent.CompletableFuture;

public class ChartsServiceAsync extends YahooServiceAsync<YahooEventChart> implements IYahooEndpointServiceAsyncExecutable {

  public ChartsServiceAsync() {
    super();
  }

  public ChartsServiceAsync(YahooSession session) {
    super(session);
  }

  @Override
  public CompletableFuture<YahooEventChart> executeAsync(String ticker) throws YahooServiceException {
    try {
      if (this.session == null) {
        this.session = YahooSessionFactory.getYahooSession();
      }

      return session.crumbAsync().thenCompose((String crumb) -> {
        String url = prepareUrl(ticker, crumb);
        Request request = YahooRequestFactory.createYahooRequest(url);
        return getResultAsync(request, YahooEventChart.class);
      }).exceptionally((Throwable throwable) -> {
        logger.error("Failed to retrieve data for ticker: " + ticker, throwable);
        throw new YahooAsyncRequestException("Failed to retrieve data for ticker: " + ticker, throwable);
      });

    } catch (YahooAsyncRequestException e) {
      CompletableFuture<YahooEventChart> failedFuture = new CompletableFuture<>();
      failedFuture.completeExceptionally(
              new YahooServiceException("Failed to retrieve crumb from session for ticker: " + ticker, e)
      );
      return failedFuture;
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
