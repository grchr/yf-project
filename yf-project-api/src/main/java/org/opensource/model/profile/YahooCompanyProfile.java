package org.opensource.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.IYahooResponse;

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