package org.opensource.model.response.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.response.IYahooResponse;

public class YahooTradeData implements IYahooResponse {

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