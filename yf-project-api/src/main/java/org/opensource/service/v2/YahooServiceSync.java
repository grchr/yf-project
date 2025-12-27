package org.opensource.service.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.response.IYahooResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class YahooServiceSync<T extends IYahooResponse> extends YahooService<T> {

  Logger logger = LoggerFactory.getLogger(YahooServiceSync.class);

  protected YahooServiceSync() {
    super();
  }

  protected YahooServiceSync(OkHttpClient client, String lastUsedCrumb) {
    super(client, lastUsedCrumb);
  }

  protected String getCrumb() throws IOException {
    // Step 1: Hit Yahoo Finance home to get session cookies
    try {
      if (CollectionUtils.isNotEmpty(client.cookieJar().loadForRequest(HttpUrl.parse(HOME_URL)))
              && StringUtils.isNotEmpty(lastUsedCrumb)) {
        logger.debug("Reusing existing cookies and crumb.");
        return lastUsedCrumb;
      }
      Request homeReq = buildRequest(HOME_URL);
      try (Response homeResp = client.newCall(homeReq).execute()) {
        // discard body, cookies are saved in the jar
        if (homeResp.body() != null) {
          homeResp.body().close();
        }
      }

      logger.debug("Cookies after home request: {}", client.cookieJar().loadForRequest(homeReq.url()));
      // Step 2: Request crumb
      Request crumbReq = buildRequest(CRUMB_URL);
      try (Response crumbResp = client.newCall(crumbReq).execute()) {
        logger.debug("Crumb response code: {}", crumbResp.code());
        if (!crumbResp.isSuccessful()) {
          throw new IOException("Failed to get crumb: " + crumbResp.code());
        }
        return crumbResp.body() != null ? crumbResp.body().string().replace("\"", "") : "";
      }
    } catch (IOException e) {
      logger.warn("Failed to obtain crumb");
      throw new IOException("Failed to obtain crumb", e);
    }
  }

  protected T getResult(Response response, Class<T> clazz) throws IOException {
    if (!response.isSuccessful()) {
      logger.warn("Unsuccessful response: {}", response);
      throw new IOException("Unexpected response " + response);
    }
    ObjectMapper objectMapper = JsonMapper.get();
    try {
      return objectMapper.readValue(response.body().byteStream(), clazz);
    } catch (NullPointerException e) {
      logger.warn("Yahoo Data Response body is null");
      throw new IOException("Response body is null", e);
    }
  }
}
