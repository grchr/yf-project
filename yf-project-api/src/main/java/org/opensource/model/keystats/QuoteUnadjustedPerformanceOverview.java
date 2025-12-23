package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteUnadjustedPerformanceOverview{

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
			"QuoteUnadjustedPerformanceOverview{" + 
			"performanceOverview = '" + performanceOverview + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",benchmark = '" + benchmark + '\'' + 
			",performanceOverviewBenchmark = '" + performanceOverviewBenchmark + '\'' + 
			"}";
		}
}