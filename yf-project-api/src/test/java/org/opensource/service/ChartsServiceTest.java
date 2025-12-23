package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;
import org.opensource.model.charts.YahooChart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChartsServiceTest {

  //TODO: implements tests

  @Test
  void chartServiceTest() {
    ChartsService chartService = new ChartsService();
    YahooChart result = chartService.execute("BNP.PA");
    assertEquals(1, result.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(result.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(result.getChart().getResult().get(0).getIndicators());
    assertNotNull(result.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(result.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(result.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(result);
  }
}
