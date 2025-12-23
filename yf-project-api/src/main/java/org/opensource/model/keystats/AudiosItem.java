package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AudiosItem{

	@JsonProperty("date")
	private Integer date;

	@JsonProperty("eventId")
	private Integer eventId;

	@JsonProperty("wentLiveAt")
	private Integer wentLiveAt;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("fiscalPeriod")
	private String fiscalPeriod;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("audio")
	private String audio;

	@JsonProperty("state")
	private String state;

	@JsonProperty("title")
	private String title;

	@JsonProperty("fiscalYear")
	private Integer fiscalYear;

	@JsonProperty("eventDate")
	private Integer eventDate;

	public Integer getDate(){
		return date;
	}

	public Integer getEventId(){
		return eventId;
	}

	public Integer getWentLiveAt(){
		return wentLiveAt;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public String getFiscalPeriod(){
		return fiscalPeriod;
	}

	public Integer getId(){
		return id;
	}

	public String getAudio(){
		return audio;
	}

	public String getState(){
		return state;
	}

	public String getTitle(){
		return title;
	}

	public Integer getFiscalYear(){
		return fiscalYear;
	}

	public Integer getEventDate(){
		return eventDate;
	}

	@Override
 	public String toString(){
		return 
			"AudiosItem{" + 
			"date = '" + date + '\'' + 
			",eventId = '" + eventId + '\'' + 
			",wentLiveAt = '" + wentLiveAt + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",fiscalPeriod = '" + fiscalPeriod + '\'' + 
			",id = '" + id + '\'' + 
			",audio = '" + audio + '\'' + 
			",state = '" + state + '\'' + 
			",title = '" + title + '\'' + 
			",fiscalYear = '" + fiscalYear + '\'' + 
			",eventDate = '" + eventDate + '\'' + 
			"}";
		}
}