package org.opensource.model.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnexercisedValue{

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
}