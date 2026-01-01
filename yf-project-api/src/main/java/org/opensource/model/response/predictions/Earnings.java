package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Earnings{

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

	@JsonProperty("raw")
	private Long raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private String fmt;

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

	public Long getRaw(){
		return raw;
	}

	public String getLongFmt(){
		return longFmt;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return 
			"Earnings{" + 
			"financialCurrency = '" + financialCurrency + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",financialsChart = '" + financialsChart + '\'' + 
			",defaultMethodology = '" + defaultMethodology + '\'' + 
			",earningsChart = '" + earningsChart + '\'' + 
			",raw = '" + raw + '\'' + 
			",longFmt = '" + longFmt + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}