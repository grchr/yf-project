package org.opensource.service.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import okhttp3.Response;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.response.IYahooResponse;

import java.io.IOException;

public abstract class YahooServiceSync<T extends IYahooResponse> extends YahooService<T> {

  protected String getCrumb() throws IOException {
    // Step 1: Hit Yahoo Finance home to get session cookies
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
        throw new IOException("Failed to get crumb: " + crumbResp.code());
      }
      return crumbResp.body() != null ? crumbResp.body().string().replace("\"", "") : "";
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
