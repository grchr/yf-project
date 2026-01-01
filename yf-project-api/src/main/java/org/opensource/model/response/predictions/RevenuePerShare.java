package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RevenuePerShare{

	@JsonProperty("raw")
	private Object raw;

	@JsonProperty("fmt")
	private String fmt;

	public Object getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return 
			"RevenuePerShare{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}