package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalDebt{

	@JsonProperty("raw")
	private Double raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private String fmt;

	public Double getRaw(){
		return raw;
	}

	public String getLongFmt(){
		return longFmt;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return 
			"TotalDebt{" + 
			"raw = '" + raw + '\'' + 
			",longFmt = '" + longFmt + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}