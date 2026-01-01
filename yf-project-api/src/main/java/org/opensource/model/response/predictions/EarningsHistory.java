package org.opensource.model.response.predictions;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsHistory{

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("history")
	private List<HistoryItem> history;

	@JsonProperty("defaultMethodology")
	private String defaultMethodology;

	public Integer getMaxAge(){
		return maxAge;
	}

	public List<HistoryItem> getHistory(){
		return history;
	}

	public String getDefaultMethodology(){
		return defaultMethodology;
	}

	@Override
 	public String toString(){
		return 
			"EarningsHistory{" + 
			"maxAge = '" + maxAge + '\'' + 
			",history = '" + history + '\'' + 
			",defaultMethodology = '" + defaultMethodology + '\'' + 
			"}";
		}
}