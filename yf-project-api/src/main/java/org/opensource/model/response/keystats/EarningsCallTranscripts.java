package org.opensource.model.response.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsCallTranscripts{

	@JsonProperty("transcripts")
	private List<TranscriptsItem> transcripts;

	@JsonProperty("maxAge")
	private Integer maxAge;

	public List<TranscriptsItem> getTranscripts(){
		return transcripts;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	@Override
 	public String toString(){
		return 
			"EarningsCallTranscripts{" + 
			"transcripts = '" + transcripts + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			"}";
		}
}