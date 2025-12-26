package org.opensource.service.v2;

import okhttp3.Request;
import okhttp3.Response;
import org.opensource.exceptions.YahooCrumbException;
import org.opensource.model.response.tradedata.YahooTradeData;
import org.opensource.service.IYahooEndpointServiceExecutable;

import java.io.IOException;

public class TradeDataService extends YahooServiceSync<YahooTradeData> implements IYahooEndpointServiceExecutable {

  public TradeDataService() {
    super();
  }

  public TradeDataService(okhttp3.OkHttpClient client, String lastUsedCrumb) {
    super(client, lastUsedCrumb);
  }

  @Override
  public YahooTradeData execute(String ticker) {

    try {
      // Get crumb (cookies captured here)
      lastUsedCrumb = getCrumb();
      System.out.println("Crumb: " + lastUsedCrumb);
      // Use crumb + cookies
      String url = prepareUrl(ticker, lastUsedCrumb);
      System.out.println("URL: " + url);
      Request request = buildRequest(url);

      try (Response response = client.newCall(request).execute()) {
        return getResult(response, YahooTradeData.class);
      }
    } catch (IOException e) {
      return new YahooTradeData();
    } catch (YahooCrumbException e) {
      System.out.println("Failed to get crumb: " + e.getMessage());
      return new YahooTradeData();
    }
  }

  @Override
  protected String prepareUrl(String ticker, String crumb) {
    String modules = "fiftyTwoWeekHigh%2CfiftyTwoWeekLow%2CfromCurrency%2CfromExchange%2CheadSymbolAsString%2ClogoUrl%2ClongName%2CmarketCap%2CmessageBoardId%2CoptionsType%2CovernightMarketTime%2CovernightMarketPrice%2CovernightMarketChange%2CovernightMarketChangePercent%2CregularMarketTime%2CregularMarketChange%2CregularMarketChangePercent%2CregularMarketOpen%2CregularMarketPrice%2CregularMarketSource%2CregularMarketVolume%2CpostMarketTime%2CpostMarketPrice%2CpostMarketChange%2CpostMarketChangePercent%2CpreMarketTime%2CpreMarketPrice%2CpreMarketChange%2CpreMarketChangePercent%2CshortName%2CtoCurrency%2CtoExchange%2CunderlyingExchangeSymbol%2CunderlyingSymbol%2CstockStory%2CquartrId&formatted=true&imgHeights=50&imgLabels=logoUrl&imgWidths=50";
    return String.format(
            "https://query2.finance.yahoo.com/v7/finance/quote?symbols=%s&fields=%s&enablePrivateCompany=true&overnightPrice=true&topPickThisMonth=true&lang=en-US&region=US&crumb=%s",
            encode(ticker), modules, encode(crumb)
    );
  }
}
