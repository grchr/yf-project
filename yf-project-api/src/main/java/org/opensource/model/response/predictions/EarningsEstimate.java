package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsEstimate{

	@JsonProperty("high")
	private High high;

	@JsonProperty("avg")
	private Avg avg;

	@JsonProperty("numberOfAnalysts")
	private NumberOfAnalysts numberOfAnalysts;

	@JsonProperty("yearAgoEps")
	private YearAgoEps yearAgoEps;

	@JsonProperty("low")
	private Low low;

	@JsonProperty("earningsCurrency")
	private String earningsCurrency;

	@JsonProperty("growth")
	private Growth growth;

	public High getHigh(){
		return high;
	}

	public Avg getAvg(){
		return avg;
	}

	public NumberOfAnalysts getNumberOfAnalysts(){
		return numberOfAnalysts;
	}

	public YearAgoEps getYearAgoEps(){
		return yearAgoEps;
	}

	public Low getLow(){
		return low;
	}

	public String getEarningsCurrency(){
		return earningsCurrency;
	}

	public Growth getGrowth(){
		return growth;
	}

	@Override
 	public String toString(){
		return 
			"EarningsEstimate{" + 
			"high = '" + high + '\'' + 
			",avg = '" + avg + '\'' + 
			",numberOfAnalysts = '" + numberOfAnalysts + '\'' + 
			",yearAgoEps = '" + yearAgoEps + '\'' + 
			",low = '" + low + '\'' + 
			",earningsCurrency = '" + earningsCurrency + '\'' + 
			",growth = '" + growth + '\'' + 
			"}";
		}
}