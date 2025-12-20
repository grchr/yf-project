package org.opensource.model.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalOperatingExpenses{

	@JsonProperty("raw")
	private int raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private Object fmt;

	public int getRaw(){
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
			"TotalOperatingExpenses{" + 
			"raw = '" + raw + '\'' + 
			",longFmt = '" + longFmt + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}