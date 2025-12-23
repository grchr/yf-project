package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.tradedata.YahooTradeData;

public class TradeDataServiceTest {

  @Test
  void tradeDataServiceTest() {
    TradeDataService tradeDataService = new TradeDataService();
    YahooTradeData result = tradeDataService.execute("BNP.PA");
    System.out.println(result);
  }
}
