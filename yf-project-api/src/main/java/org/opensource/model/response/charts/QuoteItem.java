package org.opensource.model.response.charts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteItem{

	@JsonProperty("volume")
	private List<Integer> volume;

	@JsonProperty("high")
	private List<Double> high;

	@JsonProperty("low")
	private List<Double> low;

	@JsonProperty("close")
	private List<Double> close;

	@JsonProperty("open")
	private List<Double> open;

	public List<Integer> getVolume(){
		return volume;
	}

	public List<Double> getHigh(){
		return high;
	}

	public List<Double> getLow(){
		return low;
	}

	public List<Double> getClose(){
		return close;
	}

	public List<Double> getOpen(){
		return open;
	}

	@Override
 	public String toString(){
		return 
			"QuoteItem{" + 
			"volume = '" + volume + '\'' + 
			",high = '" + high + '\'' + 
			",low = '" + low + '\'' + 
			",close = '" + close + '\'' + 
			",open = '" + open + '\'' + 
			"}";
		}
}