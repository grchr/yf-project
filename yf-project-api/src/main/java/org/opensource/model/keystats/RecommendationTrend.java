package org.opensource.model.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendationTrend{

	@JsonProperty("trend")
	private List<TrendItem> trend;

	@JsonProperty("maxAge")
	private Integer maxAge;

	public List<TrendItem> getTrend(){
		return trend;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	@Override
 	public String toString(){
		return 
			"RecommendationTrend{" + 
			"trend = '" + trend + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			"}";
		}
}