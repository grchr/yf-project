package org.opensource.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opensource.model.financials.YahooFinancials;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.profile.YahooCompanyProfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ProfileService extends YahooService {

  public YahooCompanyProfile execute(String ticker) {
    try {
      URL crumbURL = new URL(crumbUrl);
      HttpURLConnection crumbConn = (HttpURLConnection) crumbURL.openConnection();
      crumbConn.setRequestMethod("GET");
      crumbConn.setRequestProperty("User-Agent", "Mozilla/5.0");
      String crumb;
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(crumbConn.getInputStream()))) {
        crumb = reader.readLine().replace("\"", "");
      }

      String cookieHeader = null;
      // Capture cookies from the first response
      Map<String, List<String>> headerFields = crumbConn.getHeaderFields();
      List<String> cookies = headerFields.get("Set-Cookie");
      if (cookies != null && !cookies.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (String cookie : cookies) {
          sb.append(cookie.split(";", 2)[0]).append("; ");
        }
        cookieHeader = sb.toString();
      }

      String modules = "assetProfile%2CsecFilings&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true";
      String quoteSummaryUrl = String.format(
              "https://query1.finance.yahoo.com/v10/finance/quoteSummary/%s?formatted=true&modules=%s&lang=en-US&region=US&crumb=%s",
              ticker, modules, crumb
      );
      URL dataUrl = new URL(quoteSummaryUrl);
      HttpURLConnection dataConn = (HttpURLConnection) dataUrl.openConnection();
      dataConn.setRequestMethod("GET");
      dataConn.setRequestProperty("User-Agent", "Mozilla/5.0");

      // Reuse the cookie from first request
      if (cookieHeader != null) {
        dataConn.setRequestProperty("Cookie", cookieHeader);
      }

      YahooCompanyProfile result = new YahooCompanyProfile();
      ObjectMapper objectMapper = JsonMapper.get();
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(dataConn.getInputStream()))) {
        result = objectMapper.readValue(reader, YahooCompanyProfile.class);
      }

      return result;
    } catch (IOException e) {
      return new YahooCompanyProfile();
    }
  }
}
