package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsGaap{

	@JsonProperty("financialCurrency")
	private String financialCurrency;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("financialsChart")
	private FinancialsChart financialsChart;

	@JsonProperty("defaultMethodology")
	private String defaultMethodology;

	@JsonProperty("earningsChart")
	private EarningsChart earningsChart;

	public String getFinancialCurrency(){
		return financialCurrency;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public FinancialsChart getFinancialsChart(){
		return financialsChart;
	}

	public String getDefaultMethodology(){
		return defaultMethodology;
	}

	public EarningsChart getEarningsChart(){
		return earningsChart;
	}

	@Override
 	public String toString(){
		return 
			"EarningsGaap{" + 
			"financialCurrency = '" + financialCurrency + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",financialsChart = '" + financialsChart + '\'' + 
			",defaultMethodology = '" + defaultMethodology + '\'' + 
			",earningsChart = '" + earningsChart + '\'' + 
			"}";
		}
}