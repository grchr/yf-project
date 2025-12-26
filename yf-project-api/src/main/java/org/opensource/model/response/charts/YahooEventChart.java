package org.opensource.model.response.charts;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.response.IYahooResponse;

public class YahooEventChart implements IYahooResponse {

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