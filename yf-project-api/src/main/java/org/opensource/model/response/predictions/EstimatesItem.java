package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstimatesItem{

	@JsonProperty("period")
	private String period;

	@JsonProperty("growth")
	private Growth growth;

	public String getPeriod(){
		return period;
	}

	public Growth getGrowth(){
		return growth;
	}

	@Override
 	public String toString(){
		return 
			"EstimatesItem{" + 
			"period = '" + period + '\'' + 
			",growth = '" + growth + '\'' + 
			"}";
		}
}