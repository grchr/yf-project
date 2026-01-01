package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RevenueEstimate{

	@JsonProperty("revenueCurrency")
	private String revenueCurrency;

	@JsonProperty("high")
	private High high;

	@JsonProperty("avg")
	private Avg avg;

	@JsonProperty("numberOfAnalysts")
	private NumberOfAnalysts numberOfAnalysts;

	@JsonProperty("yearAgoRevenue")
	private YearAgoRevenue yearAgoRevenue;

	@JsonProperty("low")
	private Low low;

	@JsonProperty("growth")
	private Growth growth;

	public String getRevenueCurrency(){
		return revenueCurrency;
	}

	public High getHigh(){
		return high;
	}

	public Avg getAvg(){
		return avg;
	}

	public NumberOfAnalysts getNumberOfAnalysts(){
		return numberOfAnalysts;
	}

	public YearAgoRevenue getYearAgoRevenue(){
		return yearAgoRevenue;
	}

	public Low getLow(){
		return low;
	}

	public Growth getGrowth(){
		return growth;
	}

	@Override
 	public String toString(){
		return 
			"RevenueEstimate{" + 
			"revenueCurrency = '" + revenueCurrency + '\'' + 
			",high = '" + high + '\'' + 
			",avg = '" + avg + '\'' + 
			",numberOfAnalysts = '" + numberOfAnalysts + '\'' + 
			",yearAgoRevenue = '" + yearAgoRevenue + '\'' + 
			",low = '" + low + '\'' + 
			",growth = '" + growth + '\'' + 
			"}";
		}
}