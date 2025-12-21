package org.opensource.model.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ebit{

	@JsonProperty("raw")
	private Integer raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private Object fmt;

	public Integer getRaw(){
		return raw;
	}

	public String getLongFmt(){
		return longFmt;
	}

	public Object getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return 
			"Ebit{" + 
			"raw = '" + raw + '\'' + 
			",longFmt = '" + longFmt + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}