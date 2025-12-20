package org.opensource.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YahooCompanyProfile {
	//Reachable via: https://query1.finance.yahoo.com/v10/finance/quoteSummary/BNP.PA?formatted=true&modules=assetProfile%2CsecFilings&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=Jw4kayWy2mQ

	@JsonProperty("quoteSummary")
	private QuoteSummary quoteSummary;

	public QuoteSummary getQuoteSummary(){
		return quoteSummary;
	}

}