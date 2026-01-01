package org.opensource.model.response.predictions;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IndustryTrend{

	@JsonProperty("symbol")
	private Object symbol;

	@JsonProperty("peRatio")
	private PeRatio peRatio;

	@JsonProperty("pegRatio")
	private PegRatio pegRatio;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("estimates")
	private List<Object> estimates;

	public Object getSymbol(){
		return symbol;
	}

	public PeRatio getPeRatio(){
		return peRatio;
	}

	public PegRatio getPegRatio(){
		return pegRatio;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public List<Object> getEstimates(){
		return estimates;
	}

	@Override
 	public String toString(){
		return 
			"IndustryTrend{" + 
			"symbol = '" + symbol + '\'' + 
			",peRatio = '" + peRatio + '\'' + 
			",pegRatio = '" + pegRatio + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",estimates = '" + estimates + '\'' + 
			"}";
		}
}