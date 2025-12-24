package org.opensource.model.response.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceSheetStatementsItem{

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("endDate")
	private EndDate endDate;

	public Long getMaxAge(){
		return maxAge;
	}

	public EndDate getEndDate(){
		return endDate;
	}

	@Override
 	public String toString(){
		return 
			"BalanceSheetStatementsItem{" + 
			"maxAge = '" + maxAge + '\'' + 
			",endDate = '" + endDate + '\'' + 
			"}";
		}
}