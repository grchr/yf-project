package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsOfDate{

	@JsonProperty("raw")
	private Integer raw;

	@JsonProperty("fmt")
	private String fmt;

	public Integer getRaw(){
		return raw;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return 
			"AsOfDate{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}