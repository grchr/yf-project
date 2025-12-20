package org.opensource.model.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradingPeriod {

	@JsonProperty("gmtoffset")
	private int gmtoffset;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("start")
	private int start;

	@JsonProperty("end")
	private int end;

	public int getGmtoffset(){
		return gmtoffset;
	}

	public String getTimezone(){
		return timezone;
	}

	public int getStart(){
		return start;
	}

	public int getEnd(){
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