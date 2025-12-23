package org.opensource.model.response.financials;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeStatementHistoryQuarterly{

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("incomeStatementHistory")
	private List<IncomeStatementHistoryItem> incomeStatementHistory;

	public Integer getMaxAge(){
		return maxAge;
	}

	public List<IncomeStatementHistoryItem> getIncomeStatementHistory(){
		return incomeStatementHistory;
	}

	@Override
 	public String toString(){
		return 
			"IncomeStatementHistoryQuarterly{" + 
			"maxAge = '" + maxAge + '\'' + 
			",incomeStatementHistory = '" + incomeStatementHistory + '\'' + 
			"}";
		}
}