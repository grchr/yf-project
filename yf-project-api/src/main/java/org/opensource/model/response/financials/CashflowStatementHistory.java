package org.opensource.model.response.financials;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CashflowStatementHistory{

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("cashflowStatements")
	private List<CashflowStatementsItem> cashflowStatements;

	public Long getMaxAge(){
		return maxAge;
	}

	public List<CashflowStatementsItem> getCashflowStatements(){
		return cashflowStatements;
	}

	@Override
 	public String toString(){
		return 
			"CashflowStatementHistory{" + 
			"maxAge = '" + maxAge + '\'' + 
			",cashflowStatements = '" + cashflowStatements + '\'' + 
			"}";
		}
}