package org.opensource.model.response.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsChart{

	@JsonProperty("currentQuarterEstimateDate")
	private String currentQuarterEstimateDate;

	@JsonProperty("currentFiscalQuarter")
	private String currentFiscalQuarter;

	@JsonProperty("currentQuarterEstimate")
	private CurrentQuarterEstimate currentQuarterEstimate;

	@JsonProperty("isEarningsDateEstimate")
	private Boolean isEarningsDateEstimate;

	@JsonProperty("currentCalendarQuarter")
	private String currentCalendarQuarter;

	@JsonProperty("currentQuarterEstimateYear")
	private Long currentQuarterEstimateYear;

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

	public Boolean isIsEarningsDateEstimate(){
		return isEarningsDateEstimate;
	}

	public String getCurrentCalendarQuarter(){
		return currentCalendarQuarter;
	}

	public Long getCurrentQuarterEstimateYear(){
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
			",isEarningsDateEstimate = '" + isEarningsDateEstimate + '\'' + 
			",currentCalendarQuarter = '" + currentCalendarQuarter + '\'' + 
			",currentQuarterEstimateYear = '" + currentQuarterEstimateYear + '\'' + 
			",quarterly = '" + quarterly + '\'' + 
			",earningsDate = '" + earningsDate + '\'' + 
			"}";
		}
}