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
import static org.opensource.service.TestUtils.getRandomStockToTest;

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
    String ticker = getRandomStockToTest();
    CompanyKeyStatistics keyStatistics = service.execute(ticker);

    assertNotNull(keyStatistics);
    assertAllFieldsNoDash(keyStatistics);
  }

  @Test
  public void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = getRandomStockToTest();
    CompletableFuture<CompanyKeyStatistics> future = service.executeAsync(ticker);
    CompanyKeyStatistics keyStatistics = future.get();

    assertNotNull(keyStatistics);
    assertAllFieldsNoDash(keyStatistics);
  }

  private void assertAllFieldsNoDash(CompanyKeyStatistics keyStatistics) {
    assertNotEquals("--", keyStatistics.getMarketCap());
    assertNotEquals(Double.NaN, keyStatistics.getTrailingPE());
    assertNotEquals(Double.NaN, keyStatistics.getForwardPE());
    assertNotEquals(Double.NaN, keyStatistics.getPegRatio());
    assertNotEquals(Double.NaN, keyStatistics.getRatioPS());
    assertNotEquals(Double.NaN, keyStatistics.getRatioPB());
    assertNotEquals(Double.NaN, keyStatistics.getEvToRevenue());
    assertNotEquals(Double.NaN, keyStatistics.getProfitMarginPercentage());
    assertNotEquals(Double.NaN, keyStatistics.getOperatingMarginPercentage());
    assertNotEquals(Double.NaN, keyStatistics.getReturnOnAssetsPercentage());
    assertNotEquals(Double.NaN, keyStatistics.getReturnOnEquityPercentage());
    assertNotEquals("--", keyStatistics.getRevenue());
    assertNotEquals(Double.NaN, keyStatistics.getRevenuePerShare());
    assertNotEquals(Double.NaN, keyStatistics.getQuarterlyRevenueGrowthPercentage());
    assertNotEquals("--", keyStatistics.getEBITDA());
    assertNotEquals("--", keyStatistics.getNetIncomeAviToCommon());
    assertNotEquals(Double.NaN, keyStatistics.getDilutedEPS());
    assertNotEquals(Double.NaN, keyStatistics.getQuartEarningsGrowthPercentage());
    assertNotEquals("--", keyStatistics.getTotalCash());
    assertNotEquals(Double.NaN, keyStatistics.getTotalCashPerShare());
    assertNotEquals("--", keyStatistics.getTotalDebt());
    assertNotEquals(Double.NaN, keyStatistics.getTotalDebtToEquityPercentage());
  }
}
