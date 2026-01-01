package org.opensource.service.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.predictions.YahooAnalystData;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredictionsServiceTestAsync {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }


  @Test
  void predictionsServiceTestAsync() throws YahooServiceException, ExecutionException, InterruptedException {
    PredictionsServiceAsync predictionsService = new PredictionsServiceAsync();
    YahooAnalystData result = predictionsService.executeAsync("BNP.PA").get();
    assertEquals(1, result.getQuoteSummary().getResult().size());
    assertTrue(result.getQuoteSummary().getResult().get(0).getRecommendationTrend().getTrend().size() > 0);
    System.out.println(result);
  }
}
