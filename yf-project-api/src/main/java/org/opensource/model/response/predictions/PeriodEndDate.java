package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeriodEndDate{

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
			"PeriodEndDate{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}