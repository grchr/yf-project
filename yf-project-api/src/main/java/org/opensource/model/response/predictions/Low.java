package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Low{

	@JsonProperty("raw")
	private Long raw;

	@JsonProperty("fmt")
	private String fmt;

	@JsonProperty("longFmt")
	private String longFmt;

	public Long getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}

	public String getLongFmt(){
		return longFmt;
	}

	@Override
 	public String toString(){
		return 
			"Low{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			",longFmt = '" + longFmt + '\'' + 
			"}";
		}
}