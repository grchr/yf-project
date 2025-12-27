package org.opensource.service.v2;

import okhttp3.Request;
import org.opensource.exceptions.YahooAsyncRequestException;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.response.financials.YahooFinancials;
import org.opensource.model.response.keystats.YahooKeyStatistics;
import org.opensource.model.web.YahooRequestFactory;
import org.opensource.model.web.YahooSessionFactory;

import java.util.concurrent.CompletableFuture;

public class KeyStatisticsServiceAsync extends YahooServiceAsync<YahooKeyStatistics> implements IYahooEndpointServiceAsyncExecutable {

  public KeyStatisticsServiceAsync() {
    super();
  }

  public KeyStatisticsServiceAsync(org.opensource.model.web.YahooSession session) {
    super(session);
  }

  @Override
  public CompletableFuture<YahooKeyStatistics> executeAsync(String ticker) throws YahooServiceException {
    try {
      if (this.session == null) {
        this.session = YahooSessionFactory.getYahooSession();
      }

      return session.crumbAsync().thenCompose((String crumb) -> {
        String url = prepareUrl(ticker, crumb);
        Request request = YahooRequestFactory.createYahooRequest(url);
        return getResultAsync(request, YahooKeyStatistics.class);
      }).exceptionally((Throwable throwable) -> {
        logger.error("Failed to retrieve data for ticker: " + ticker, throwable);
        throw new YahooAsyncRequestException("Failed to retrieve data for ticker: " + ticker, throwable);
      });

    } catch (YahooAsyncRequestException e) {
      CompletableFuture<YahooKeyStatistics> failedFuture = new CompletableFuture<>();
      failedFuture.completeExceptionally(
              new YahooServiceException("Failed to retrieve crumb from session for ticker: " + ticker, e)
      );
      return failedFuture;
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "summaryProfile%2CfinancialData%2CrecommendationTrend%2Cearnings%2CequityPerformance%2CsummaryDetail%2CdefaultKeyStatistics%2CcalendarEvents%2CesgScores%2Cprice%2CpageViews%2CfinancialsTemplate%2CearningsCallAudios%2CquoteUnadjustedPerformanceOverview%2CcorporateActions%2CearningsCallTranscripts%2CearningsGaap%2CearningsNonGaap%2CupgradeDowngradeHistory";
    return String.format(
            "https://query2.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
