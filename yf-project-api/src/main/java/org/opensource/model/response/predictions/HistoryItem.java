package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoryItem{

	@JsonProperty("epsActual")
	private EpsActual epsActual;

	@JsonProperty("period")
	private String period;

	@JsonProperty("epsEstimate")
	private EpsEstimate epsEstimate;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("surprisePercent")
	private SurprisePercent surprisePercent;

	@JsonProperty("epsDifference")
	private EpsDifference epsDifference;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("quarter")
	private Quarter quarter;

	public EpsActual getEpsActual(){
		return epsActual;
	}

	public String getPeriod(){
		return period;
	}

	public EpsEstimate getEpsEstimate(){
		return epsEstimate;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public SurprisePercent getSurprisePercent(){
		return surprisePercent;
	}

	public EpsDifference getEpsDifference(){
		return epsDifference;
	}

	public String getCurrency(){
		return currency;
	}

	public Quarter getQuarter(){
		return quarter;
	}

	@Override
 	public String toString(){
		return 
			"HistoryItem{" + 
			"epsActual = '" + epsActual + '\'' + 
			",period = '" + period + '\'' + 
			",epsEstimate = '" + epsEstimate + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",surprisePercent = '" + surprisePercent + '\'' + 
			",epsDifference = '" + epsDifference + '\'' + 
			",currency = '" + currency + '\'' + 
			",quarter = '" + quarter + '\'' + 
			"}";
		}
}