package org.opensource.model.response.predictions;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsChart{

	@JsonProperty("currentQuarterEstimateDate")
	private String currentQuarterEstimateDate;

	@JsonProperty("currentFiscalQuarter")
	private String currentFiscalQuarter;

	@JsonProperty("currentQuarterEstimate")
	private CurrentQuarterEstimate currentQuarterEstimate;

	@JsonProperty("currentPeriodEndDate")
	private CurrentPeriodEndDate currentPeriodEndDate;

	@JsonProperty("isEarningsDateEstimate")
	private Boolean isEarningsDateEstimate;

	@JsonProperty("currentCalendarQuarter")
	private String currentCalendarQuarter;

	@JsonProperty("currentQuarterEstimateYear")
	private Integer currentQuarterEstimateYear;

	@JsonProperty("quarterly")
	private List<QuarterlyItem> quarterly;

	@JsonProperty("earningsDate")
	private List<Object> earningsDate;

	public String getCurrentQuarterEstimateDate(){
		return currentQuarterEstimateDate;
	}

	public String getCurrentFiscalQuarter(){
		return currentFiscalQuarter;
	}

	public CurrentQuarterEstimate getCurrentQuarterEstimate(){
		return currentQuarterEstimate;
	}

	public CurrentPeriodEndDate getCurrentPeriodEndDate(){
		return currentPeriodEndDate;
	}

	public Boolean isIsEarningsDateEstimate(){
		return isEarningsDateEstimate;
	}

	public String getCurrentCalendarQuarter(){
		return currentCalendarQuarter;
	}

	public Integer getCurrentQuarterEstimateYear(){
		return currentQuarterEstimateYear;
	}

	public List<QuarterlyItem> getQuarterly(){
		return quarterly;
	}

	public List<Object> getEarningsDate(){
		return earningsDate;
	}

	@Override
 	public String toString(){
		return 
			"EarningsChart{" + 
			"currentQuarterEstimateDate = '" + currentQuarterEstimateDate + '\'' + 
			",currentFiscalQuarter = '" + currentFiscalQuarter + '\'' + 
			",currentQuarterEstimate = '" + currentQuarterEstimate + '\'' + 
			",currentPeriodEndDate = '" + currentPeriodEndDate + '\'' + 
			",isEarningsDateEstimate = '" + isEarningsDateEstimate + '\'' + 
			",currentCalendarQuarter = '" + currentCalendarQuarter + '\'' + 
			",currentQuarterEstimateYear = '" + currentQuarterEstimateYear + '\'' + 
			",quarterly = '" + quarterly + '\'' + 
			",earningsDate = '" + earningsDate + '\'' + 
			"}";
		}
}