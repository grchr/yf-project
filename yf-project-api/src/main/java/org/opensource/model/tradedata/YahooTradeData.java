package org.opensource.model.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YahooTradeData{
	// Reachable via: https://query1.finance.yahoo.com/v7/finance/quote?fields=fiftyTwoWeekHigh%2CfiftyTwoWeekLow%2CfromCurrency%2CfromExchange%2CheadSymbolAsString%2ClogoUrl%2ClongName%2CmarketCap%2CmessageBoardId%2CoptionsType%2CovernightMarketTime%2CovernightMarketPrice%2CovernightMarketChange%2CovernightMarketChangePercent%2CregularMarketTime%2CregularMarketChange%2CregularMarketChangePercent%2CregularMarketOpen%2CregularMarketPrice%2CregularMarketSource%2CregularMarketVolume%2CpostMarketTime%2CpostMarketPrice%2CpostMarketChange%2CpostMarketChangePercent%2CpreMarketTime%2CpreMarketPrice%2CpreMarketChange%2CpreMarketChangePercent%2CshortName%2CtoCurrency%2CtoExchange%2CunderlyingExchangeSymbol%2CunderlyingSymbol%2CstockStory%2CquartrId&formatted=true&imgHeights=50&imgLabels=logoUrl&imgWidths=50&symbols=BNP.PA&enablePrivateCompany=true&overnightPrice=true&topPickThisMonth=true&lang=en-US&region=US&crumb=Jw4kayWy2mQ

	@JsonProperty("quoteResponse")
	private QuoteResponse quoteResponse;

	public QuoteResponse getQuoteResponse(){
		return quoteResponse;
	}

	@Override
	public String toString() {
		return "YahooTradeData{" +
						"quoteResponse=" + quoteResponse +
						'}';
	}
}