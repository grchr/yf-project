package org.opensource.model.web;

import okhttp3.OkHttpClient;
import org.opensource.model.web.YahooCookieJar;

public final class ClientFactory {

  private ClientFactory() {
    // Prevent instantiation
  }

  public static OkHttpClient newClient() {
    return new OkHttpClient.Builder()
            .cookieJar(new YahooCookieJar())
            .followRedirects(true)
            .build();
  }
}
