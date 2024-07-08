package org.opensource.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensource.model.CompanyKeyStatistics;
import org.opensource.model.CompanyTradingInformation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetKeyStatisticsServiceTest {

  private static GetKeyStatisticsService service;

  @BeforeAll
  public static void setUp() {
    service = new GetKeyStatisticsService();
  }

  @AfterAll
  public static void tearDown() {
    service.shutdown();
  }

  @Test
  public void testExecute() {
    String ticker = "AAPL";
    CompanyKeyStatistics keyStatistics = service.execute(ticker);

    assertNotNull(keyStatistics);
    assertAllFieldsNoDash(keyStatistics);
  }

  @Test
  public void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = "AAPL";
    CompletableFuture<CompanyKeyStatistics> future = service.executeAsync(ticker);
    CompanyKeyStatistics keyStatistics = future.get();

    assertNotNull(keyStatistics);
    assertAllFieldsNoDash(keyStatistics);
  }

  private void assertAllFieldsNoDash(CompanyKeyStatistics keyStatistics) {
    assertNotEquals("--", keyStatistics.getMarketCap());
    assertNotEquals("--", keyStatistics.getTrailingPE());
    assertNotEquals("--", keyStatistics.getForwardPE());
    assertNotEquals("--", keyStatistics.getPegRatio());
    assertNotEquals("--", keyStatistics.getRatioPS());
    assertNotEquals("--", keyStatistics.getRatioPB());
    assertNotEquals("--", keyStatistics.getEvToRevenue());
    assertNotEquals("--", keyStatistics.getProfitMargin());
    assertNotEquals("--", keyStatistics.getOperatingMargin());
    assertNotEquals("--", keyStatistics.getReturnOnAssets());
    assertNotEquals("--", keyStatistics.getReturnOnEquity());
    assertNotEquals("--", keyStatistics.getRevenue());
    assertNotEquals("--", keyStatistics.getRevenuePerShare());
    assertNotEquals("--", keyStatistics.getQuarterlyRevenueGrowth());
    assertNotEquals("--", keyStatistics.getEBITDA());
    assertNotEquals("--", keyStatistics.getNetIncomeAviToCommon());
    assertNotEquals("--", keyStatistics.getDilutedEPS());
    assertNotEquals("--", keyStatistics.getQuartEarningsGrowth());
    assertNotEquals("--", keyStatistics.getTotalCash());
    assertNotEquals("--", keyStatistics.getTotalCashPerShare());
    assertNotEquals("--", keyStatistics.getTotalDebt());
    assertNotEquals("--", keyStatistics.getTotalDebtToEquity());

    CompanyTradingInformation tradingInfo = keyStatistics.getTradingInformation();
    assertNotEquals("--", tradingInfo.getBeta());
    assertNotEquals("--", tradingInfo.getCurrentRatio());
    assertNotEquals("--", tradingInfo.getWeek52Range());
    assertNotEquals("--", tradingInfo.getWeek52High());
    assertNotEquals("--", tradingInfo.getWeek52Low());
    assertNotEquals("--", tradingInfo.getDay50MovingAvg());
    assertNotEquals("--", tradingInfo.getDay200MovingAverage());
    assertNotEquals("--", tradingInfo.getForwardAnnualDividendYield());
    assertNotEquals("--", tradingInfo.getForwardAnnualDividendRate());
    assertNotEquals("--", tradingInfo.getDividendYield5YearAvg());
    assertNotEquals("--", tradingInfo.getTrailingAnnualDividendRate());
    assertNotEquals("--", tradingInfo.getTrailingAnnualDividendYield());
    assertNotEquals("--", tradingInfo.getPayoutRatio());
  }
}
