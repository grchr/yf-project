package org.opensource.service.v2;

import okhttp3.Request;
import org.opensource.exceptions.YahooAsyncRequestException;
import org.opensource.exceptions.YahooServiceException;
import org.opensource.model.response.charts.YahooEventChart;
import org.opensource.model.response.fundamentals.YahooFundamentals;
import org.opensource.model.response.tradedata.YahooTradeData;
import org.opensource.model.web.YahooRequestFactory;
import org.opensource.model.web.YahooSessionFactory;

import java.util.concurrent.CompletableFuture;

public class TradeDataServiceAsync extends YahooServiceAsync<YahooTradeData> implements IYahooEndpointServiceAsyncExecutable {

  public TradeDataServiceAsync() {
    super();
  }

  public TradeDataServiceAsync(org.opensource.model.web.YahooSession session) {
    super(session);
  }

  @Override
  public CompletableFuture<YahooTradeData> executeAsync(String ticker) throws YahooServiceException {
    try {
      if (this.session == null) {
        this.session = YahooSessionFactory.getYahooSession();
      }

      return session.crumbAsync().thenCompose((String crumb) -> {
        String url = prepareUrl(ticker, crumb);
        Request request = YahooRequestFactory.createYahooRequest(url);
        return getResultAsync(request, YahooTradeData.class);
      }).exceptionally((Throwable throwable) -> {
        logger.error("Failed to retrieve data for ticker: " + ticker, throwable);
        throw new YahooAsyncRequestException("Failed to retrieve data for ticker: " + ticker, throwable);
      });

    } catch (YahooAsyncRequestException e) {
      CompletableFuture<YahooTradeData> failedFuture = new CompletableFuture<>();
      failedFuture.completeExceptionally(
              new YahooServiceException("Failed to retrieve crumb from session for ticker: " + ticker, e)
      );
      return failedFuture;
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
