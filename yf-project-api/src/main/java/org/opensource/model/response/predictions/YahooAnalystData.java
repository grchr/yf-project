package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.response.IYahooResponse;

public class YahooAnalystData implements IYahooResponse {

	@JsonProperty("quoteSummary")
	private QuoteSummary quoteSummary;

	public QuoteSummary getQuoteSummary(){
		return quoteSummary;
	}

	@Override
 	public String toString(){
		return 
			"YahooAnalystData{" + 
			"quoteSummary = '" + quoteSummary + '\'' + 
			"}";
		}
}