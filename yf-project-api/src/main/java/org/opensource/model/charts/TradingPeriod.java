package org.opensource.model.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradingPeriod {

	@JsonProperty("gmtoffset")
	private Integer gmtoffset;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("start")
	private Integer start;

	@JsonProperty("end")
	private Integer end;

	public Integer getGmtoffset(){
		return gmtoffset;
	}

	public String getTimezone(){
		return timezone;
	}

	public Integer getStart(){
		return start;
	}

	public Integer getEnd(){
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