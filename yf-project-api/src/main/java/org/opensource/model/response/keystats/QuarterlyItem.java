package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuarterlyItem{

	@JsonProperty("date")
	private String date;

	@JsonProperty("revenue")
	private Revenue revenue;

	@JsonProperty("earnings")
	private Earnings earnings;

	@JsonProperty("fiscalQuarter")
	private String fiscalQuarter;

	@JsonProperty("actual")
	private Actual actual;

	@JsonProperty("estimate")
	private Estimate estimate;

	@JsonProperty("surprisePct")
	private String surprisePct;

	@JsonProperty("difference")
	private String difference;

	@JsonProperty("calendarQuarter")
	private String calendarQuarter;

	public String getDate(){
		return date;
	}

	public Revenue getRevenue(){
		return revenue;
	}

	public Earnings getEarnings(){
		return earnings;
	}

	public String getFiscalQuarter(){
		return fiscalQuarter;
	}

	public Actual getActual(){
		return actual;
	}

	public Estimate getEstimate(){
		return estimate;
	}

	public String getSurprisePct(){
		return surprisePct;
	}

	public String getDifference(){
		return difference;
	}

	public String getCalendarQuarter(){
		return calendarQuarter;
	}

	@Override
 	public String toString(){
		return 
			"QuarterlyItem{" + 
			"date = '" + date + '\'' + 
			",revenue = '" + revenue + '\'' + 
			",earnings = '" + earnings + '\'' + 
			",fiscalQuarter = '" + fiscalQuarter + '\'' + 
			",actual = '" + actual + '\'' + 
			",estimate = '" + estimate + '\'' + 
			",surprisePct = '" + surprisePct + '\'' + 
			",difference = '" + difference + '\'' + 
			",calendarQuarter = '" + calendarQuarter + '\'' + 
			"}";
		}
}