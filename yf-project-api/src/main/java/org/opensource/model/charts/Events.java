package org.opensource.model.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Events{

	private Map<Long, Dividends> dividends;
	private Map<Long, Splits> splits;

	public Map<Long, Dividends> getDividends() {
		return dividends;
	}

	public Map<Long, Splits> getSplits() {
		return splits;
	}
}