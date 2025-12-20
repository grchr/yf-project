package org.opensource.model.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YahooChart{

	@JsonProperty("chart")
	private Chart chart;

	public Chart getChart(){
		return chart;
	}

	@Override
 	public String toString(){
		return 
			"YahooChart{" + 
			"chart = '" + chart + '\'' + 
			"}";
		}
}