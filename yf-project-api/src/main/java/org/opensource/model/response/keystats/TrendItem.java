package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrendItem{

	@JsonProperty("period")
	private String period;

	@JsonProperty("buy")
	private Long buy;

	@JsonProperty("sell")
	private Long sell;

	@JsonProperty("strongSell")
	private Long strongSell;

	@JsonProperty("strongBuy")
	private Long strongBuy;

	@JsonProperty("hold")
	private Long hold;

	public String getPeriod(){
		return period;
	}

	public Long getBuy(){
		return buy;
	}

	public Long getSell(){
		return sell;
	}

	public Long getStrongSell(){
		return strongSell;
	}

	public Long getStrongBuy(){
		return strongBuy;
	}

	public Long getHold(){
		return hold;
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
			"}";
		}
}