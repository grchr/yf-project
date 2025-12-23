package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultItem{

	@JsonProperty("recommendationTrend")
	private RecommendationTrend recommendationTrend;

	@JsonProperty("equityPerformance")
	private EquityPerformance equityPerformance;

	@JsonProperty("quoteUnadjustedPerformanceOverview")
	private QuoteUnadjustedPerformanceOverview quoteUnadjustedPerformanceOverview;

	@JsonProperty("defaultKeyStatistics")
	private DefaultKeyStatistics defaultKeyStatistics;

	@JsonProperty("summaryProfile")
	private SummaryProfile summaryProfile;

	@JsonProperty("financialsTemplate")
	private FinancialsTemplate financialsTemplate;

	@JsonProperty("earningsGaap")
	private EarningsGaap earningsGaap;

	@JsonProperty("earningsCallTranscripts")
	private EarningsCallTranscripts earningsCallTranscripts;

	@JsonProperty("summaryDetail")
	private SummaryDetail summaryDetail;

	@JsonProperty("earnings")
	private Earnings earnings;

	@JsonProperty("calendarEvents")
	private CalendarEvents calendarEvents;

	@JsonProperty("price")
	private Price price;

	@JsonProperty("earningsCallAudios")
	private EarningsCallAudios earningsCallAudios;

	@JsonProperty("earningsNonGaap")
	private EarningsNonGaap earningsNonGaap;

	@JsonProperty("corporateActions")
	private CorporateActions corporateActions;

	@JsonProperty("financialData")
	private FinancialData financialData;

	public RecommendationTrend getRecommendationTrend(){
		return recommendationTrend;
	}

	public EquityPerformance getEquityPerformance(){
		return equityPerformance;
	}

	public QuoteUnadjustedPerformanceOverview getQuoteUnadjustedPerformanceOverview(){
		return quoteUnadjustedPerformanceOverview;
	}

	public DefaultKeyStatistics getDefaultKeyStatistics(){
		return defaultKeyStatistics;
	}

	public SummaryProfile getSummaryProfile(){
		return summaryProfile;
	}

	public FinancialsTemplate getFinancialsTemplate(){
		return financialsTemplate;
	}

	public EarningsGaap getEarningsGaap(){
		return earningsGaap;
	}

	public EarningsCallTranscripts getEarningsCallTranscripts(){
		return earningsCallTranscripts;
	}

	public SummaryDetail getSummaryDetail(){
		return summaryDetail;
	}

	public Earnings getEarnings(){
		return earnings;
	}

	public CalendarEvents getCalendarEvents(){
		return calendarEvents;
	}

	public Price getPrice(){
		return price;
	}

	public EarningsCallAudios getEarningsCallAudios(){
		return earningsCallAudios;
	}

	public EarningsNonGaap getEarningsNonGaap(){
		return earningsNonGaap;
	}

	public CorporateActions getCorporateActions(){
		return corporateActions;
	}

	public FinancialData getFinancialData(){
		return financialData;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"recommendationTrend = '" + recommendationTrend + '\'' + 
			",equityPerformance = '" + equityPerformance + '\'' + 
			",quoteUnadjustedPerformanceOverview = '" + quoteUnadjustedPerformanceOverview + '\'' + 
			",defaultKeyStatistics = '" + defaultKeyStatistics + '\'' + 
			",summaryProfile = '" + summaryProfile + '\'' + 
			",financialsTemplate = '" + financialsTemplate + '\'' + 
			",earningsGaap = '" + earningsGaap + '\'' + 
			",earningsCallTranscripts = '" + earningsCallTranscripts + '\'' + 
			",summaryDetail = '" + summaryDetail + '\'' + 
			",earnings = '" + earnings + '\'' + 
			",calendarEvents = '" + calendarEvents + '\'' + 
			",price = '" + price + '\'' + 
			",earningsCallAudios = '" + earningsCallAudios + '\'' + 
			",earningsNonGaap = '" + earningsNonGaap + '\'' + 
			",corporateActions = '" + corporateActions + '\'' + 
			",financialData = '" + financialData + '\'' + 
			"}";
		}
}