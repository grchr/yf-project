package org.opensource.model.response.financials;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeStatementHistory{

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("incomeStatementHistory")
	private List<IncomeStatementHistoryItem> incomeStatementHistory;

	public Long getMaxAge(){
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