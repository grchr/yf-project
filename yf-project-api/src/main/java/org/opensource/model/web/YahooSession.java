package org.opensource.model.web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.opensource.exceptions.YahooSessionException;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class YahooSession {

  protected static final String HOME_URL = "https://finance.yahoo.com/";
  protected static final String CRUMB_URL = "https://query2.finance.yahoo.com/v1/test/getcrumb";


  private OkHttpClient client;
  private String crumb;
  private AtomicBoolean open;

  protected YahooSession() {
    this.client = ClientFactory.newClient();
  }

  protected YahooSession(OkHttpClient client) {
    this.client = client;
  }

  public OkHttpClient client() {
    return client;
  }

  public String crumb() throws YahooSessionException {
    if (StringUtils.isEmpty(crumb)) {
      crumb = fetchCrumb();
    }
    return crumb;
  }

  private String fetchCrumb() throws YahooSessionException {
    getHomePage();
    return retrieveCrumb();
  }

  private void getHomePage() throws YahooSessionException {
    Request yahooRequest = YahooRequestFactory.createYahooRequest(HOME_URL);
    try (Response response = client.newCall(yahooRequest).execute()) {
      if (!response.isSuccessful()) {
        throw new YahooSessionException("Failed to load yahoo finance home page, response code: " + response.code());
      }
    } catch (IOException e) {
      throw new YahooSessionException("Failed to load yahoo finance home page");
    }
  }

  private String retrieveCrumb() throws YahooSessionException {
    Request crumbRequest = YahooRequestFactory.createYahooRequest(CRUMB_URL);
    try (Response response = client.newCall(crumbRequest).execute()) {
      if (!response.isSuccessful()) {
        throw new YahooSessionException("Failed to retrieve crumb, response code: " + response.code());
      }
      return response.body() != null ? response.body().string().replace("\"", "") : "";
    } catch (IOException e) {
      throw new YahooSessionException("Failed to retrieve crumb");
    }
  }
}
