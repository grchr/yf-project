package org.opensource.service;

import org.opensource.model.tradedata.YahooTradeData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

public class TradeDataService extends YahooService<YahooTradeData> implements IYahooEndpointServiceExecutable {

  public YahooTradeData execute(String ticker) {
    try {
      HttpURLConnection crumbConn = getHttpURLConnection(crumbUrl);
      String crumb = getCrumb(crumbConn);
      String cookieHeader = retrieveCookies(crumbConn);
      String quoteSummaryUrl = prepareUrl(ticker, crumb);
      HttpURLConnection dataConn = getHttpURLConnection(quoteSummaryUrl);
      updateConnectionWithHeaders(cookieHeader, dataConn);
      return getResult(dataConn, YahooTradeData.class);
    } catch (IOException e) {
      return new YahooTradeData();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) throws UnsupportedEncodingException {
    String modules = "fiftyTwoWeekHigh%2CfiftyTwoWeekLow%2CfromCurrency%2CfromExchange%2CheadSymbolAsString%2ClogoUrl%2ClongName%2CmarketCap%2CmessageBoardId%2CoptionsType%2CovernightMarketTime%2CovernightMarketPrice%2CovernightMarketChange%2CovernightMarketChangePercent%2CregularMarketTime%2CregularMarketChange%2CregularMarketChangePercent%2CregularMarketOpen%2CregularMarketPrice%2CregularMarketSource%2CregularMarketVolume%2CpostMarketTime%2CpostMarketPrice%2CpostMarketChange%2CpostMarketChangePercent%2CpreMarketTime%2CpreMarketPrice%2CpreMarketChange%2CpreMarketChangePercent%2CshortName%2CtoCurrency%2CtoExchange%2CunderlyingExchangeSymbol%2CunderlyingSymbol%2CstockStory%2CquartrId&formatted=true&imgHeights=50&imgLabels=logoUrl&imgWidths=50";
    return String.format(
            "https://query1.finance.yahoo.com/v7/finance/quote?symbols=%s&fields=%s&enablePrivateCompany=true&overnightPrice=true&topPickThisMonth=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
