package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastDividendValue{

	@JsonProperty("raw")
	private Long raw;

	@JsonProperty("fmt")
	private String fmt;

	public Long getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return 
			"LastDividendValue{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}