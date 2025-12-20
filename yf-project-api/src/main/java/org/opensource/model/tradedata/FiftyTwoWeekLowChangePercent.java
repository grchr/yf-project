package org.opensource.model.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiftyTwoWeekLowChangePercent{

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
}