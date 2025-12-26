package org.opensource.service.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.model.response.tradedata.YahooTradeData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TradeDataServiceTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

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
