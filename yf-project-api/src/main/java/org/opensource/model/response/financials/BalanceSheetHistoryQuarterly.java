package org.opensource.model.response.financials;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceSheetHistoryQuarterly{

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("balanceSheetStatements")
	private List<BalanceSheetStatementsItem> balanceSheetStatements;

	public Integer getMaxAge(){
		return maxAge;
	}

	public List<BalanceSheetStatementsItem> getBalanceSheetStatements(){
		return balanceSheetStatements;
	}

	@Override
 	public String toString(){
		return 
			"BalanceSheetHistoryQuarterly{" + 
			"maxAge = '" + maxAge + '\'' + 
			",balanceSheetStatements = '" + balanceSheetStatements + '\'' + 
			"}";
		}
}