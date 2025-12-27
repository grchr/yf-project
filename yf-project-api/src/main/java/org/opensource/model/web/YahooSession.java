package org.opensource.model.web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.opensource.exceptions.YahooAsyncRequestException;
import org.opensource.exceptions.YahooSessionException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class YahooSession {

  protected static final String HOME_URL = "https://finance.yahoo.com/";
  protected static final String CRUMB_URL = "https://query2.finance.yahoo.com/v1/test/getcrumb";


  private OkHttpClient client;
  private AtomicReference<String> crumb;
  private AtomicBoolean open;
  private AtomicBoolean crumbFetching;

  protected YahooSession() {
    this.client = ClientFactory.newClient();
    this.crumb = new AtomicReference<>();
    this.crumbFetching = new AtomicBoolean(false);
  }

  protected YahooSession(OkHttpClient client) {
    this.client = client;
    this.crumb = new AtomicReference<>();
    this.crumbFetching = new AtomicBoolean(false);
  }

  public OkHttpClient client() {
    return client;
  }

  public String crumb() throws YahooSessionException {
    if (StringUtils.isEmpty(crumb.get())) {
      crumb.set(fetchCrumb());
    }
    return crumb.get();
  }

  public CompletableFuture<String> crumbAsync() {
    String currentCrumb = crumb.get();
    if (StringUtils.isNotEmpty(currentCrumb)) {
      return CompletableFuture.completedFuture(currentCrumb);
    }
    if (!crumbFetching.compareAndSet(false, true)) {
      // Another fetch is in progress, wait for it to complete
      return CompletableFuture.supplyAsync(() -> {
        while (crumbFetching.get()) {
          try {
            Thread.sleep(10); // Wait briefly
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new YahooAsyncRequestException("Interrupted while waiting for crumb", e);
          }
        }
        return crumb.get();
      });
    }

    return fetchCrumbAsync()
            .whenComplete((result, throwable) -> crumbFetching.set(false));
  }

  private String fetchCrumb() throws YahooSessionException {
    getHomePage();
    return retrieveCrumb();
  }

  private CompletableFuture<String> fetchCrumbAsync() {
    return getHomePageAsync()
            .thenCompose(v -> retrieveCrumbAsync())
            .whenComplete((result, throwable) -> {
              if (result != null) {
                crumb.set(result);
              }
            });
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

  private CompletableFuture<Void> getHomePageAsync() {
    CompletableFuture<Void> future = new CompletableFuture<>();
    Request yahooRequest = YahooRequestFactory.createYahooRequest(HOME_URL);

    YahooCallback<Void> callback = new YahooCallback<>(
            future,
            response -> null, // No response processing needed, just success
            "Load Yahoo Finance home page"
    );

    client.newCall(yahooRequest).enqueue(callback);
    return future;
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

  private CompletableFuture<String> retrieveCrumbAsync() {
    CompletableFuture<String> future = new CompletableFuture<>();
    Request crumbRequest = YahooRequestFactory.createYahooRequest(CRUMB_URL);

    YahooCallback<String> callback = new YahooCallback<>(
            future,
            response -> {
              try {
                return response.body() != null ? response.body().string().replace("\"", "") : "";
              } catch (IOException e) {
                throw new YahooAsyncRequestException("Failed to read crumb response body", e);
              }
            },
            "Retrieve crumb"
    );

    client.newCall(crumbRequest).enqueue(callback);
    return future;
  }
}
