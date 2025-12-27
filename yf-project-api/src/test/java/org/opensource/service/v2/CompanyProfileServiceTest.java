package org.opensource.service.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.profile.YahooCompanyProfile;
import org.opensource.service.v2.CompanyProfileService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompanyProfileServiceTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

  @Test
  void companyProfileServiceTest() throws YahooServiceException {
    CompanyProfileService companyProfileService = new CompanyProfileService();
    YahooCompanyProfile result = companyProfileService.execute("BNP.PA");
    assertEquals(1, result.getQuoteSummary().getResult().size());
    assertTrue(StringUtils.isNotBlank(result.getQuoteSummary().getResult().get(0).getAssetProfile().getLongBusinessSummary()));
    System.out.println(result);
  }
}
