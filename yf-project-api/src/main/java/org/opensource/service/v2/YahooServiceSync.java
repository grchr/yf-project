package org.opensource.service.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.opensource.exceptions.YahooCrumbException;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.response.IYahooResponse;

import java.io.IOException;

public abstract class YahooServiceSync<T extends IYahooResponse> extends YahooService<T> {

  public YahooServiceSync() {
    super();
  }

  public YahooServiceSync(OkHttpClient client, String lastUsedCrumb) {
    super(client, lastUsedCrumb);
  }

  protected String getCrumb() throws YahooCrumbException {
    // Step 1: Hit Yahoo Finance home to get session cookies
    try {
      if (CollectionUtils.isNotEmpty(client.cookieJar().loadForRequest(HttpUrl.parse(HOME_URL)))
              && StringUtils.isNotEmpty(lastUsedCrumb)) {
        System.out.println("Reusing existing cookies and crumb.");
        return lastUsedCrumb;
      }
      Request homeReq = buildRequest(HOME_URL);
      try (Response homeResp = client.newCall(homeReq).execute()) {
        // discard body, cookies are saved in the jar
        if (homeResp.body() != null) {
          homeResp.body().close();
        }
      }

      System.out.println("Cookies after home request: " + client.cookieJar().loadForRequest(homeReq.url()));
      // Step 2: Request crumb
      Request crumbReq = buildRequest(CRUMB_URL);
      try (Response crumbResp = client.newCall(crumbReq).execute()) {
        System.out.println("Crumb response code: " + crumbResp.code());
        if (!crumbResp.isSuccessful()) {
          throw new YahooCrumbException("Failed to get crumb: " + crumbResp.code());
        }
        return crumbResp.body() != null ? crumbResp.body().string().replace("\"", "") : "";
      }
    } catch (IOException e) {
      throw new YahooCrumbException("Failed to get crumb due to IO error: " + e.getMessage());
    }
  }

  protected T getResult(Response response, Class<T> clazz) throws IOException {
    System.out.println("Response code: " + response.code());
    if (!response.isSuccessful()) {
      throw new IOException("Unexpected code " + response);
    }
    ObjectMapper objectMapper = JsonMapper.get();
    return objectMapper.readValue(response.body().byteStream(), clazz);
  }
}
