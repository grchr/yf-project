package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TranscriptsItem{

	@JsonProperty("date")
	private Integer date;

	@JsonProperty("eventId")
	private Integer eventId;

	@JsonProperty("s3Url")
	private String s3Url;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("transcriptId")
	private Integer transcriptId;

	@JsonProperty("fiscalPeriod")
	private String fiscalPeriod;

	@JsonProperty("eventType")
	private String eventType;

	@JsonProperty("title")
	private String title;

	@JsonProperty("type")
	private String type;

	@JsonProperty("fiscalYear")
	private Integer fiscalYear;

	@JsonProperty("updated")
	private Integer updated;

	@JsonProperty("url")
	private String url;

	public Integer getDate(){
		return date;
	}

	public Integer getEventId(){
		return eventId;
	}

	public String getS3Url(){
		return s3Url;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public Integer getTranscriptId(){
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

	public Integer getFiscalYear(){
		return fiscalYear;
	}

	public Integer getUpdated(){
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