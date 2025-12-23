package org.opensource.model.response.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiftyTwoWeekRange{

	@JsonProperty("raw")
	private String raw;

	@JsonProperty("fmt")
	private String fmt;

	public String getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return
			"FiftyTwoWeekRange{" +
			"raw = '" + raw + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}