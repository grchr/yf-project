package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceToSalesTrailing12Months{

	@JsonProperty("raw")
	private Double raw;

	@JsonProperty("fmt")
	private String fmt;

	public Double getRaw(){
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