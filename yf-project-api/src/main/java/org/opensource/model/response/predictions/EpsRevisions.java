package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EpsRevisions{

	@JsonProperty("upLast7days")
	private UpLast7days upLast7days;

	@JsonProperty("epsRevisionsCurrency")
	private String epsRevisionsCurrency;

	@JsonProperty("downLast30days")
	private DownLast30days downLast30days;

	@JsonProperty("downLast7Days")
	private DownLast7Days downLast7Days;

	@JsonProperty("upLast30days")
	private UpLast30days upLast30days;

	@JsonProperty("downLast90days")
	private DownLast90days downLast90days;

	public UpLast7days getUpLast7days(){
		return upLast7days;
	}

	public String getEpsRevisionsCurrency(){
		return epsRevisionsCurrency;
	}

	public DownLast30days getDownLast30days(){
		return downLast30days;
	}

	public DownLast7Days getDownLast7Days(){
		return downLast7Days;
	}

	public UpLast30days getUpLast30days(){
		return upLast30days;
	}

	public DownLast90days getDownLast90days(){
		return downLast90days;
	}

	@Override
 	public String toString(){
		return 
			"EpsRevisions{" + 
			"upLast7days = '" + upLast7days + '\'' + 
			",epsRevisionsCurrency = '" + epsRevisionsCurrency + '\'' + 
			",downLast30days = '" + downLast30days + '\'' + 
			",downLast7Days = '" + downLast7Days + '\'' + 
			",upLast30days = '" + upLast30days + '\'' + 
			",downLast90days = '" + downLast90days + '\'' + 
			"}";
		}
}