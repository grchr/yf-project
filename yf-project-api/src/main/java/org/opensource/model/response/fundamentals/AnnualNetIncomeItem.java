package org.opensource.model.response.fundamentals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnnualNetIncomeItem{

	@JsonProperty("periodType")
	private String periodType;

	@JsonProperty("dataId")
	private Integer dataId;

	@JsonProperty("reportedValue")
	private ReportedValue reportedValue;

	@JsonProperty("asOfDate")
	private String asOfDate;

	@JsonProperty("currencyCode")
	private String currencyCode;

	public String getPeriodType(){
		return periodType;
	}

	public Integer getDataId(){
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
			"AnnualNetIncomeItem{" +
			"periodType = '" + periodType + '\'' +
			",dataId = '" + dataId + '\'' +
			",reportedValue = '" + reportedValue + '\'' +
			",asOfDate = '" + asOfDate + '\'' +
			",currencyCode = '" + currencyCode + '\'' +
			"}";
		}
}