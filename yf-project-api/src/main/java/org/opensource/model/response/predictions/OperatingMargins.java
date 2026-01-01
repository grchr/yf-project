package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperatingMargins{

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
			"OperatingMargins{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}