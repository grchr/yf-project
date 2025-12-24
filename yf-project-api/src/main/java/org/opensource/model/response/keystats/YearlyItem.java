package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YearlyItem{

	@JsonProperty("date")
	private Long date;

	@JsonProperty("revenue")
	private Revenue revenue;

	@JsonProperty("earnings")
	private Earnings earnings;

	public Long getDate(){
		return date;
	}

	public Revenue getRevenue(){
		return revenue;
	}

	public Earnings getEarnings(){
		return earnings;
	}

	@Override
 	public String toString(){
		return 
			"YearlyItem{" + 
			"date = '" + date + '\'' + 
			",revenue = '" + revenue + '\'' + 
			",earnings = '" + earnings + '\'' + 
			"}";
		}
}