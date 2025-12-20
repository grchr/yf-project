package org.opensource.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalPay{

	@JsonProperty("raw")
	private int raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private String fmt;

	public int getRaw(){
		return raw;
	}

	public String getLongFmt(){
		return longFmt;
	}

	public String getFmt(){
		return fmt;
	}
}