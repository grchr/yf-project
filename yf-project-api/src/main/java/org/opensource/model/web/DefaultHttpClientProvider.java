package org.opensource.model.web;

import java.net.http.HttpClient;

public class DefaultHttpClientProvider {

  public static final HttpClient DEFAULT = HttpClient.newBuilder()
          .version(HttpClient.Version.HTTP_2)
          .build();

  private DefaultHttpClientProvider() {
    // Prevent instantiation
  }
}
