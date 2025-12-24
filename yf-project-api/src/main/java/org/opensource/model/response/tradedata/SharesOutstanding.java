package org.opensource.model.response.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SharesOutstanding{

	@JsonProperty("raw")
	private Long raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private String fmt;

	public Long getRaw(){
		return raw;
	}

	public String getLongFmt(){
		return longFmt;
	}

	public String getFmt(){
		return fmt;
	}

	@Override
 	public String toString(){
		return
			"SharesOutstanding{" +
			"raw = '" + raw + '\'' +
			",longFmt = '" + longFmt + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}