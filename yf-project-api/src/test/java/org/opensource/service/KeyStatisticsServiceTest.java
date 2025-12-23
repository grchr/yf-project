package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.response.keystats.YahooKeyStatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyStatisticsServiceTest {

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
