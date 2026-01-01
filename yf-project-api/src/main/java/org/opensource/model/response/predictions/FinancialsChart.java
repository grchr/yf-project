package org.opensource.model.response.predictions;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialsChart{

	@JsonProperty("quarterly")
	private List<QuarterlyItem> quarterly;

	@JsonProperty("yearly")
	private List<YearlyItem> yearly;

	public List<QuarterlyItem> getQuarterly(){
		return quarterly;
	}

	public List<YearlyItem> getYearly(){
		return yearly;
	}

	@Override
 	public String toString(){
		return 
			"FinancialsChart{" + 
			"quarterly = '" + quarterly + '\'' + 
			",yearly = '" + yearly + '\'' + 
			"}";
		}
}