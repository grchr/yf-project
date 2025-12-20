package org.opensource.model.fundamentals;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceSheetHistoryQuarterly{

	@JsonProperty("maxAge")
	private int maxAge;

	@JsonProperty("balanceSheetStatements")
	private List<BalanceSheetStatementsItem> balanceSheetStatements;

	public int getMaxAge(){
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