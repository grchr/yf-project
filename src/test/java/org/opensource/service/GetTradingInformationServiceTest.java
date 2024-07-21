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

public class GetTradingInformationServiceTest {

  private static GetTradingInformationService service;

  @BeforeAll
  public static void setUp() {
    service = new GetTradingInformationService();
  }

  @AfterAll
  public static void tearDown() {
    service.shutdown();
  }

  @Test
  public void testExecute() {
    String ticker = getRandomStockToTest();
    CompanyTradingInformation tradingInformation = service.execute(ticker);

    assertNotNull(tradingInformation);
    assertAllFieldsNoDash(tradingInformation);
  }

  @Test
  public void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = getRandomStockToTest();
    CompletableFuture<CompanyTradingInformation> future = service.executeAsync(ticker);
    CompanyTradingInformation tradingInformation = future.get();

    assertNotNull(tradingInformation);
    assertAllFieldsNoDash(tradingInformation);
  }

  private void assertAllFieldsNoDash(CompanyTradingInformation tradingInfo) {
    assertNotEquals(Double.NaN, tradingInfo.getBeta());
    assertNotEquals(Double.NaN, tradingInfo.getCurrentRatio());
    assertNotEquals(Double.NaN, tradingInfo.getWeek52RangePercentage());
    assertNotEquals(Double.NaN, tradingInfo.getWeek52High());
    assertNotEquals(Double.NaN, tradingInfo.getWeek52Low());
    assertNotEquals(Double.NaN, tradingInfo.getDay50MovingAvg());
    assertNotEquals(Double.NaN, tradingInfo.getDay200MovingAverage());
    assertNotEquals(Double.NaN, tradingInfo.getForwardAnnualDividendYieldPercentage());
    assertNotEquals(Double.NaN, tradingInfo.getForwardAnnualDividendRate());
    assertNotEquals(Double.NaN, tradingInfo.getDividendYield5YearAvg());
    assertNotEquals(Double.NaN, tradingInfo.getTrailingAnnualDividendRate());
    assertNotEquals(Double.NaN, tradingInfo.getTrailingAnnualDividendYieldPercentage());
    assertNotEquals(Double.NaN, tradingInfo.getPayoutRatioPercentage());
  }
}
