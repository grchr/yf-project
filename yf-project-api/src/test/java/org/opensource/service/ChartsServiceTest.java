package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.charts.YahooChart;

public class ChartsServiceTest {

  @Test
  void chartServiceTest() {
    ChartsService chartService = new ChartsService();
    YahooChart result = chartService.execute("BNP.PA");
    System.out.println(result);
  }
}
