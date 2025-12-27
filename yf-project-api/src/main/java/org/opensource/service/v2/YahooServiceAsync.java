package org.opensource.service.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooAsyncRequestException;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.response.IYahooResponse;
import org.opensource.model.web.YahooCallback;
import org.opensource.model.web.YahooSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public abstract class YahooServiceAsync<T extends IYahooResponse> extends YahooService<T> {

  Logger logger = LoggerFactory.getLogger(YahooServiceAsync.class);

  protected YahooServiceAsync() {
    super();
  }

  protected YahooServiceAsync(YahooSession session) {
    super(session);
  }

  protected CompletableFuture<T> getResultAsync(Request request, Class<T> clazz) {
    CompletableFuture<T> future = new CompletableFuture<>();

    YahooCallback<T> callback = new YahooCallback<>(
            future,
            response -> {
              try {
                return parseResponse(response, clazz);
              } catch (YahooServiceException e) {
                throw new YahooAsyncRequestException("Failed to parse response: ",e);
              }
            },
            "Yahoo Service Async Request"
    );
    session.client().newCall(request).enqueue(callback);

    return future;
  }

  private T parseResponse(Response response, Class<T> clazz) throws YahooServiceException {
    ObjectMapper objectMapper = JsonMapper.get();
    try {
      return objectMapper.readValue(response.body().byteStream(), clazz);
    } catch (IOException e) {
      logger.warn("Yahoo Data Response body parse error");
      throw new YahooServiceException("Response body parse error", e);
    } catch (NullPointerException e) {
      logger.warn("Yahoo Data Response body is null");
      throw new YahooAsyncRequestException("Response body is null", e);
    }
  }
}
