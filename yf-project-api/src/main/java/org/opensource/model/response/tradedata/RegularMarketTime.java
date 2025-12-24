package org.opensource.model.response.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegularMarketTime{

	@JsonProperty("raw")
	private Long raw;

	@JsonProperty("fmt")
	private String fmt;

	public Long getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return
			"RegularMarketTime{" +
			"raw = '" + raw + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}