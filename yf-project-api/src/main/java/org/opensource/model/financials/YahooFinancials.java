package org.opensource.model.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YahooFinancials{

	@JsonProperty("quoteSummary")
	private QuoteSummary quoteSummary;

	public QuoteSummary getQuoteSummary(){
		return quoteSummary;
	}

	@Override
 	public String toString(){
		return 
			"YahooFinancials{" + 
			"quoteSummary = '" + quoteSummary + '\'' + 
			"}";
		}
}