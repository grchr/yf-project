package org.opensource.model.response.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Earnings{

	@JsonProperty("earningsCallDate")
	private List<EarningsCallDateItem> earningsCallDate;

	@JsonProperty("revenueLow")
	private RevenueLow revenueLow;

	@JsonProperty("revenueAverage")
	private RevenueAverage revenueAverage;

	@JsonProperty("earningsLow")
	private EarningsLow earningsLow;

	@JsonProperty("isEarningsDateEstimate")
	private Boolean isEarningsDateEstimate;

	@JsonProperty("earningsHigh")
	private EarningsHigh earningsHigh;

	@JsonProperty("revenueHigh")
	private RevenueHigh revenueHigh;

	@JsonProperty("earningsDate")
	private List<EarningsDateItem> earningsDate;

	@JsonProperty("earningsAverage")
	private EarningsAverage earningsAverage;

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
	private Double raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private String fmt;

	public List<EarningsCallDateItem> getEarningsCallDate(){
		return earningsCallDate;
	}

	public RevenueLow getRevenueLow(){
		return revenueLow;
	}

	public RevenueAverage getRevenueAverage(){
		return revenueAverage;
	}

	public EarningsLow getEarningsLow(){
		return earningsLow;
	}

	public Boolean isIsEarningsDateEstimate(){
		return isEarningsDateEstimate;
	}

	public EarningsHigh getEarningsHigh(){
		return earningsHigh;
	}

	public RevenueHigh getRevenueHigh(){
		return revenueHigh;
	}

	public List<EarningsDateItem> getEarningsDate(){
		return earningsDate;
	}

	public EarningsAverage getEarningsAverage(){
		return earningsAverage;
	}

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

	public Double getRaw(){
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
			"earningsCallDate = '" + earningsCallDate + '\'' + 
			",revenueLow = '" + revenueLow + '\'' + 
			",revenueAverage = '" + revenueAverage + '\'' + 
			",earningsLow = '" + earningsLow + '\'' + 
			",isEarningsDateEstimate = '" + isEarningsDateEstimate + '\'' + 
			",earningsHigh = '" + earningsHigh + '\'' + 
			",revenueHigh = '" + revenueHigh + '\'' + 
			",earningsDate = '" + earningsDate + '\'' + 
			",earningsAverage = '" + earningsAverage + '\'' + 
			",financialCurrency = '" + financialCurrency + '\'' + 
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