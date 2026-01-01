package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpsTrend{

	@JsonProperty("current")
	private Current current;

	@JsonProperty("60daysAgo")
	private JsonMember60daysAgo jsonMember60daysAgo;

	@JsonProperty("90daysAgo")
	private JsonMember90daysAgo jsonMember90daysAgo;

	@JsonProperty("epsTrendCurrency")
	private String epsTrendCurrency;

	@JsonProperty("30daysAgo")
	private JsonMember30daysAgo jsonMember30daysAgo;

	@JsonProperty("7daysAgo")
	private JsonMember7daysAgo jsonMember7daysAgo;

	public Current getCurrent(){
		return current;
	}

	public JsonMember60daysAgo getJsonMember60daysAgo(){
		return jsonMember60daysAgo;
	}

	public JsonMember90daysAgo getJsonMember90daysAgo(){
		return jsonMember90daysAgo;
	}

	public String getEpsTrendCurrency(){
		return epsTrendCurrency;
	}

	public JsonMember30daysAgo getJsonMember30daysAgo(){
		return jsonMember30daysAgo;
	}

	public JsonMember7daysAgo getJsonMember7daysAgo(){
		return jsonMember7daysAgo;
	}

	@Override
 	public String toString(){
		return 
			"EpsTrend{" + 
			"current = '" + current + '\'' + 
			",60daysAgo = '" + jsonMember60daysAgo + '\'' + 
			",90daysAgo = '" + jsonMember90daysAgo + '\'' + 
			",epsTrendCurrency = '" + epsTrendCurrency + '\'' + 
			",30daysAgo = '" + jsonMember30daysAgo + '\'' + 
			",7daysAgo = '" + jsonMember7daysAgo + '\'' + 
			"}";
		}
}