package org.opensource.model.response.financials;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeTaxExpense{

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
			"IncomeTaxExpense{" + 
			"raw = '" + raw + '\'' + 
			",longFmt = '" + longFmt + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}