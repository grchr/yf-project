package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.fundamentals.YahooFundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FundamentalsServiceTest {

  @Test
  void fundamentalsServiceTest() {
    FundamentalsService fundamentalsService = new FundamentalsService();
    YahooFundamentals result = fundamentalsService.execute("BNP.PA");
    assertEquals(3, result.getTimeseries().getResult().size());
    assertNotNull(result.getTimeseries().getResult().get(0).getMeta().getType());
    assertNotNull(result.getTimeseries().getResult().get(1).getMeta().getType());
    assertNotNull(result.getTimeseries().getResult().get(2).getMeta().getType());
    System.out.println(result);
  }
}
