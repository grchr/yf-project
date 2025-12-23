package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.keystats.YahooKeyStatistics;

public class KeyStatisticsServiceTest {

  @Test
  void keyStatisticsServiceTest() {
    KeyStatisticsService keyStatisticsService = new KeyStatisticsService();
    YahooKeyStatistics result = keyStatisticsService.execute("BNP.PA");
    System.out.println(result);
  }
}
