package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AudiosItem{

	@JsonProperty("date")
	private Long date;

	@JsonProperty("eventId")
	private Long eventId;

	@JsonProperty("wentLiveAt")
	private Long wentLiveAt;

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("fiscalPeriod")
	private String fiscalPeriod;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("audio")
	private String audio;

	@JsonProperty("state")
	private String state;

	@JsonProperty("title")
	private String title;

	@JsonProperty("fiscalYear")
	private Long fiscalYear;

	@JsonProperty("eventDate")
	private Long eventDate;

	public Long getDate(){
		return date;
	}

	public Long getEventId(){
		return eventId;
	}

	public Long getWentLiveAt(){
		return wentLiveAt;
	}

	public Long getMaxAge(){
		return maxAge;
	}

	public String getFiscalPeriod(){
		return fiscalPeriod;
	}

	public Long getId(){
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

	public Long getFiscalYear(){
		return fiscalYear;
	}

	public Long getEventDate(){
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