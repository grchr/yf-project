package org.opensource.model.response.charts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Indicators{

	@JsonProperty("quote")
	private List<QuoteItem> quote;

	@JsonProperty("adjclose")
	private List<AdjcloseItem> adjclose;

	public List<QuoteItem> getQuote(){
		return quote;
	}

	public List<AdjcloseItem> getAdjclose(){
		return adjclose;
	}

	@Override
 	public String toString(){
		return 
			"Indicators{" + 
			"quote = '" + quote + '\'' + 
			",adjclose = '" + adjclose + '\'' + 
			"}";
		}
}