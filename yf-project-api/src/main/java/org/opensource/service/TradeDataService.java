package org.opensource.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opensource.model.mapper.JsonMapper;
import org.opensource.model.tradedata.YahooTradeData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class TradeDataService extends YahooService {

  public YahooTradeData execute(String ticker) {
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

      String modules = "fiftyTwoWeekHigh%2CfiftyTwoWeekLow%2CfromCurrency%2CfromExchange%2CheadSymbolAsString%2ClogoUrl%2ClongName%2CmarketCap%2CmessageBoardId%2CoptionsType%2CovernightMarketTime%2CovernightMarketPrice%2CovernightMarketChange%2CovernightMarketChangePercent%2CregularMarketTime%2CregularMarketChange%2CregularMarketChangePercent%2CregularMarketOpen%2CregularMarketPrice%2CregularMarketSource%2CregularMarketVolume%2CpostMarketTime%2CpostMarketPrice%2CpostMarketChange%2CpostMarketChangePercent%2CpreMarketTime%2CpreMarketPrice%2CpreMarketChange%2CpreMarketChangePercent%2CshortName%2CtoCurrency%2CtoExchange%2CunderlyingExchangeSymbol%2CunderlyingSymbol%2CstockStory%2CquartrId&formatted=true&imgHeights=50&imgLabels=logoUrl&imgWidths=50";
      String quoteSummaryUrl = String.format(
              "https://query1.finance.yahoo.com/v7/finance/quote?fields=%s&symbols=%s&enablePrivateCompany=true&overnightPrice=true&topPickThisMonth=true&lang=en-US&region=US&crumb=%s",
              modules, ticker, crumb
      );
      URL dataUrl = new URL(quoteSummaryUrl);
      HttpURLConnection dataConn = (HttpURLConnection) dataUrl.openConnection();
      dataConn.setRequestMethod("GET");
      dataConn.setRequestProperty("User-Agent", "Mozilla/5.0");

      // Reuse the cookie from first request
      if (cookieHeader != null) {
        dataConn.setRequestProperty("Cookie", cookieHeader);
      }

      YahooTradeData result = new YahooTradeData();
      ObjectMapper objectMapper = JsonMapper.get();
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(dataConn.getInputStream()))) {
        result = objectMapper.readValue(reader, YahooTradeData.class);
      }

      return result;
    } catch (IOException e) {
      return new YahooTradeData();
    }
  }
}
