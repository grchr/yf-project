package org.opensource.model.response.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiftyTwoWeekHighChangePercent{

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

	@Override
 	public String toString(){
		return
			"FiftyTwoWeekHighChangePercent{" +
			"raw = '" + raw + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}