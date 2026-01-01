package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrendItem{

	@JsonProperty("period")
	private String period;

	@JsonProperty("buy")
	private Integer buy;

	@JsonProperty("sell")
	private Integer sell;

	@JsonProperty("strongSell")
	private Integer strongSell;

	@JsonProperty("strongBuy")
	private Integer strongBuy;

	@JsonProperty("hold")
	private Integer hold;

	@JsonProperty("revenueEstimate")
	private RevenueEstimate revenueEstimate;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("endDate")
	private String endDate;

	@JsonProperty("epsTrend")
	private EpsTrend epsTrend;

	@JsonProperty("epsRevisions")
	private EpsRevisions epsRevisions;

	@JsonProperty("earningsEstimate")
	private EarningsEstimate earningsEstimate;

	@JsonProperty("growth")
	private Growth growth;

	public String getPeriod(){
		return period;
	}

	public Integer getBuy(){
		return buy;
	}

	public Integer getSell(){
		return sell;
	}

	public Integer getStrongSell(){
		return strongSell;
	}

	public Integer getStrongBuy(){
		return strongBuy;
	}

	public Integer getHold(){
		return hold;
	}

	public RevenueEstimate getRevenueEstimate(){
		return revenueEstimate;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public String getEndDate(){
		return endDate;
	}

	public EpsTrend getEpsTrend(){
		return epsTrend;
	}

	public EpsRevisions getEpsRevisions(){
		return epsRevisions;
	}

	public EarningsEstimate getEarningsEstimate(){
		return earningsEstimate;
	}

	public Growth getGrowth(){
		return growth;
	}

	@Override
 	public String toString(){
		return 
			"TrendItem{" + 
			"period = '" + period + '\'' + 
			",buy = '" + buy + '\'' + 
			",sell = '" + sell + '\'' + 
			",strongSell = '" + strongSell + '\'' + 
			",strongBuy = '" + strongBuy + '\'' + 
			",hold = '" + hold + '\'' + 
			",revenueEstimate = '" + revenueEstimate + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",endDate = '" + endDate + '\'' + 
			",epsTrend = '" + epsTrend + '\'' + 
			",epsRevisions = '" + epsRevisions + '\'' + 
			",earningsEstimate = '" + earningsEstimate + '\'' + 
			",growth = '" + growth + '\'' + 
			"}";
		}
}