package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.response.IYahooResponse;

public class YahooKeyStatistics implements IYahooResponse {

	@JsonProperty("quoteSummary")
	private QuoteSummary quoteSummary;

	public QuoteSummary getQuoteSummary(){
		return quoteSummary;
	}

	@Override
 	public String toString(){
		return 
			"YahooKeyStatistics{" + 
			"quoteSummary = '" + quoteSummary + '\'' + 
			"}";
		}
}