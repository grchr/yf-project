package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.fundamentals.YahooFundamentals;

public class FundamentalsServiceTest {

  @Test
  void fundamentalsServiceTest() {
    FundamentalsService fundamentalsService = new FundamentalsService();
    YahooFundamentals result = fundamentalsService.execute("BNP.PA");
    System.out.println(result);
  }
}
