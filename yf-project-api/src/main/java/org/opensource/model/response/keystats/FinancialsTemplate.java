package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialsTemplate{

	@JsonProperty("code")
	private String code;

	@JsonProperty("maxAge")
	private Integer maxAge;

	public String getCode(){
		return code;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	@Override
 	public String toString(){
		return 
			"FinancialsTemplate{" + 
			"code = '" + code + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			"}";
		}
}