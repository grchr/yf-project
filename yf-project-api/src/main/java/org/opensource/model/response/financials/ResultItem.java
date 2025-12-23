package org.opensource.model.response.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultItem{

	@JsonProperty("incomeStatementHistoryQuarterly")
	private IncomeStatementHistoryQuarterly incomeStatementHistoryQuarterly;

	@JsonProperty("cashflowStatementHistory")
	private CashflowStatementHistory cashflowStatementHistory;

	@JsonProperty("cashflowStatementHistoryQuarterly")
	private CashflowStatementHistoryQuarterly cashflowStatementHistoryQuarterly;

	@JsonProperty("balanceSheetHistoryQuarterly")
	private BalanceSheetHistoryQuarterly balanceSheetHistoryQuarterly;

	@JsonProperty("balanceSheetHistory")
	private BalanceSheetHistory balanceSheetHistory;

	@JsonProperty("incomeStatementHistory")
	private IncomeStatementHistory incomeStatementHistory;

	public IncomeStatementHistoryQuarterly getIncomeStatementHistoryQuarterly(){
		return incomeStatementHistoryQuarterly;
	}

	public CashflowStatementHistory getCashflowStatementHistory(){
		return cashflowStatementHistory;
	}

	public CashflowStatementHistoryQuarterly getCashflowStatementHistoryQuarterly(){
		return cashflowStatementHistoryQuarterly;
	}

	public BalanceSheetHistoryQuarterly getBalanceSheetHistoryQuarterly(){
		return balanceSheetHistoryQuarterly;
	}

	public BalanceSheetHistory getBalanceSheetHistory(){
		return balanceSheetHistory;
	}

	public IncomeStatementHistory getIncomeStatementHistory(){
		return incomeStatementHistory;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"incomeStatementHistoryQuarterly = '" + incomeStatementHistoryQuarterly + '\'' + 
			",cashflowStatementHistory = '" + cashflowStatementHistory + '\'' + 
			",cashflowStatementHistoryQuarterly = '" + cashflowStatementHistoryQuarterly + '\'' + 
			",balanceSheetHistoryQuarterly = '" + balanceSheetHistoryQuarterly + '\'' + 
			",balanceSheetHistory = '" + balanceSheetHistory + '\'' + 
			",incomeStatementHistory = '" + incomeStatementHistory + '\'' + 
			"}";
		}
}