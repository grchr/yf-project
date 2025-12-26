package org.opensource.service.v2;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;
import org.opensource.model.response.charts.YahooEventChart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

  @Test
  void chartServiceTestSequentialRequests() {
    ChartsService chartService = new ChartsService();
    YahooEventChart aapl = chartService.execute("AAPL");
    assertEquals(1, aapl.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(aapl.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(aapl.getChart().getResult().get(0).getIndicators());
    assertNotNull(aapl.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(aapl);
    YahooEventChart msft = chartService.execute("MSFT");
    assertEquals(1, msft.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(msft.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(msft.getChart().getResult().get(0).getIndicators());
    assertNotNull(msft.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(msft.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(msft.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(msft);
  }

  @Test
  void chartServiceTestSequentialRequestsDataInjection() {
    ChartsService chartService = new ChartsService();
    YahooEventChart aapl = chartService.execute("AAPL");
    assertEquals(1, aapl.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(aapl.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(aapl.getChart().getResult().get(0).getIndicators());
    assertNotNull(aapl.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getSplits()));
    String applCrumb = chartService.getLastUsedCrumb();
    System.out.println(aapl);
    ChartsService msftService = new ChartsService();
    YahooEventChart msft = msftService.execute("MSFT");
    assertEquals(1, msft.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(msft.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(msft.getChart().getResult().get(0).getIndicators());
    assertNotNull(msft.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(msft.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(msft.getChart().getResult().get(0).getEvents().getSplits()));
    String msftCrumb = msftService.getLastUsedCrumb();
    assertNotEquals(applCrumb, msftCrumb);
    System.out.println(msft);
    ChartsService injectedChartService = new ChartsService(msftService.getClient(), msftService.getLastUsedCrumb());
    YahooEventChart googl = injectedChartService.execute("GOOGL");
    assertEquals(1, googl.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(googl.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(googl.getChart().getResult().get(0).getIndicators());
    assertNotNull(googl.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(googl.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(googl.getChart().getResult().get(0).getEvents().getSplits()));
    String googlCrumb = injectedChartService.getLastUsedCrumb();
    assertEquals(msftCrumb, googlCrumb);
    System.out.println(googl);
  }
}
