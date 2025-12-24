package org.opensource.model.response.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CorporateActions{

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("corporateActions")
	private List<Object> corporateActions;

	public Long getMaxAge(){
		return maxAge;
	}

	public List<Object> getCorporateActions(){
		return corporateActions;
	}

	@Override
 	public String toString(){
		return 
			"CorporateActions{" + 
			"maxAge = '" + maxAge + '\'' + 
			",corporateActions = '" + corporateActions + '\'' + 
			"}";
		}
}