package org.opensource.model.tradedata;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteResponse{

	@JsonProperty("result")
	private List<ResultItem> result;

	@JsonProperty("error")
	private Object error;

	public List<ResultItem> getResult(){
		return result;
	}

	public Object getError(){
		return error;
	}

	@Override
 	public String toString(){
		return
			"QuoteResponse{" +
			"result = '" + result + '\'' +
			",error = '" + error + '\'' +
			"}";
		}
}