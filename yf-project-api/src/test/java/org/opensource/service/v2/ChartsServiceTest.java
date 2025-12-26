package org.opensource.service.v2;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;
import org.opensource.model.response.charts.YahooEventChart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChartsServiceTest {

  @Test
  void chartServiceTest() {
    ChartsService chartService = new ChartsService();
    YahooEventChart result = chartService.execute("AAPL");
    assertEquals(1, result.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(result.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(result.getChart().getResult().get(0).getIndicators());
    assertNotNull(result.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(result.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(result.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(result);
  }
}
