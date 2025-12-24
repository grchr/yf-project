package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranscriptsItem{

	@JsonProperty("date")
	private Long date;

	@JsonProperty("eventId")
	private Long eventId;

	@JsonProperty("s3Url")
	private String s3Url;

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("transcriptId")
	private Long transcriptId;

	@JsonProperty("fiscalPeriod")
	private String fiscalPeriod;

	@JsonProperty("eventType")
	private String eventType;

	@JsonProperty("title")
	private String title;

	@JsonProperty("type")
	private String type;

	@JsonProperty("fiscalYear")
	private Long fiscalYear;

	@JsonProperty("updated")
	private Long updated;

	@JsonProperty("url")
	private String url;

	public Long getDate(){
		return date;
	}

	public Long getEventId(){
		return eventId;
	}

	public String getS3Url(){
		return s3Url;
	}

	public Long getMaxAge(){
		return maxAge;
	}

	public Long getTranscriptId(){
		return transcriptId;
	}

	public String getFiscalPeriod(){
		return fiscalPeriod;
	}

	public String getEventType(){
		return eventType;
	}

	public String getTitle(){
		return title;
	}

	public String getType(){
		return type;
	}

	public Long getFiscalYear(){
		return fiscalYear;
	}

	public Long getUpdated(){
		return updated;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"TranscriptsItem{" + 
			"date = '" + date + '\'' + 
			",eventId = '" + eventId + '\'' + 
			",s3Url = '" + s3Url + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",transcriptId = '" + transcriptId + '\'' + 
			",fiscalPeriod = '" + fiscalPeriod + '\'' + 
			",eventType = '" + eventType + '\'' + 
			",title = '" + title + '\'' + 
			",type = '" + type + '\'' + 
			",fiscalYear = '" + fiscalYear + '\'' + 
			",updated = '" + updated + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}