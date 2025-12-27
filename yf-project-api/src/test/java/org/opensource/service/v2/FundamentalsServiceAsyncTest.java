package org.opensource.service.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.fundamentals.YahooFundamentals;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FundamentalsServiceAsyncTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

  @Test
  void fundamentalsServiceTest() throws YahooServiceException, ExecutionException, InterruptedException {
    FundamentalsServiceAsync fundamentalsService = new FundamentalsServiceAsync();
    YahooFundamentals result = fundamentalsService.executeAsync("BNP.PA").get();
    assertEquals(3, result.getTimeseries().getResult().size());
    assertNotNull(result.getTimeseries().getResult().get(0).getMeta().getType());
    assertNotNull(result.getTimeseries().getResult().get(1).getMeta().getType());
    assertNotNull(result.getTimeseries().getResult().get(2).getMeta().getType());
    System.out.println(result);
  }
}
