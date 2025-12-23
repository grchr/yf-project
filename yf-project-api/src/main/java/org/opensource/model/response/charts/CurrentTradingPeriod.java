package org.opensource.model.response.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentTradingPeriod{

	@JsonProperty("pre")
	private TradingPeriod pre;

	@JsonProperty("post")
	private TradingPeriod tradingPeriod;

	@JsonProperty("regular")
	private TradingPeriod regular;

	public TradingPeriod getPre(){
		return pre;
	}

	public TradingPeriod getPost(){
		return tradingPeriod;
	}

	public TradingPeriod getRegular(){
		return regular;
	}

	@Override
 	public String toString(){
		return 
			"CurrentTradingPeriod{" + 
			"pre = '" + pre + '\'' + 
			",post = '" + tradingPeriod + '\'' +
			",regular = '" + regular + '\'' + 
			"}";
		}
}