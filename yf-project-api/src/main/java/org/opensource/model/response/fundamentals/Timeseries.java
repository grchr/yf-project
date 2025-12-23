package org.opensource.model.response.fundamentals;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Timeseries{

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
			"Timeseries{" +
			"result = '" + result + '\'' +
			",error = '" + error + '\'' +
			"}";
		}
}