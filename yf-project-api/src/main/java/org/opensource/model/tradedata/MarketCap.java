package org.opensource.model.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketCap{

	@JsonProperty("raw")
	private Double raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private String fmt;

	public Double getRaw(){
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
			"MarketCap{" +
			"raw = '" + raw + '\'' +
			",longFmt = '" + longFmt + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}