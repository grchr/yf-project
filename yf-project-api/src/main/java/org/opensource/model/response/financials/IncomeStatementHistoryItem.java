package org.opensource.model.response.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeStatementHistoryItem{

	@JsonProperty("operatingIncome")
	private OperatingIncome operatingIncome;

	@JsonProperty("netIncomeFromContinuingOps")
	private NetIncomeFromContinuingOps netIncomeFromContinuingOps;

	@JsonProperty("endDate")
	private EndDate endDate;

	@JsonProperty("ebit")
	private Ebit ebit;

	@JsonProperty("discontinuedOperations")
	private DiscontinuedOperations discontinuedOperations;

	@JsonProperty("costOfRevenue")
	private CostOfRevenue costOfRevenue;

	@JsonProperty("researchDevelopment")
	private ResearchDevelopment researchDevelopment;

	@JsonProperty("nonRecurring")
	private NonRecurring nonRecurring;

	@JsonProperty("totalOperatingExpenses")
	private TotalOperatingExpenses totalOperatingExpenses;

	@JsonProperty("interestExpense")
	private InterestExpense interestExpense;

	@JsonProperty("effectOfAccountingCharges")
	private EffectOfAccountingCharges effectOfAccountingCharges;

	@JsonProperty("incomeBeforeTax")
	private IncomeBeforeTax incomeBeforeTax;

	@JsonProperty("sellingGeneralAdministrative")
	private SellingGeneralAdministrative sellingGeneralAdministrative;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("extraordinaryItems")
	private ExtraordinaryItems extraordinaryItems;

	@JsonProperty("totalOtherIncomeExpenseNet")
	private TotalOtherIncomeExpenseNet totalOtherIncomeExpenseNet;

	@JsonProperty("netIncomeApplicableToCommonShares")
	private NetIncomeApplicableToCommonShares netIncomeApplicableToCommonShares;

	@JsonProperty("incomeTaxExpense")
	private IncomeTaxExpense incomeTaxExpense;

	@JsonProperty("netIncome")
	private NetIncome netIncome;

	@JsonProperty("minorityInterest")
	private MinorityInterest minorityInterest;

	@JsonProperty("totalRevenue")
	private TotalRevenue totalRevenue;

	@JsonProperty("otherItems")
	private OtherItems otherItems;

	@JsonProperty("grossProfit")
	private GrossProfit grossProfit;

	@JsonProperty("otherOperatingExpenses")
	private OtherOperatingExpenses otherOperatingExpenses;

	public OperatingIncome getOperatingIncome(){
		return operatingIncome;
	}

	public NetIncomeFromContinuingOps getNetIncomeFromContinuingOps(){
		return netIncomeFromContinuingOps;
	}

	public EndDate getEndDate(){
		return endDate;
	}

	public Ebit getEbit(){
		return ebit;
	}

	public DiscontinuedOperations getDiscontinuedOperations(){
		return discontinuedOperations;
	}

	public CostOfRevenue getCostOfRevenue(){
		return costOfRevenue;
	}

	public ResearchDevelopment getResearchDevelopment(){
		return researchDevelopment;
	}

	public NonRecurring getNonRecurring(){
		return nonRecurring;
	}

	public TotalOperatingExpenses getTotalOperatingExpenses(){
		return totalOperatingExpenses;
	}

	public InterestExpense getInterestExpense(){
		return interestExpense;
	}

	public EffectOfAccountingCharges getEffectOfAccountingCharges(){
		return effectOfAccountingCharges;
	}

	public IncomeBeforeTax getIncomeBeforeTax(){
		return incomeBeforeTax;
	}

	public SellingGeneralAdministrative getSellingGeneralAdministrative(){
		return sellingGeneralAdministrative;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public ExtraordinaryItems getExtraordinaryItems(){
		return extraordinaryItems;
	}

	public TotalOtherIncomeExpenseNet getTotalOtherIncomeExpenseNet(){
		return totalOtherIncomeExpenseNet;
	}

	public NetIncomeApplicableToCommonShares getNetIncomeApplicableToCommonShares(){
		return netIncomeApplicableToCommonShares;
	}

	public IncomeTaxExpense getIncomeTaxExpense(){
		return incomeTaxExpense;
	}

	public NetIncome getNetIncome(){
		return netIncome;
	}

	public MinorityInterest getMinorityInterest(){
		return minorityInterest;
	}

	public TotalRevenue getTotalRevenue(){
		return totalRevenue;
	}

	public OtherItems getOtherItems(){
		return otherItems;
	}

	public GrossProfit getGrossProfit(){
		return grossProfit;
	}

	public OtherOperatingExpenses getOtherOperatingExpenses(){
		return otherOperatingExpenses;
	}

	@Override
 	public String toString(){
		return 
			"IncomeStatementHistoryItem{" + 
			"operatingIncome = '" + operatingIncome + '\'' + 
			",netIncomeFromContinuingOps = '" + netIncomeFromContinuingOps + '\'' + 
			",endDate = '" + endDate + '\'' + 
			",ebit = '" + ebit + '\'' + 
			",discontinuedOperations = '" + discontinuedOperations + '\'' + 
			",costOfRevenue = '" + costOfRevenue + '\'' + 
			",researchDevelopment = '" + researchDevelopment + '\'' + 
			",nonRecurring = '" + nonRecurring + '\'' + 
			",totalOperatingExpenses = '" + totalOperatingExpenses + '\'' + 
			",interestExpense = '" + interestExpense + '\'' + 
			",effectOfAccountingCharges = '" + effectOfAccountingCharges + '\'' + 
			",incomeBeforeTax = '" + incomeBeforeTax + '\'' + 
			",sellingGeneralAdministrative = '" + sellingGeneralAdministrative + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",extraordinaryItems = '" + extraordinaryItems + '\'' + 
			",totalOtherIncomeExpenseNet = '" + totalOtherIncomeExpenseNet + '\'' + 
			",netIncomeApplicableToCommonShares = '" + netIncomeApplicableToCommonShares + '\'' + 
			",incomeTaxExpense = '" + incomeTaxExpense + '\'' + 
			",netIncome = '" + netIncome + '\'' + 
			",minorityInterest = '" + minorityInterest + '\'' + 
			",totalRevenue = '" + totalRevenue + '\'' + 
			",otherItems = '" + otherItems + '\'' + 
			",grossProfit = '" + grossProfit + '\'' + 
			",otherOperatingExpenses = '" + otherOperatingExpenses + '\'' + 
			"}";
		}
}