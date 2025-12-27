package org.opensource.model.web;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YahooCookieJar implements CookieJar {
  private final Map<String, List<Cookie>> cookies = new HashMap<>();

  @Override
  public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
    this.cookies.put(url.host(), cookies);
  }

  @Override
  public List<Cookie> loadForRequest(HttpUrl url) {
    List<Cookie> valid = new ArrayList<>();
    for (Map.Entry<String, List<Cookie>> entry : cookies.entrySet()) {
      String domain = entry.getKey();
      if (url.host().endsWith(domain)) {  // subdomain match
        for (Cookie cookie : entry.getValue()) {
          if (cookie.expiresAt() >= System.currentTimeMillis()) {
            valid.add(cookie);
          }
        }
      }
    }
    return valid;
  }

  public void clear() {
    cookies.clear();
  }
}
