package org.opensource.model.response.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EndDate{

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
			"EndDate{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}