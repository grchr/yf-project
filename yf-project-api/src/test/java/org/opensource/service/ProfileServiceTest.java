package org.opensource.service;

import org.junit.jupiter.api.Test;
import org.opensource.model.profile.YahooCompanyProfile;

public class ProfileServiceTest {

  @Test
  void companyProfileServiceTest() {
    ProfileService profileService = new ProfileService();
    YahooCompanyProfile result = profileService.execute("BNP.PA");
    System.out.println(result);
  }
}
