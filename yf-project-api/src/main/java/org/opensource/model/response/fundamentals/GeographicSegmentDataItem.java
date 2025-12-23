package org.opensource.model.response.fundamentals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeographicSegmentDataItem{

	@JsonProperty("dataValue")
	private Object dataValue;

	@JsonProperty("isPrimarySegment")
	private Integer isPrimarySegment;

	@JsonProperty("segmentType")
	private String segmentType;

	@JsonProperty("segmentName")
	private String segmentName;

	public Object getDataValue(){
		return dataValue;
	}

	public Integer getIsPrimarySegment(){
		return isPrimarySegment;
	}

	public String getSegmentType(){
		return segmentType;
	}

	public String getSegmentName(){
		return segmentName;
	}

	@Override
 	public String toString(){
		return
			"GeographicSegmentDataItem{" +
			"dataValue = '" + dataValue + '\'' +
			",isPrimarySegment = '" + isPrimarySegment + '\'' +
			",segmentType = '" + segmentType + '\'' +
			",segmentName = '" + segmentName + '\'' +
			"}";
		}
}