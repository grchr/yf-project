package org.opensource.model.response.fundamentals;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta{

	@JsonProperty("symbol")
	private List<String> symbol;

	@JsonProperty("type")
	private List<String> type;

	public List<String> getSymbol(){
		return symbol;
	}

	public List<String> getType(){
		return type;
	}

	@Override
 	public String toString(){
		return
			"Meta{" +
			"symbol = '" + symbol + '\'' +
			",type = '" + type + '\'' +
			"}";
		}
}