package org.opensource.service.v2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.opensource.model.response.IYahooResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Abstract base class for Yahoo service implementations.
 * It is based on the OkHttpClient.
 * TODO: Create async version, put in place fallback executions for switching urls, remove system prints
 * @param <T> the type of Yahoo response
 */
public abstract class YahooService<T extends IYahooResponse> {
  protected static final String USER_AGENT_HEADER = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/143.0.0.0 Safari/537.36";
  protected static final String ACCEPT_HEADER = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
  protected static final String ACCEPT_LANGUAGE_HEADER = "en-US,en;q=0.9";
  protected static final String CONNECTION_HEADER = "keep-alive";
  protected static final String HOME_URL = "https://finance.yahoo.com/";
  protected static final String CRUMB_URL = "https://query2.finance.yahoo.com/v1/test/getcrumb";

  protected final OkHttpClient client;

  protected YahooService() {
    this.client = new OkHttpClient.Builder()
            .cookieJar(new YahooCookieJar())
            .followRedirects(true)
            .build();
  }

  protected abstract String prepareUrl(String ticker, String crumb);

  protected Request buildRequest(String url) {
    return new Request.Builder()
            .url(url)
            .header("User-Agent", USER_AGENT_HEADER)
            .header("Accept", ACCEPT_HEADER)
            .header("Accept-Language", ACCEPT_LANGUAGE_HEADER)
            .header("DNT", "1")
            .header("Connection", CONNECTION_HEADER)
            .build();
  }

  protected String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8);
  }
}

