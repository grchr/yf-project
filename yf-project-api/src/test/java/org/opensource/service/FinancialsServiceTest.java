package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.financials.YahooFinancials;

public class FinancialsServiceTest {

  @Test
  void financialsServiceTest() {
    FinancialsService financialsService = new FinancialsService();
    YahooFinancials result = financialsService.execute("BNP.PA");
    System.out.println(result);
  }
}
