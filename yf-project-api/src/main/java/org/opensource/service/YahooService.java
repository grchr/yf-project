package org.opensource.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opensource.model.IYahooResponse;
import org.opensource.model.mapper.JsonMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

public abstract class YahooService<T extends IYahooResponse> {

  protected final String crumbUrl = "https://query1.finance.yahoo.com/v1/test/getcrumb";

  protected abstract String prepareUrl(String ticker, String crumb) throws UnsupportedEncodingException;

  protected HttpURLConnection getHttpURLConnection(String url) throws IOException {
    URL crumbURL = new URL(url);
    HttpURLConnection crumbConn = (HttpURLConnection) crumbURL.openConnection();
    crumbConn.setRequestMethod("GET");
    crumbConn.setRequestProperty("User-Agent", "Mozilla/5.0");
    return crumbConn;
  }

  protected String retrieveCookies(HttpURLConnection connection) {
    String cookieHeader = null;
    // Capture cookies from the response
    Map<String, List<String>> headerFields = connection.getHeaderFields();
    List<String> cookies = headerFields.get("Set-Cookie");
    if (cookies != null && !cookies.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      for (String cookie : cookies) {
        sb.append(cookie.split(";", 2)[0]).append("; ");
      }
      cookieHeader = sb.toString();
    }
    return cookieHeader;
  }

  protected T getResult(HttpURLConnection dataConn, Class<T> clazz) throws IOException {
    ObjectMapper objectMapper = JsonMapper.get();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(dataConn.getInputStream()))) {
      return objectMapper.readValue(reader, clazz);
    }
  }

  protected void updateConnectionWithHeaders(String cookieHeader, HttpURLConnection dataConn) {
    // Reuse the cookie from first request
    if (cookieHeader != null) {
      dataConn.setRequestProperty("Cookie", cookieHeader);
    }
  }

  protected String encode(String value) throws UnsupportedEncodingException {
    return URLEncoder.encode(value, "UTF-8");
  }

  protected String getCrumb(HttpURLConnection crumbConn) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(crumbConn.getInputStream()))) {
      return reader.readLine().replace("\"", "");
    }
  }

}
