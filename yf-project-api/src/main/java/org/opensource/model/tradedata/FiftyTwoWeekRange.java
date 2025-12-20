package org.opensource.model.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiftyTwoWeekRange{

	@JsonProperty("raw")
	private String raw;

	@JsonProperty("fmt")
	private String fmt;

	public String getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}
}