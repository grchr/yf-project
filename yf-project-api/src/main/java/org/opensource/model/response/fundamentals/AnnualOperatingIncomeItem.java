package org.opensource.model.response.fundamentals;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnnualOperatingIncomeItem{

	@JsonProperty("periodType")
	private String periodType;

	@JsonProperty("dataId")
	private Long dataId;

	@JsonProperty("reportedValue")
	private ReportedValue reportedValue;

	@JsonProperty("geographicSegmentData")
	private List<GeographicSegmentDataItem> geographicSegmentData;

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

	public List<GeographicSegmentDataItem> getGeographicSegmentData(){
		return geographicSegmentData;
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
			"AnnualOperatingIncomeItem{" +
			"periodType = '" + periodType + '\'' +
			",dataId = '" + dataId + '\'' +
			",reportedValue = '" + reportedValue + '\'' +
			",geographicSegmentData = '" + geographicSegmentData + '\'' +
			",asOfDate = '" + asOfDate + '\'' +
			",currencyCode = '" + currencyCode + '\'' +
			"}";
		}
}