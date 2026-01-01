package org.opensource.service.v1;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.response.predictions.YahooAnalystData;
import org.opensource.model.response.profile.YahooCompanyProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PredictionsServiceTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }


  @Test
  void predictionsServiceTest() throws YahooServiceException {
    PredictionsService predictionsService = new PredictionsService();
    YahooAnalystData result = predictionsService.execute("BNP.PA");
    assertEquals(1, result.getQuoteSummary().getResult().size());
    assertTrue(result.getQuoteSummary().getResult().get(0).getRecommendationTrend().getTrend().size() > 0);
    System.out.println(result);
  }
}
