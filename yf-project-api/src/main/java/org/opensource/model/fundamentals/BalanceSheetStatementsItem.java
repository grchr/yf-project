package org.opensource.model.fundamentals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceSheetStatementsItem{

	@JsonProperty("maxAge")
	private int maxAge;

	@JsonProperty("endDate")
	private EndDate endDate;

	public int getMaxAge(){
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