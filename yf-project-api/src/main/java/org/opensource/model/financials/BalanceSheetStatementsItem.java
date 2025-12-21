package org.opensource.model.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceSheetStatementsItem{

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("endDate")
	private EndDate endDate;

	public Integer getMaxAge(){
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