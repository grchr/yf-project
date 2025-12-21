package org.opensource.model.financials;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CashflowStatementHistoryQuarterly{

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("cashflowStatements")
	private List<CashflowStatementsItem> cashflowStatements;

	public Integer getMaxAge(){
		return maxAge;
	}

	public List<CashflowStatementsItem> getCashflowStatements(){
		return cashflowStatements;
	}

	@Override
 	public String toString(){
		return 
			"CashflowStatementHistoryQuarterly{" + 
			"maxAge = '" + maxAge + '\'' + 
			",cashflowStatements = '" + cashflowStatements + '\'' + 
			"}";
		}
}