package org.opensource.service.v2;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.response.profile.YahooCompanyProfile;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyProfileServiceAsyncTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

  @Test
  void companyProfileServiceTest() throws YahooServiceException, ExecutionException, InterruptedException {
    CompanyProfileServiceAsync companyProfileService = new CompanyProfileServiceAsync();
    YahooCompanyProfile result = companyProfileService.executeAsync("BNP.PA").get();
    assertEquals(1, result.getQuoteSummary().getResult().size());
    assertTrue(StringUtils.isNotBlank(result.getQuoteSummary().getResult().get(0).getAssetProfile().getLongBusinessSummary()));
    System.out.println(result);
  }
}
