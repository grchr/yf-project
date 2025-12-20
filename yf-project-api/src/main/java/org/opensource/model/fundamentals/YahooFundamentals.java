package org.opensource.model.fundamentals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YahooFundamentals{

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