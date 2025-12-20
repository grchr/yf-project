package org.opensource.model.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SharesOutstanding{

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