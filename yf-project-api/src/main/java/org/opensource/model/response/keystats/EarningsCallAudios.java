package org.opensource.model.response.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsCallAudios{

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("audios")
	private List<AudiosItem> audios;

	public Long getMaxAge(){
		return maxAge;
	}

	public List<AudiosItem> getAudios(){
		return audios;
	}

	@Override
 	public String toString(){
		return 
			"EarningsCallAudios{" + 
			"maxAge = '" + maxAge + '\'' + 
			",audios = '" + audios + '\'' + 
			"}";
		}
}