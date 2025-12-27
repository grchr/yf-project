package org.opensource.service.v2;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.exceptions.YahooSessionException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.web.YahooSession;
import org.opensource.model.web.YahooSessionFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChartsServiceTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

  @Test
  void chartServiceTest() throws YahooServiceException {
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
  void chartServiceTestSequentialRequests() throws YahooServiceException {
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
  void chartServiceTestSequentialRequestsDataInjection() throws YahooServiceException, YahooSessionException {
    YahooSession session = YahooSessionFactory.getYahooSession();
    ChartsService chartService = new ChartsService(session);
    YahooEventChart aapl = chartService.execute("AAPL");
    assertEquals(1, aapl.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(aapl.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(aapl.getChart().getResult().get(0).getIndicators());
    assertNotNull(aapl.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(aapl);
    String crumbAfterAapl = session.crumb();
    YahooEventChart msft = chartService.execute("MSFT");
    assertEquals(1, msft.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(msft.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(msft.getChart().getResult().get(0).getIndicators());
    assertNotNull(msft.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(msft.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(msft.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(msft);
    String crumbAfterMsft = session.crumb();
    assertEquals(crumbAfterAapl, crumbAfterMsft);
    YahooSession newSession = YahooSessionFactory.getYahooSession();
    ChartsService chartServiceNewSession = new ChartsService(newSession);
    YahooEventChart bnp = chartServiceNewSession.execute("BNP.PA");
    assertEquals(1, bnp.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(bnp.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(bnp.getChart().getResult().get(0).getIndicators());
    assertNotNull(bnp.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(bnp.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(bnp.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(bnp);
    assertNotEquals(newSession.crumb(), crumbAfterMsft);
  }
}
