package org.opensource.model.response.financials;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.response.IYahooResponse;

public class YahooFinancials implements IYahooResponse {

	@JsonProperty("quoteSummary")
	private QuoteSummary quoteSummary;

	public QuoteSummary getQuoteSummary(){
		return quoteSummary;
	}

	@Override
 	public String toString(){
		return 
			"YahooFundamentals{" + 
			"quoteSummary = '" + quoteSummary + '\'' + 
			"}";
		}
}