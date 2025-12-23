package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialData{

	@JsonProperty("quickRatio")
	private QuickRatio quickRatio;

	@JsonProperty("financialCurrency")
	private String financialCurrency;

	@JsonProperty("targetMedianPrice")
	private TargetMedianPrice targetMedianPrice;

	@JsonProperty("freeCashflow")
	private FreeCashflow freeCashflow;

	@JsonProperty("profitMargins")
	private ProfitMargins profitMargins;

	@JsonProperty("ebitdaMargins")
	private EbitdaMargins ebitdaMargins;

	@JsonProperty("recommendationMean")
	private RecommendationMean recommendationMean;

	@JsonProperty("totalCash")
	private TotalCash totalCash;

	@JsonProperty("totalCashPerShare")
	private TotalCashPerShare totalCashPerShare;

	@JsonProperty("totalRevenue")
	private TotalRevenue totalRevenue;

	@JsonProperty("targetLowPrice")
	private TargetLowPrice targetLowPrice;

	@JsonProperty("currentRatio")
	private CurrentRatio currentRatio;

	@JsonProperty("grossProfits")
	private GrossProfits grossProfits;

	@JsonProperty("revenueGrowth")
	private RevenueGrowth revenueGrowth;

	@JsonProperty("operatingMargins")
	private OperatingMargins operatingMargins;

	@JsonProperty("numberOfAnalystOpinions")
	private NumberOfAnalystOpinions numberOfAnalystOpinions;

	@JsonProperty("earningsGrowth")
	private EarningsGrowth earningsGrowth;

	@JsonProperty("totalDebt")
	private TotalDebt totalDebt;

	@JsonProperty("returnOnAssets")
	private ReturnOnAssets returnOnAssets;

	@JsonProperty("currentPrice")
	private CurrentPrice currentPrice;

	@JsonProperty("ebitda")
	private Ebitda ebitda;

	@JsonProperty("operatingCashflow")
	private OperatingCashflow operatingCashflow;

	@JsonProperty("grossMargins")
	private GrossMargins grossMargins;

	@JsonProperty("targetHighPrice")
	private TargetHighPrice targetHighPrice;

	@JsonProperty("recommendationKey")
	private String recommendationKey;

	@JsonProperty("debtToEquity")
	private DebtToEquity debtToEquity;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("targetMeanPrice")
	private TargetMeanPrice targetMeanPrice;

	@JsonProperty("returnOnEquity")
	private ReturnOnEquity returnOnEquity;

	@JsonProperty("revenuePerShare")
	private RevenuePerShare revenuePerShare;

	public QuickRatio getQuickRatio(){
		return quickRatio;
	}

	public String getFinancialCurrency(){
		return financialCurrency;
	}

	public TargetMedianPrice getTargetMedianPrice(){
		return targetMedianPrice;
	}

	public FreeCashflow getFreeCashflow(){
		return freeCashflow;
	}

	public ProfitMargins getProfitMargins(){
		return profitMargins;
	}

	public EbitdaMargins getEbitdaMargins(){
		return ebitdaMargins;
	}

	public RecommendationMean getRecommendationMean(){
		return recommendationMean;
	}

	public TotalCash getTotalCash(){
		return totalCash;
	}

	public TotalCashPerShare getTotalCashPerShare(){
		return totalCashPerShare;
	}

	public TotalRevenue getTotalRevenue(){
		return totalRevenue;
	}

	public TargetLowPrice getTargetLowPrice(){
		return targetLowPrice;
	}

	public CurrentRatio getCurrentRatio(){
		return currentRatio;
	}

	public GrossProfits getGrossProfits(){
		return grossProfits;
	}

	public RevenueGrowth getRevenueGrowth(){
		return revenueGrowth;
	}

	public OperatingMargins getOperatingMargins(){
		return operatingMargins;
	}

	public NumberOfAnalystOpinions getNumberOfAnalystOpinions(){
		return numberOfAnalystOpinions;
	}

	public EarningsGrowth getEarningsGrowth(){
		return earningsGrowth;
	}

	public TotalDebt getTotalDebt(){
		return totalDebt;
	}

	public ReturnOnAssets getReturnOnAssets(){
		return returnOnAssets;
	}

	public CurrentPrice getCurrentPrice(){
		return currentPrice;
	}

	public Ebitda getEbitda(){
		return ebitda;
	}

	public OperatingCashflow getOperatingCashflow(){
		return operatingCashflow;
	}

	public GrossMargins getGrossMargins(){
		return grossMargins;
	}

	public TargetHighPrice getTargetHighPrice(){
		return targetHighPrice;
	}

	public String getRecommendationKey(){
		return recommendationKey;
	}

	public DebtToEquity getDebtToEquity(){
		return debtToEquity;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public TargetMeanPrice getTargetMeanPrice(){
		return targetMeanPrice;
	}

	public ReturnOnEquity getReturnOnEquity(){
		return returnOnEquity;
	}

	public RevenuePerShare getRevenuePerShare(){
		return revenuePerShare;
	}

	@Override
 	public String toString(){
		return 
			"FinancialData{" + 
			"quickRatio = '" + quickRatio + '\'' + 
			",financialCurrency = '" + financialCurrency + '\'' + 
			",targetMedianPrice = '" + targetMedianPrice + '\'' + 
			",freeCashflow = '" + freeCashflow + '\'' + 
			",profitMargins = '" + profitMargins + '\'' + 
			",ebitdaMargins = '" + ebitdaMargins + '\'' + 
			",recommendationMean = '" + recommendationMean + '\'' + 
			",totalCash = '" + totalCash + '\'' + 
			",totalCashPerShare = '" + totalCashPerShare + '\'' + 
			",totalRevenue = '" + totalRevenue + '\'' + 
			",targetLowPrice = '" + targetLowPrice + '\'' + 
			",currentRatio = '" + currentRatio + '\'' + 
			",grossProfits = '" + grossProfits + '\'' + 
			",revenueGrowth = '" + revenueGrowth + '\'' + 
			",operatingMargins = '" + operatingMargins + '\'' + 
			",numberOfAnalystOpinions = '" + numberOfAnalystOpinions + '\'' + 
			",earningsGrowth = '" + earningsGrowth + '\'' + 
			",totalDebt = '" + totalDebt + '\'' + 
			",returnOnAssets = '" + returnOnAssets + '\'' + 
			",currentPrice = '" + currentPrice + '\'' + 
			",ebitda = '" + ebitda + '\'' + 
			",operatingCashflow = '" + operatingCashflow + '\'' + 
			",grossMargins = '" + grossMargins + '\'' + 
			",targetHighPrice = '" + targetHighPrice + '\'' + 
			",recommendationKey = '" + recommendationKey + '\'' + 
			",debtToEquity = '" + debtToEquity + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",targetMeanPrice = '" + targetMeanPrice + '\'' + 
			",returnOnEquity = '" + returnOnEquity + '\'' + 
			",revenuePerShare = '" + revenuePerShare + '\'' + 
			"}";
		}
}