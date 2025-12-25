package org.opensource.model.web;

import org.opensource.model.web.CrumbCookie;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class YahooSession {

  private static final String CRUMB_URL =
          "https://query1.finance.yahoo.com/v1/test/getcrumb";

  private static final String WARMUP_URL =
          "https://finance.yahoo.com";

  private static final String USER_AGENT =
          "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                  "AppleWebKit/537.36 (KHTML, like Gecko) " +
                  "Chrome/120.0.0.0 Safari/537.36";

  private final HttpClient client;
  private final CookieManager cookieManager;

  private String crumb;

  /**
   * Default constructor
   */
  public YahooSession() {
    this.cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
    this.client = HttpClient.newBuilder()
            .cookieHandler(cookieManager)
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .version(HttpClient.Version.HTTP_2)
            .build();
  }

  /**
   * Users can supply their own HttpClient
   */
  public YahooSession(HttpClient client, CookieManager cookieManager) {
    this.client = client;
    this.cookieManager = cookieManager;
  }

  public HttpClient client() {
    return client;
  }

  public synchronized CrumbCookie getCrumbCookie()
          throws IOException, InterruptedException {

    if (crumb == null) {
      warmUp();
      fetchCrumb();
    }
    return new CrumbCookie(crumb, null); // cookies handled automatically
  }

  private void warmUp() throws IOException, InterruptedException {
    HttpRequest warmup = HttpRequest.newBuilder()
            .uri(URI.create(WARMUP_URL))
            .header("User-Agent", USER_AGENT)
            .GET()
            .build();

    client.send(warmup, HttpResponse.BodyHandlers.discarding());
  }

  private void fetchCrumb() throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(CRUMB_URL))
            .header("User-Agent", USER_AGENT)
            .GET()
            .build();

    HttpResponse<String> response =
            client.send(request, HttpResponse.BodyHandlers.ofString());

    if (response.statusCode() != 200) {
      throw new IOException("Failed to retrieve crumb: " + response.statusCode());
    }

    this.crumb = response.body().replace("\"", "");
  }

  /**
   * Allows refresh if Yahoo invalidates the crumb mid-session
   */
  public synchronized void invalidateCrumb() {
    this.crumb = null;
  }

  public static String userAgent() {
    return USER_AGENT;
  }
}

