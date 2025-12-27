package org.opensource.service.v2;

import org.opensource.model.response.IYahooResponse;
import org.opensource.model.web.YahooSession;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Abstract base class for Yahoo service implementations.
 * It is based on the OkHttpClient.
 * TODO: Create async version, put in place fallback executions for switching urls, add supermodel and superservice
 * @param <T> the type of Yahoo response
 */
public abstract class YahooService<T extends IYahooResponse> {

  protected YahooSession session;

  protected YahooService() {
    // Default constructor
  }

  protected YahooService(YahooSession session) {
    this.session = session;
  }

  protected abstract String prepareUrl(String ticker, String crumb);

  protected String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8);
  }

}

