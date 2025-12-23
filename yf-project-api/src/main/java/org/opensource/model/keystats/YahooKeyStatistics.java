package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.IYahooResponse;

public class YahooKeyStatistics implements IYahooResponse {

	// Retrieved from here: https://query1.finance.yahoo.com/v10/finance/quoteSummary/BNP.PA?formatted=true&modules=summaryProfile%2CfinancialData%2CrecommendationTrend%2Cearnings%2CequityPerformance%2CsummaryDetail%2CdefaultKeyStatistics%2CcalendarEvents%2CesgScores%2Cprice%2CpageViews%2CfinancialsTemplate%2CearningsCallAudios%2CquoteUnadjustedPerformanceOverview%2CcorporateActions%2CearningsCallTranscripts%2CearningsGaap%2CearningsNonGaap%2CupgradeDowngradeHistory&enablePrivateCompany=true&enableQSPExpandedEarnings=true&overnightPrice=true&lang=en-US&region=US&crumb=Jw4kayWy2mQ

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