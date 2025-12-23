package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceToSalesTrailing12Months{

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
			"PriceToSalesTrailing12Months{" + 
			"raw = '" + raw + '\'' + 
			",fmt = '" + fmt + '\'' + 
			"}";
		}
}