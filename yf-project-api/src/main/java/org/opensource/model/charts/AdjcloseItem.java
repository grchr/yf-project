package org.opensource.model.charts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdjcloseItem{

	@JsonProperty("adjclose")
	private List<Object> adjclose;

	public List<Object> getAdjclose(){
		return adjclose;
	}

	@Override
 	public String toString(){
		return 
			"AdjcloseItem{" + 
			"adjclose = '" + adjclose + '\'' + 
			"}";
		}
}