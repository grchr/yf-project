package org.opensource.service.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.tradedata.YahooTradeData;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TradeDataServiceAsyncTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

  @Test
  void tradeDataServiceTest() throws YahooServiceException, ExecutionException, InterruptedException {
    TradeDataServiceAsync tradeDataService = new TradeDataServiceAsync();
    YahooTradeData result = tradeDataService.executeAsync("BNP.PA").get();
    assertEquals(1, result.getQuoteResponse().getResult().size());
    assertEquals("BNP.PA", result.getQuoteResponse().getResult().get(0).getSymbol());
    assertNotNull(result.getQuoteResponse().getResult().get(0).getRegularMarketPrice().getRaw());
    System.out.println(result);
  }
}
