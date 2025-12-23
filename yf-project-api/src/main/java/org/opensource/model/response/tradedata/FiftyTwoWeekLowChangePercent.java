package org.opensource.model.response.tradedata;

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

	@Override
 	public String toString(){
		return
			"FiftyTwoWeekLowChangePercent{" +
			"raw = '" + raw + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}