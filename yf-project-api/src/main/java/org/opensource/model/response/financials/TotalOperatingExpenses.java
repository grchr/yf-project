package org.opensource.model.response.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalOperatingExpenses{

	@JsonProperty("raw")
	private Long raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private String fmt;

	public Long getRaw(){
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
			"TotalOperatingExpenses{" + 
			"raw = '" + raw + '\'' + 
			",longFmt = '" + longFmt + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}