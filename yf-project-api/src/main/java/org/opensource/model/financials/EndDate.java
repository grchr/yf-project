package org.opensource.model.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EndDate{

	@JsonProperty("raw")
	private int raw;

	@JsonProperty("fmt")
	private String fmt;

	public int getRaw(){
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