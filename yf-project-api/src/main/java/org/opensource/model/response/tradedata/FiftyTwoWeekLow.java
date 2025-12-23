package org.opensource.model.response.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiftyTwoWeekLow{

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
			"FiftyTwoWeekLow{" +
			"raw = '" + raw + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}