package org.opensource.model.web;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.opensource.exceptions.YahooAsyncRequestException;
import org.opensource.exceptions.YahooSessionException;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class YahooSession {

  protected static final String HOME_URL = "https://finance.yahoo.com/";
  protected static final String CRUMB_URL = "https://query2.finance.yahoo.com/v1/test/getcrumb";

  private OkHttpClient client;
  private AtomicReference<String> crumb;
  private final ReentrantLock crumbLock = new ReentrantLock();
  private CompletableFuture<String> pendingCrumbFetch;

  protected YahooSession() {
    this.client = ClientFactory.newClient();
    this.crumb = new AtomicReference<>();
  }

  protected YahooSession(OkHttpClient client) {
    this.client = client;
    this.crumb = new AtomicReference<>();
  }

  public OkHttpClient client() {
    return client;
  }

  public String crumb() throws YahooSessionException {
    if (StringUtils.isNotEmpty(crumb.get())) {
      return crumb.get();
    }
    crumbLock.lock();
    try {
      // Double-check pattern - crumb might have been fetched while waiting for lock
      if (StringUtils.isNotEmpty(crumb.get())) {
        return crumb.get();
      }
      // Check if an async fetch is in progress
      if (pendingCrumbFetch != null && !pendingCrumbFetch.isDone()) {
        try {
          // Wait for the async fetch to complete
          return pendingCrumbFetch.join();
        } catch (Exception e) {
          // If async fetch failed, try sync fetch
          return fetchCrumbSync();
        }
      }
      // No async fetch in progress, do sync fetch
      return fetchCrumbSync();
    } finally {
      crumbLock.unlock();
    }
  }

  public CompletableFuture<String> crumbAsync() {
    if (StringUtils.isNotEmpty(crumb.get())) {
      return CompletableFuture.completedFuture(crumb.get());
    }
    crumbLock.lock();
    try {
      // Double-check pattern
      if (StringUtils.isNotEmpty(crumb.get())) {
        return CompletableFuture.completedFuture(crumb.get());
      }
      // If a fetch is already in progress, return the same future
      if (pendingCrumbFetch != null && !pendingCrumbFetch.isDone()) {
        return pendingCrumbFetch;
      }
      // Start a new async fetch
      pendingCrumbFetch = fetchCrumbAsync();
      return pendingCrumbFetch;
    } finally {
      crumbLock.unlock();
    }
  }

  private String fetchCrumbSync() throws YahooSessionException {
    getHomePage();
    String fetchedCrumb = retrieveCrumb();
    this.crumb.set(fetchedCrumb);
    return fetchedCrumb;
  }

  private CompletableFuture<String> fetchCrumbAsync() {
    return getHomePageAsync()
            .thenCompose(v -> retrieveCrumbAsync())
            .whenComplete((result, throwable) -> {
              if (result != null) {
                this.crumb.set(result);
              }
              // Clear pending fetch reference after completion
              crumbLock.lock();
              try {
                if (pendingCrumbFetch != null && pendingCrumbFetch.isDone()) {
                  pendingCrumbFetch = null;
                }
              } finally {
                crumbLock.unlock();
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
      throw new YahooSessionException("Failed to load yahoo finance home page", e);
    }
  }

  private CompletableFuture<Void> getHomePageAsync() {
    CompletableFuture<Void> future = new CompletableFuture<>();
    Request yahooRequest = YahooRequestFactory.createYahooRequest(HOME_URL);
    YahooCallback<Void> callback = new YahooCallback<>(
            future,
            response -> null,
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
      throw new YahooSessionException("Failed to retrieve crumb", e);
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
