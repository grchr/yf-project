package org.opensource.model.web;

import okhttp3.OkHttpClient;

public class YahooSessionFactory {

  private YahooSessionFactory() {
    // Private constructor to prevent instantiation
  }

  public static YahooSession getYahooSession() {
    return new YahooSession();
  }

  public static YahooSession getYahooSession(OkHttpClient client) {
    return new YahooSession(client);
  }
}
