package org.opensource.model.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegularMarketTime{

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
}