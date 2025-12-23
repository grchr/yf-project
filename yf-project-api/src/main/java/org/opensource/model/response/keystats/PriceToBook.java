package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceToBook{

	@JsonProperty("raw")
	private Double raw;

	@JsonProperty("fmt")
	private String fmt;

	public Double getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return 
			"PriceToBook{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}