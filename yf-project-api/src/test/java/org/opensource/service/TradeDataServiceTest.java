package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.tradedata.YahooTradeData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TradeDataServiceTest {

  @Test
  void tradeDataServiceTest() {
    TradeDataService tradeDataService = new TradeDataService();
    YahooTradeData result = tradeDataService.execute("BNP.PA");
    assertEquals(1, result.getQuoteResponse().getResult().size());
    assertEquals("BNP.PA", result.getQuoteResponse().getResult().get(0).getSymbol());
    assertNotNull(result.getQuoteResponse().getResult().get(0).getRegularMarketPrice().getRaw());
    System.out.println(result);
  }
}
