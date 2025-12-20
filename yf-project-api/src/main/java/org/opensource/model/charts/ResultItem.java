package org.opensource.model.charts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultItem{

	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("indicators")
	private Indicators indicators;

	@JsonProperty("events")
	private Events events;

	@JsonProperty("timestamp")
	private List<Long> timestamp;

	public Meta getMeta(){
		return meta;
	}

	public Indicators getIndicators(){
		return indicators;
	}

	public Events getEvents(){
		return events;
	}

	public List<Long> getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"meta = '" + meta + '\'' + 
			",indicators = '" + indicators + '\'' + 
			",events = '" + events + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}