package org.opensource.model.response.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradingPeriod {

	@JsonProperty("gmtoffset")
	private Long gmtoffset;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("start")
	private Long start;

	@JsonProperty("end")
	private Long end;

	public Long getGmtoffset(){
		return gmtoffset;
	}

	public String getTimezone(){
		return timezone;
	}

	public Long getStart(){
		return start;
	}

	public Long getEnd(){
		return end;
	}

	@Override
 	public String toString(){
		return 
			"Post{" + 
			"gmtoffset = '" + gmtoffset + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",start = '" + start + '\'' + 
			",end = '" + end + '\'' + 
			"}";
		}
}