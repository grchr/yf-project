package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Benchmark{

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("shortName")
	private String shortName;

	public String getSymbol(){
		return symbol;
	}

	public String getShortName(){
		return shortName;
	}

	@Override
 	public String toString(){
		return 
			"Benchmark{" + 
			"symbol = '" + symbol + '\'' + 
			",shortName = '" + shortName + '\'' + 
			"}";
		}
}