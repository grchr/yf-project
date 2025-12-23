package org.opensource.model.keystats;

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