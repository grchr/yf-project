package org.opensource.model.response.charts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdjcloseItem{

	@JsonProperty("adjclose")
	private List<Double> adjclose;

	public List<Double> getAdjclose(){
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