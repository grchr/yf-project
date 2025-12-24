package org.opensource.model.response.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CashflowStatementsItem{

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("endDate")
	private EndDate endDate;

	@JsonProperty("netIncome")
	private NetIncome netIncome;

	public Long getMaxAge(){
		return maxAge;
	}

	public EndDate getEndDate(){
		return endDate;
	}

	public NetIncome getNetIncome(){
		return netIncome;
	}

	@Override
 	public String toString(){
		return 
			"CashflowStatementsItem{" + 
			"maxAge = '" + maxAge + '\'' + 
			",endDate = '" + endDate + '\'' + 
			",netIncome = '" + netIncome + '\'' + 
			"}";
		}
}