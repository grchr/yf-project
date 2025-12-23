package org.opensource.model.fundamentals;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensource.model.IYahooResponse;

public class YahooFundamentals implements IYahooResponse {

	@JsonProperty("timeseries")
	private Timeseries timeseries;

	public Timeseries getTimeseries(){
		return timeseries;
	}

	@Override
 	public String toString(){
		return
			"YahooFundamentals{" +
			"timeseries = '" + timeseries + '\'' +
			"}";
		}
}