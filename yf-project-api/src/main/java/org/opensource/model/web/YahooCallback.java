package org.opensource.model.web;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.opensource.exceptions.YahooSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class YahooCallback<T> implements Callback {
  private static final Logger logger = LoggerFactory.getLogger(YahooCallback.class);

  private final CompletableFuture<T> future;
  private final Function<Response, T> responseHandler;
  private final String errorContext;

  public YahooCallback(CompletableFuture<T> future, Function<Response, T> responseHandler, String errorContext) {
    this.future = future;
    this.responseHandler = responseHandler;
    this.errorContext = errorContext;
  }

  @Override
  public void onFailure(Call call, IOException e) {
    logger.error("{} failed", errorContext, e);
    future.completeExceptionally(new YahooSessionException(errorContext + " failed", e));
  }

  @Override
  public void onResponse(Call call, Response response) {
    try (response) {
      if (!response.isSuccessful()) {
        logger.warn("{} unsuccessful response: {}", errorContext, response);
        future.completeExceptionally(
                new YahooSessionException(errorContext + " failed, response code: " + response.code())
        );
        return;
      }

      try {
        T result = responseHandler.apply(response);
        future.complete(result);
      } catch (Exception e) {
        logger.error("Error processing {} response", errorContext, e);
        future.completeExceptionally(new YahooSessionException("Failed to process " + errorContext + " response", e));
      }
    }
  }
}
