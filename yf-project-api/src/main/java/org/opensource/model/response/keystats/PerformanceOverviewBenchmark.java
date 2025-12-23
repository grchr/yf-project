package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PerformanceOverviewBenchmark{

	@JsonProperty("oneMonthReturn")
	private OneMonthReturn oneMonthReturn;

	@JsonProperty("threeYearTotalReturn")
	private ThreeYearTotalReturn threeYearTotalReturn;

	@JsonProperty("maxReturn")
	private MaxReturn maxReturn;

	@JsonProperty("fiveYearTotalReturn")
	private FiveYearTotalReturn fiveYearTotalReturn;

	@JsonProperty("threeMonthReturn")
	private ThreeMonthReturn threeMonthReturn;

	@JsonProperty("ytdReturnPct")
	private YtdReturnPct ytdReturnPct;

	@JsonProperty("tenYearTotalReturn")
	private TenYearTotalReturn tenYearTotalReturn;

	@JsonProperty("asOfDate")
	private AsOfDate asOfDate;

	@JsonProperty("oneYearTotalReturn")
	private OneYearTotalReturn oneYearTotalReturn;

	@JsonProperty("fiveDaysReturn")
	private FiveDaysReturn fiveDaysReturn;

	@JsonProperty("sixMonthReturn")
	private SixMonthReturn sixMonthReturn;

	@JsonProperty("twoYearTotalReturn")
	private TwoYearTotalReturn twoYearTotalReturn;

	public OneMonthReturn getOneMonthReturn(){
		return oneMonthReturn;
	}

	public ThreeYearTotalReturn getThreeYearTotalReturn(){
		return threeYearTotalReturn;
	}

	public MaxReturn getMaxReturn(){
		return maxReturn;
	}

	public FiveYearTotalReturn getFiveYearTotalReturn(){
		return fiveYearTotalReturn;
	}

	public ThreeMonthReturn getThreeMonthReturn(){
		return threeMonthReturn;
	}

	public YtdReturnPct getYtdReturnPct(){
		return ytdReturnPct;
	}

	public TenYearTotalReturn getTenYearTotalReturn(){
		return tenYearTotalReturn;
	}

	public AsOfDate getAsOfDate(){
		return asOfDate;
	}

	public OneYearTotalReturn getOneYearTotalReturn(){
		return oneYearTotalReturn;
	}

	public FiveDaysReturn getFiveDaysReturn(){
		return fiveDaysReturn;
	}

	public SixMonthReturn getSixMonthReturn(){
		return sixMonthReturn;
	}

	public TwoYearTotalReturn getTwoYearTotalReturn(){
		return twoYearTotalReturn;
	}

	@Override
 	public String toString(){
		return 
			"PerformanceOverviewBenchmark{" + 
			"oneMonthReturn = '" + oneMonthReturn + '\'' + 
			",threeYearTotalReturn = '" + threeYearTotalReturn + '\'' + 
			",maxReturn = '" + maxReturn + '\'' + 
			",fiveYearTotalReturn = '" + fiveYearTotalReturn + '\'' + 
			",threeMonthReturn = '" + threeMonthReturn + '\'' + 
			",ytdReturnPct = '" + ytdReturnPct + '\'' + 
			",tenYearTotalReturn = '" + tenYearTotalReturn + '\'' + 
			",asOfDate = '" + asOfDate + '\'' + 
			",oneYearTotalReturn = '" + oneYearTotalReturn + '\'' + 
			",fiveDaysReturn = '" + fiveDaysReturn + '\'' + 
			",sixMonthReturn = '" + sixMonthReturn + '\'' + 
			",twoYearTotalReturn = '" + twoYearTotalReturn + '\'' + 
			"}";
		}
}