package org.opensource.service.v2;

import okhttp3.OkHttpClient;

public final class ClientFactory {

  public static OkHttpClient newClient() {
    return new OkHttpClient.Builder()
            .cookieJar(new YahooCookieJar())
            .followRedirects(true)
            .build();
  }
}
