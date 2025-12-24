package org.opensource.model.response.fundamentals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnnualTotalRevenueItem{

	@JsonProperty("periodType")
	private String periodType;

	@JsonProperty("dataId")
	private Long dataId;

	@JsonProperty("reportedValue")
	private ReportedValue reportedValue;

	@JsonProperty("asOfDate")
	private String asOfDate;

	@JsonProperty("currencyCode")
	private String currencyCode;

	public String getPeriodType(){
		return periodType;
	}

	public Long getDataId(){
		return dataId;
	}

	public ReportedValue getReportedValue(){
		return reportedValue;
	}

	public String getAsOfDate(){
		return asOfDate;
	}

	public String getCurrencyCode(){
		return currencyCode;
	}

	@Override
 	public String toString(){
		return
			"AnnualTotalRevenueItem{" +
			"periodType = '" + periodType + '\'' +
			",dataId = '" + dataId + '\'' +
			",reportedValue = '" + reportedValue + '\'' +
			",asOfDate = '" + asOfDate + '\'' +
			",currencyCode = '" + currencyCode + '\'' +
			"}";
		}
}