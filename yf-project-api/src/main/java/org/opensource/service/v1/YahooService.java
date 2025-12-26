package org.opensource.service.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.response.IYahooResponse;
import org.opensource.model.web.CrumbCookie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * Abstract base class for Yahoo service implementations.
 * It is based on the legacy HttpURLConnection to enable integration with older Java systems.
 * @param <T> the type of Yahoo response
 */
public abstract class YahooService<T extends IYahooResponse> {

  protected final String crumbUrl = "https://query1.finance.yahoo.com/v1/test/getcrumb";
  protected CrumbCookie lastUsedCrumbCookie;

  protected YahooService() {
  }

  protected YahooService(CrumbCookie lastUsedCrumbCookie) {
    this.lastUsedCrumbCookie = lastUsedCrumbCookie;
  }

  protected abstract String prepareUrl(String ticker, String crumb);

  protected HttpURLConnection getHttpURLConnection(String url) throws IOException {
    URL crumbURL = new URL(url);
    HttpURLConnection crumbConn = (HttpURLConnection) crumbURL.openConnection();
    crumbConn.setRequestMethod("GET");
    crumbConn.setRequestProperty("User-Agent", "Mozilla/5.0");
    return crumbConn;
  }

  protected CrumbCookie getCrumbCookie(HttpURLConnection crumbConn) throws IOException {
    String crumb = getCrumb(crumbConn);
    String cookieHeader = retrieveCookies(crumbConn);
    return new CrumbCookie(crumb, cookieHeader);
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

  protected String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8);
  }

  private String getCrumb(HttpURLConnection crumbConn) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(crumbConn.getInputStream()))) {
      return reader.readLine().replace("\"", "");
    }
  }

  private String retrieveCookies(HttpURLConnection connection) {
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

  public CrumbCookie getLastUsedCrumbCookie() {
    return lastUsedCrumbCookie;
  }
}
