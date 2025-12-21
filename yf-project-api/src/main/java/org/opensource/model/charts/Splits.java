package org.opensource.model.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Splits{

	private long date;
	private Double numerator;
	private Double denominator;
	private String splitRatio;

	public long getDate() {
		return date;
	}

	public Double getNumerator() {
		return numerator;
	}

	public Double getDenominator() {
		return denominator;
	}

	public String getSplitRatio() {
		return splitRatio;
	}

	@Override
	public String toString() {
		return "Splits{" +
						"date=" + date +
						", numerator=" + numerator +
						", denominator=" + denominator +
						", splitRatio='" + splitRatio + '\'' +
						'}';
	}
}