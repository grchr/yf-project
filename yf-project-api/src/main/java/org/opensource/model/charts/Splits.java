package org.opensource.model.charts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Splits{

	private long date;
	private double numerator;
	private double denominator;
	private String splitRatio;

	public long getDate() {
		return date;
	}

	public double getNumerator() {
		return numerator;
	}

	public double getDenominator() {
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