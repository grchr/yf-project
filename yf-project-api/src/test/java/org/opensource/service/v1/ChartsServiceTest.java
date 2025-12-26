package org.opensource.service.v1;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.response.profile.YahooCompanyProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChartsServiceTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }


  @Test
  void chartServiceTest() {
    ChartsService chartService = new ChartsService();
    YahooEventChart result = chartService.execute("BNP.PA");
    assertEquals(1, result.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(result.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(result.getChart().getResult().get(0).getIndicators());
    assertNotNull(result.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(result.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(result.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(result);
    CompanyProfileService companyProfileService = new CompanyProfileService(chartService.getLastUsedCrumbCookie());
    YahooCompanyProfile companyProfile = companyProfileService.execute("BNP.PA");
    System.out.println(companyProfile);
  }

  @Test
  void chartServiceTestSequentialRequest() {
    ChartsService chartService = new ChartsService();
    YahooEventChart bnp = chartService.execute("BNP.PA");
    assertEquals(1, bnp.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(bnp.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(bnp.getChart().getResult().get(0).getIndicators());
    assertNotNull(bnp.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(bnp.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(bnp.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(bnp);
    YahooEventChart aapl = chartService.execute("AAPL");
    assertEquals(1, aapl.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(aapl.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(aapl.getChart().getResult().get(0).getIndicators());
    assertNotNull(aapl.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(aapl);
  }

  @Test
  void chartServiceTestSequentialRequestsDataInjection() {
    ChartsService bnpService = new ChartsService();
    YahooEventChart bnp = bnpService.execute("BNP.PA");
    assertEquals(1, bnp.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(bnp.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(bnp.getChart().getResult().get(0).getIndicators());
    assertNotNull(bnp.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(bnp.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(bnp.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(bnp);
    ChartsService applService = new ChartsService();
    YahooEventChart aapl = applService.execute("AAPL");
    assertEquals(1, aapl.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(aapl.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(aapl.getChart().getResult().get(0).getIndicators());
    assertNotNull(aapl.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(aapl.getChart().getResult().get(0).getEvents().getSplits()));
    System.out.println(aapl);
    ChartsService googlService = new ChartsService(bnpService.getLastUsedCrumbCookie());
    YahooEventChart googl = googlService.execute("GOOGL");
    assertEquals(1, googl.getChart().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(googl.getChart().getResult().get(0).getTimestamp()));
    assertNotNull(googl.getChart().getResult().get(0).getIndicators());
    assertNotNull(googl.getChart().getResult().get(0).getMeta());
    assertTrue(MapUtils.isNotEmpty(googl.getChart().getResult().get(0).getEvents().getDividends()));
    assertTrue(MapUtils.isNotEmpty(googl.getChart().getResult().get(0).getEvents().getSplits()));
    assertEquals(bnpService.getLastUsedCrumbCookie(), googlService.getLastUsedCrumbCookie());
    System.out.println(googl);
  }
}
