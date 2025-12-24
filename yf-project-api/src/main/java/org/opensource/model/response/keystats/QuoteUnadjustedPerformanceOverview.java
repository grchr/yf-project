package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteUnadjustedPerformanceOverview{

	@JsonProperty("performanceOverview")
	private PerformanceOverview performanceOverview;

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("benchmark")
	private Benchmark benchmark;

	@JsonProperty("performanceOverviewBenchmark")
	private PerformanceOverviewBenchmark performanceOverviewBenchmark;

	public PerformanceOverview getPerformanceOverview(){
		return performanceOverview;
	}

	public Long getMaxAge(){
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