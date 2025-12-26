package org.opensource.service.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.model.response.keystats.YahooKeyStatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyStatisticsServiceTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

  @Test
  void keyStatisticsServiceTest() {
    KeyStatisticsService keyStatisticsService = new KeyStatisticsService();
    YahooKeyStatistics result = keyStatisticsService.execute("BNP.PA");
    assertEquals(1, result.getQuoteSummary().getResult().size());
    assertEquals("BNP.PA", result.getQuoteSummary().getResult().get(0).getPrice().getSymbol());
    assertEquals("EUR", result.getQuoteSummary().getResult().get(0).getFinancialData().getFinancialCurrency());
    System.out.println(result);
  }
}
