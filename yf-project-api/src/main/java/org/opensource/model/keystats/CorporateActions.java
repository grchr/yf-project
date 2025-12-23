package org.opensource.model.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CorporateActions{

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("corporateActions")
	private List<Object> corporateActions;

	public Integer getMaxAge(){
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