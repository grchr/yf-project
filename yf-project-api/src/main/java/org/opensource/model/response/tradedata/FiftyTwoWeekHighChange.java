package org.opensource.model.response.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiftyTwoWeekHighChange{

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
			"FiftyTwoWeekHighChange{" +
			"raw = '" + raw + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}