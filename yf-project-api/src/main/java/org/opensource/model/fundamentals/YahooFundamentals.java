package org.opensource.model.fundamentals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YahooFundamentals{

	// Retrieved from: https://query2.finance.yahoo.com/ws/fundamentals-timeseries/v1/finance/timeseries/AAPL?symbol=AAPL&type=annualTotalRevenue,annualNetIncome,annualOperatingIncome&period1=1483142400&period2=1735689600

	@JsonProperty("timeseries")
	private Timeseries timeseries;

	public Timeseries getTimeseries(){
		return timeseries;
	}

	@Override
 	public String toString(){
		return
			"YahooFundamentals{" +
			"timeseries = '" + timeseries + '\'' +
			"}";
		}
}