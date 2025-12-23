package org.opensource.model.keystats;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningsCallAudios{

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("audios")
	private List<AudiosItem> audios;

	public Integer getMaxAge(){
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