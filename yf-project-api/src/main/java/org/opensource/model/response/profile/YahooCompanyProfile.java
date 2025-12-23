package org.opensource.model.response.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.response.IYahooResponse;

public class YahooCompanyProfile implements IYahooResponse {

	@JsonProperty("quoteSummary")
	private QuoteSummary quoteSummary;

	public QuoteSummary getQuoteSummary(){
		return quoteSummary;
	}

	@Override
	public String toString() {
		return "YahooCompanyProfile{" +
						"quoteSummary=" + quoteSummary +
						'}';
	}
}