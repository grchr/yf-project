package org.opensource.model.fundamentals;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CashflowStatementHistory{

	@JsonProperty("maxAge")
	private int maxAge;

	@JsonProperty("cashflowStatements")
	private List<CashflowStatementsItem> cashflowStatements;

	public int getMaxAge(){
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