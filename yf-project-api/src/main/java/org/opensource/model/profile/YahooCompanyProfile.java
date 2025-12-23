package org.opensource.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.IYahooResponse;

public class YahooCompanyProfile implements IYahooResponse {
	//Reachable via: https://query1.finance.yahoo.com/v10/finance/quoteSummary/BNP.PA?formatted=true&modules=assetProfile%2CsecFilings&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=Jw4kayWy2mQ

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