package org.opensource.model.web;

import okhttp3.Request;

public class YahooRequestFactory {

  protected static final String USER_AGENT_HEADER = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/143.0.0.0 Safari/537.36";
  protected static final String ACCEPT_HEADER = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
  protected static final String ACCEPT_LANGUAGE_HEADER = "en-US,en;q=0.9";
  protected static final String CONNECTION_HEADER = "keep-alive";

  private YahooRequestFactory() {
    // Prevent instantiation
  }

  public static Request createYahooRequest(String url) {
    return new Request.Builder()
            .url(url)
            .header("User-Agent", USER_AGENT_HEADER)
            .header("Accept", ACCEPT_HEADER)
            .header("Accept-Language", ACCEPT_LANGUAGE_HEADER)
            .header("DNT", "1")
            .header("Connection", CONNECTION_HEADER)
            .build();
  }
}
