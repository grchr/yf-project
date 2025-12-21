package org.opensource.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opensource.model.fundamentals.YahooFundamentals;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.profile.YahooCompanyProfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class FundamentalsService extends YahooService {

  public YahooFundamentals execute(String ticker) {
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

      String modules = "annualTotalRevenue,annualNetIncome,annualOperatingIncome";
      long period2 = Instant.now().getEpochSecond();
      String quoteSummaryUrl = String.format(
              "https://query2.finance.yahoo.com/ws/fundamentals-timeseries/v1/finance/timeseries/%s?symbol=%s&type=%s&period1=0&period2=%s&crumb=%s",
              ticker, ticker, modules, period2, crumb
      );
      URL dataUrl = new URL(quoteSummaryUrl);
      HttpURLConnection dataConn = (HttpURLConnection) dataUrl.openConnection();
      dataConn.setRequestMethod("GET");
      dataConn.setRequestProperty("User-Agent", "Mozilla/5.0");

      // Reuse the cookie from first request
      if (cookieHeader != null) {
        dataConn.setRequestProperty("Cookie", cookieHeader);
      }

      YahooFundamentals result = new YahooFundamentals();
      ObjectMapper objectMapper = JsonMapper.get();
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(dataConn.getInputStream()))) {
        result = objectMapper.readValue(reader, YahooFundamentals.class);
      }

      return result;
    } catch (IOException e) {
      return new YahooFundamentals();
    }
  }

}
