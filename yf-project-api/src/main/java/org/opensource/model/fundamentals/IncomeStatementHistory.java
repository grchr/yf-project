package org.opensource.model.fundamentals;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeStatementHistory{

	@JsonProperty("maxAge")
	private int maxAge;

	@JsonProperty("incomeStatementHistory")
	private List<IncomeStatementHistoryItem> incomeStatementHistory;

	public int getMaxAge(){
		return maxAge;
	}

	public List<IncomeStatementHistoryItem> getIncomeStatementHistory(){
		return incomeStatementHistory;
	}

	@Override
 	public String toString(){
		return 
			"IncomeStatementHistory{" + 
			"maxAge = '" + maxAge + '\'' + 
			",incomeStatementHistory = '" + incomeStatementHistory + '\'' + 
			"}";
		}
}