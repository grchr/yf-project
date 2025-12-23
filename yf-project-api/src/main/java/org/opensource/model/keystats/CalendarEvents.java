package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarEvents{

	@JsonProperty("earnings")
	private Earnings earnings;

	@JsonProperty("dividendDate")
	private DividendDate dividendDate;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("exDividendDate")
	private ExDividendDate exDividendDate;

	public Earnings getEarnings(){
		return earnings;
	}

	public DividendDate getDividendDate(){
		return dividendDate;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public ExDividendDate getExDividendDate(){
		return exDividendDate;
	}

	@Override
 	public String toString(){
		return 
			"CalendarEvents{" + 
			"earnings = '" + earnings + '\'' + 
			",dividendDate = '" + dividendDate + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",exDividendDate = '" + exDividendDate + '\'' + 
			"}";
		}
}