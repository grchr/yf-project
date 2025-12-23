package org.opensource.model.response.profile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExercisedValue{

	@JsonProperty("raw")
	private Integer raw;

	@JsonProperty("longFmt")
	private String longFmt;

	@JsonProperty("fmt")
	private String fmt;

	public Integer getRaw(){
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
			"ExercisedValue{" +
			"raw = '" + raw + '\'' +
			",longFmt = '" + longFmt + '\'' +
			",fmt = '" + fmt + '\'' +
			"}";
		}
}