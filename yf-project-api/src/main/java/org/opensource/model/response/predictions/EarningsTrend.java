package org.opensource.model.response.predictions;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsTrend{

	@JsonProperty("trend")
	private List<TrendItem> trend;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("defaultMethodology")
	private String defaultMethodology;

	public List<TrendItem> getTrend(){
		return trend;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public String getDefaultMethodology(){
		return defaultMethodology;
	}

	@Override
 	public String toString(){
		return 
			"EarningsTrend{" + 
			"trend = '" + trend + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",defaultMethodology = '" + defaultMethodology + '\'' + 
			"}";
		}
}