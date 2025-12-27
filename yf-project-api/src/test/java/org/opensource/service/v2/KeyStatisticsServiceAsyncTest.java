package org.opensource.service.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.keystats.YahooKeyStatistics;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyStatisticsServiceAsyncTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

  @Test
  void keyStatisticsServiceTest() throws YahooServiceException, ExecutionException, InterruptedException {
    KeyStatisticsServiceAsync keyStatisticsService = new KeyStatisticsServiceAsync();
    YahooKeyStatistics result = keyStatisticsService.executeAsync("BNP.PA").get();
    assertEquals(1, result.getQuoteSummary().getResult().size());
    assertEquals("BNP.PA", result.getQuoteSummary().getResult().get(0).getPrice().getSymbol());
    assertEquals("EUR", result.getQuoteSummary().getResult().get(0).getFinancialData().getFinancialCurrency());
    System.out.println(result);
  }
}
