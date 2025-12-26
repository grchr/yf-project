package org.opensource.service.v2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooCrumbException;
import org.opensource.model.response.profile.YahooCompanyProfile;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;

public class CompanyProfileService extends YahooServiceSync<YahooCompanyProfile> implements IYahooEndpointServiceExecutable {

  public CompanyProfileService() {
    super();
  }

  public CompanyProfileService(OkHttpClient client, String lastUsedCrumb) {
    super(client, lastUsedCrumb);
  }

  @Override
  public YahooCompanyProfile execute(String ticker) {

    try {
      // Get crumb (cookies captured here)
      lastUsedCrumb = getCrumb();
      System.out.println("Crumb: " + lastUsedCrumb);
      // Use crumb + cookies
      String url = prepareUrl(ticker, lastUsedCrumb);
      System.out.println("URL: " + url);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooCompanyProfile.class);
      }
    } catch (IOException e) {
      return new YahooCompanyProfile();
    } catch (YahooCrumbException e) {
      System.out.println("Failed to get crumb: " + e.getMessage());
      return new YahooCompanyProfile();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "assetProfile%2CsecFilings&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true";
    return String.format(
            "https://query2.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
