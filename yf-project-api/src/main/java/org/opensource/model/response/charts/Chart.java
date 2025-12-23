package org.opensource.model.response.charts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Chart{

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
			"Chart{" + 
			"result = '" + result + '\'' + 
			",error = '" + error + '\'' + 
			"}";
		}
}