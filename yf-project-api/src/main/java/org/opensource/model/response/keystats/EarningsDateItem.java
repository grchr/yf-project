package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsDateItem{

	@JsonProperty("raw")
	private Integer raw;

	@JsonProperty("fmt")
	private String fmt;

	public Integer getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return 
			"EarningsDateItem{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}