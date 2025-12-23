package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquityPerformance{

	@JsonProperty("performanceOverview")
	private PerformanceOverview performanceOverview;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("benchmark")
	private Benchmark benchmark;

	@JsonProperty("performanceOverviewBenchmark")
	private PerformanceOverviewBenchmark performanceOverviewBenchmark;

	public PerformanceOverview getPerformanceOverview(){
		return performanceOverview;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public Benchmark getBenchmark(){
		return benchmark;
	}

	public PerformanceOverviewBenchmark getPerformanceOverviewBenchmark(){
		return performanceOverviewBenchmark;
	}

	@Override
 	public String toString(){
		return 
			"EquityPerformance{" + 
			"performanceOverview = '" + performanceOverview + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",benchmark = '" + benchmark + '\'' + 
			",performanceOverviewBenchmark = '" + performanceOverviewBenchmark + '\'' + 
			"}";
		}
}