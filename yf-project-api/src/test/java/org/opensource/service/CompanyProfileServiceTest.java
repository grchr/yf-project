package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.profile.YahooCompanyProfile;

public class CompanyProfileServiceTest {

  @Test
  void companyProfileServiceTest() {
    CompanyProfileService companyProfileService = new CompanyProfileService();
    YahooCompanyProfile result = companyProfileService.execute("BNP.PA");
    System.out.println(result);
  }
}
