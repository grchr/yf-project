package org.opensource.model.response.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultItem{

	@JsonProperty("recommendationTrend")
	private RecommendationTrend recommendationTrend;

	@JsonProperty("sectorTrend")
	private SectorTrend sectorTrend;

	@JsonProperty("earnings")
	private Earnings earnings;

	@JsonProperty("earningsHistory")
	private EarningsHistory earningsHistory;

	@JsonProperty("indexTrend")
	private IndexTrend indexTrend;

	@JsonProperty("earningsTrend")
	private EarningsTrend earningsTrend;

	@JsonProperty("industryTrend")
	private IndustryTrend industryTrend;

	@JsonProperty("financialData")
	private FinancialData financialData;

	public RecommendationTrend getRecommendationTrend(){
		return recommendationTrend;
	}

	public SectorTrend getSectorTrend(){
		return sectorTrend;
	}

	public Earnings getEarnings(){
		return earnings;
	}

	public EarningsHistory getEarningsHistory(){
		return earningsHistory;
	}

	public IndexTrend getIndexTrend(){
		return indexTrend;
	}

	public EarningsTrend getEarningsTrend(){
		return earningsTrend;
	}

	public IndustryTrend getIndustryTrend(){
		return industryTrend;
	}

	public FinancialData getFinancialData(){
		return financialData;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"recommendationTrend = '" + recommendationTrend + '\'' + 
			",sectorTrend = '" + sectorTrend + '\'' + 
			",earnings = '" + earnings + '\'' + 
			",earningsHistory = '" + earningsHistory + '\'' + 
			",indexTrend = '" + indexTrend + '\'' + 
			",earningsTrend = '" + earningsTrend + '\'' + 
			",industryTrend = '" + industryTrend + '\'' + 
			",financialData = '" + financialData + '\'' + 
			"}";
		}
}