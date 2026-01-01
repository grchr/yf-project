package org.opensource.service.v2;

import org.junit.jupiter.api.Test;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.response.financials.YahooFinancials;
import org.opensource.model.response.fundamentals.YahooFundamentals;
import org.opensource.model.response.keystats.YahooKeyStatistics;
import org.opensource.model.response.predictions.YahooAnalystData;
import org.opensource.model.response.tradedata.YahooTradeData;
import org.opensource.model.web.YahooSession;
import org.opensource.model.web.YahooSessionFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TotalTest {

  @Test
  void testAllEndpoints() throws YahooServiceException, ExecutionException, InterruptedException {
    YahooSession session = YahooSessionFactory.getYahooSession();
    ChartsServiceAsync chartsService = new ChartsServiceAsync(session);
    FundamentalsServiceAsync fundamentalsService = new FundamentalsServiceAsync(session);
    FinancialsServiceAsync financialsService = new FinancialsServiceAsync(session);
    KeyStatisticsServiceAsync keyStatisticsService = new KeyStatisticsServiceAsync(session);
    TradeDataServiceAsync tradeDataService = new TradeDataServiceAsync(session);
    PredictionsServiceAsync predictionsService = new PredictionsServiceAsync(session);

    CompletableFuture<YahooEventChart> yahooEventChartCompletableFuture = chartsService.executeAsync("BNP.PA");
    CompletableFuture<YahooFundamentals> yahooFundamentalsCompletableFuture = fundamentalsService.executeAsync("BNP.PA");
    CompletableFuture<YahooFinancials> yahooFinancialsCompletableFuture = financialsService.executeAsync("BNP.PA");
    CompletableFuture<YahooKeyStatistics> yahooKeyStatisticsCompletableFuture = keyStatisticsService.executeAsync("BNP.PA");
    CompletableFuture<YahooTradeData> yahooTradeDataCompletableFuture = tradeDataService.executeAsync("BNP.PA");
    CompletableFuture<YahooAnalystData> yahooPredictionDataCompletableFuture = predictionsService.executeAsync("BNP.PA");

    CompletableFuture<Void> allFutures = CompletableFuture.allOf(
            yahooEventChartCompletableFuture,
            yahooFundamentalsCompletableFuture,
            yahooFinancialsCompletableFuture,
            yahooKeyStatisticsCompletableFuture,
            yahooTradeDataCompletableFuture,
            yahooPredictionDataCompletableFuture
    );

    allFutures.join(); // Wait for all futures to complete

    YahooEventChart yahooEventChart = yahooEventChartCompletableFuture.join();
    YahooFundamentals yahooFundamentals = yahooFundamentalsCompletableFuture.join();
    YahooFinancials yahooFinancials = yahooFinancialsCompletableFuture.join();
    YahooKeyStatistics yahooKeyStatistics = yahooKeyStatisticsCompletableFuture.join();
    YahooTradeData yahooTradeData = yahooTradeDataCompletableFuture.join();
    YahooAnalystData yahooAnalystData = yahooPredictionDataCompletableFuture.join();

    System.out.println(yahooEventChart);
    System.out.println(yahooFundamentals);
    System.out.println(yahooFinancials);
    System.out.println(yahooKeyStatistics);
    System.out.println(yahooTradeData);
    System.out.println(yahooAnalystData);
  }
}
