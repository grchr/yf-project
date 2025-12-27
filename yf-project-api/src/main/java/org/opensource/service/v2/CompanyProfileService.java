package org.opensource.service.v2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooServiceException;
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
  public YahooCompanyProfile execute(String ticker) throws YahooServiceException {

    try {
      // Get crumb (cookies captured here)
      lastUsedCrumb = getCrumb();
      // Use crumb + cookies
      String url = prepareUrl(ticker, lastUsedCrumb);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooCompanyProfile.class);
      }
    } catch (IOException e) {
      throw new YahooServiceException("Failed to retrieve data for ticker: " + ticker);
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
