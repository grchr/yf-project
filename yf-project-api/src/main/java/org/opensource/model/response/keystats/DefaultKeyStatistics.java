package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultKeyStatistics{

	@JsonProperty("totalAssets")
	private TotalAssets totalAssets;

	@JsonProperty("SandP52WeekChange")
	private SandP52WeekChange sandP52WeekChange;

	@JsonProperty("floatShares")
	private FloatShares floatShares;

	@JsonProperty("heldPercentInsiders")
	private HeldPercentInsiders heldPercentInsiders;

	@JsonProperty("revenueQuarterlyGrowth")
	private RevenueQuarterlyGrowth revenueQuarterlyGrowth;

	@JsonProperty("lastDividendValue")
	private LastDividendValue lastDividendValue;

	@JsonProperty("profitMargins")
	private ProfitMargins profitMargins;

	@JsonProperty("earningsQuarterlyGrowth")
	private EarningsQuarterlyGrowth earningsQuarterlyGrowth;

	@JsonProperty("mostRecentQuarter")
	private MostRecentQuarter mostRecentQuarter;

	@JsonProperty("forwardEps")
	private ForwardEps forwardEps;

	@JsonProperty("annualReportExpenseRatio")
	private AnnualReportExpenseRatio annualReportExpenseRatio;

	@JsonProperty("nextFiscalYearEnd")
	private NextFiscalYearEnd nextFiscalYearEnd;

	@JsonProperty("bookValue")
	private BookValue bookValue;

	@JsonProperty("latestAmountRaised")
	private LatestAmountRaised latestAmountRaised;

	@JsonProperty("morningStarOverallRating")
	private MorningStarOverallRating morningStarOverallRating;

	@JsonProperty("priceToSalesTrailing12Months")
	private PriceToSalesTrailing12Months priceToSalesTrailing12Months;

	@JsonProperty("totalFundingRounds")
	private TotalFundingRounds totalFundingRounds;

	@JsonProperty("shortPercentOfFloat")
	private ShortPercentOfFloat shortPercentOfFloat;

	@JsonProperty("enterpriseToRevenue")
	private EnterpriseToRevenue enterpriseToRevenue;

	@JsonProperty("priceHint")
	private PriceHint priceHint;

	@JsonProperty("sharesPercentSharesOut")
	private SharesPercentSharesOut sharesPercentSharesOut;

	@JsonProperty("ytdReturn")
	private YtdReturn ytdReturn;

	@JsonProperty("sharesShortPriorMonth")
	private SharesShortPriorMonth sharesShortPriorMonth;

	@JsonProperty("latestShareClass")
	private String latestShareClass;

	@JsonProperty("heldPercentInstitutions")
	private HeldPercentInstitutions heldPercentInstitutions;

	@JsonProperty("fundFamily")
	private String fundFamily;

	@JsonProperty("enterpriseValue")
	private EnterpriseValue enterpriseValue;

	@JsonProperty("impliedSharesOutstanding")
	private ImpliedSharesOutstanding impliedSharesOutstanding;

	@JsonProperty("lastDividendDate")
	private LastDividendDate lastDividendDate;

	@JsonProperty("fundingToDate")
	private FundingToDate fundingToDate;

	@JsonProperty("sharesShortPreviousMonthDate")
	private SharesShortPreviousMonthDate sharesShortPreviousMonthDate;

	@JsonProperty("trailingEps")
	private TrailingEps trailingEps;

	@JsonProperty("threeYearAverageReturn")
	private ThreeYearAverageReturn threeYearAverageReturn;

	@JsonProperty("latestImpliedValuation")
	private LatestImpliedValuation latestImpliedValuation;

	@JsonProperty("fiveYearAverageReturn")
	private FiveYearAverageReturn fiveYearAverageReturn;

	@JsonProperty("lastSplitFactor")
	private String lastSplitFactor;

	@JsonProperty("lastCapGain")
	private LastCapGain lastCapGain;

	@JsonProperty("dateShortInterest")
	private DateShortInterest dateShortInterest;

	@JsonProperty("pegRatio")
	private PegRatio pegRatio;

	@JsonProperty("yield")
	private Yield yield;

	@JsonProperty("latestFundingDate")
	private LatestFundingDate latestFundingDate;

	@JsonProperty("sharesOutstanding")
	private SharesOutstanding sharesOutstanding;

	@JsonProperty("enterpriseToEbitda")
	private EnterpriseToEbitda enterpriseToEbitda;

	@JsonProperty("beta")
	private Beta beta;

	@JsonProperty("legalType")
	private String legalType;

	@JsonProperty("lastFiscalYearEnd")
	private LastFiscalYearEnd lastFiscalYearEnd;

	@JsonProperty("leadInvestor")
	private String leadInvestor;

	@JsonProperty("lastSplitDate")
	private LastSplitDate lastSplitDate;

	@JsonProperty("qtdReturn")
	private QtdReturn qtdReturn;

	@JsonProperty("netIncomeToCommon")
	private NetIncomeToCommon netIncomeToCommon;

	@JsonProperty("forwardPE")
	private ForwardPE forwardPE;

	@JsonProperty("sharesShort")
	private SharesShort sharesShort;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("52WeekChange")
	private JsonMember52WeekChange jsonMember52WeekChange;

	@JsonProperty("shortRatio")
	private ShortRatio shortRatio;

	@JsonProperty("fundInceptionDate")
	private FundInceptionDate fundInceptionDate;

	@JsonProperty("beta3Year")
	private Beta3Year beta3Year;

	@JsonProperty("annualHoldingsTurnover")
	private AnnualHoldingsTurnover annualHoldingsTurnover;

	@JsonProperty("category")
	private String category;

	@JsonProperty("morningStarRiskRating")
	private MorningStarRiskRating morningStarRiskRating;

	@JsonProperty("priceToBook")
	private PriceToBook priceToBook;

	public TotalAssets getTotalAssets(){
		return totalAssets;
	}

	public SandP52WeekChange getSandP52WeekChange(){
		return sandP52WeekChange;
	}

	public FloatShares getFloatShares(){
		return floatShares;
	}

	public HeldPercentInsiders getHeldPercentInsiders(){
		return heldPercentInsiders;
	}

	public RevenueQuarterlyGrowth getRevenueQuarterlyGrowth(){
		return revenueQuarterlyGrowth;
	}

	public LastDividendValue getLastDividendValue(){
		return lastDividendValue;
	}

	public ProfitMargins getProfitMargins(){
		return profitMargins;
	}

	public EarningsQuarterlyGrowth getEarningsQuarterlyGrowth(){
		return earningsQuarterlyGrowth;
	}

	public MostRecentQuarter getMostRecentQuarter(){
		return mostRecentQuarter;
	}

	public ForwardEps getForwardEps(){
		return forwardEps;
	}

	public AnnualReportExpenseRatio getAnnualReportExpenseRatio(){
		return annualReportExpenseRatio;
	}

	public NextFiscalYearEnd getNextFiscalYearEnd(){
		return nextFiscalYearEnd;
	}

	public BookValue getBookValue(){
		return bookValue;
	}

	public LatestAmountRaised getLatestAmountRaised(){
		return latestAmountRaised;
	}

	public MorningStarOverallRating getMorningStarOverallRating(){
		return morningStarOverallRating;
	}

	public PriceToSalesTrailing12Months getPriceToSalesTrailing12Months(){
		return priceToSalesTrailing12Months;
	}

	public TotalFundingRounds getTotalFundingRounds(){
		return totalFundingRounds;
	}

	public ShortPercentOfFloat getShortPercentOfFloat(){
		return shortPercentOfFloat;
	}

	public EnterpriseToRevenue getEnterpriseToRevenue(){
		return enterpriseToRevenue;
	}

	public PriceHint getPriceHint(){
		return priceHint;
	}

	public SharesPercentSharesOut getSharesPercentSharesOut(){
		return sharesPercentSharesOut;
	}

	public YtdReturn getYtdReturn(){
		return ytdReturn;
	}

	public SharesShortPriorMonth getSharesShortPriorMonth(){
		return sharesShortPriorMonth;
	}

	public String getLatestShareClass(){
		return latestShareClass;
	}

	public HeldPercentInstitutions getHeldPercentInstitutions(){
		return heldPercentInstitutions;
	}

	public String getFundFamily(){
		return fundFamily;
	}

	public EnterpriseValue getEnterpriseValue(){
		return enterpriseValue;
	}

	public ImpliedSharesOutstanding getImpliedSharesOutstanding(){
		return impliedSharesOutstanding;
	}

	public LastDividendDate getLastDividendDate(){
		return lastDividendDate;
	}

	public FundingToDate getFundingToDate(){
		return fundingToDate;
	}

	public SharesShortPreviousMonthDate getSharesShortPreviousMonthDate(){
		return sharesShortPreviousMonthDate;
	}

	public TrailingEps getTrailingEps(){
		return trailingEps;
	}

	public ThreeYearAverageReturn getThreeYearAverageReturn(){
		return threeYearAverageReturn;
	}

	public LatestImpliedValuation getLatestImpliedValuation(){
		return latestImpliedValuation;
	}

	public FiveYearAverageReturn getFiveYearAverageReturn(){
		return fiveYearAverageReturn;
	}

	public String getLastSplitFactor(){
		return lastSplitFactor;
	}

	public LastCapGain getLastCapGain(){
		return lastCapGain;
	}

	public DateShortInterest getDateShortInterest(){
		return dateShortInterest;
	}

	public PegRatio getPegRatio(){
		return pegRatio;
	}

	public Yield getYield(){
		return yield;
	}

	public LatestFundingDate getLatestFundingDate(){
		return latestFundingDate;
	}

	public SharesOutstanding getSharesOutstanding(){
		return sharesOutstanding;
	}

	public EnterpriseToEbitda getEnterpriseToEbitda(){
		return enterpriseToEbitda;
	}

	public Beta getBeta(){
		return beta;
	}

	public String getLegalType(){
		return legalType;
	}

	public LastFiscalYearEnd getLastFiscalYearEnd(){
		return lastFiscalYearEnd;
	}

	public String getLeadInvestor(){
		return leadInvestor;
	}

	public LastSplitDate getLastSplitDate(){
		return lastSplitDate;
	}

	public QtdReturn getQtdReturn(){
		return qtdReturn;
	}

	public NetIncomeToCommon getNetIncomeToCommon(){
		return netIncomeToCommon;
	}

	public ForwardPE getForwardPE(){
		return forwardPE;
	}

	public SharesShort getSharesShort(){
		return sharesShort;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public JsonMember52WeekChange getJsonMember52WeekChange(){
		return jsonMember52WeekChange;
	}

	public ShortRatio getShortRatio(){
		return shortRatio;
	}

	public FundInceptionDate getFundInceptionDate(){
		return fundInceptionDate;
	}

	public Beta3Year getBeta3Year(){
		return beta3Year;
	}

	public AnnualHoldingsTurnover getAnnualHoldingsTurnover(){
		return annualHoldingsTurnover;
	}

	public String getCategory(){
		return category;
	}

	public MorningStarRiskRating getMorningStarRiskRating(){
		return morningStarRiskRating;
	}

	public PriceToBook getPriceToBook(){
		return priceToBook;
	}

	@Override
 	public String toString(){
		return 
			"DefaultKeyStatistics{" + 
			"totalAssets = '" + totalAssets + '\'' + 
			",sandP52WeekChange = '" + sandP52WeekChange + '\'' + 
			",floatShares = '" + floatShares + '\'' + 
			",heldPercentInsiders = '" + heldPercentInsiders + '\'' + 
			",revenueQuarterlyGrowth = '" + revenueQuarterlyGrowth + '\'' + 
			",lastDividendValue = '" + lastDividendValue + '\'' + 
			",profitMargins = '" + profitMargins + '\'' + 
			",earningsQuarterlyGrowth = '" + earningsQuarterlyGrowth + '\'' + 
			",mostRecentQuarter = '" + mostRecentQuarter + '\'' + 
			",forwardEps = '" + forwardEps + '\'' + 
			",annualReportExpenseRatio = '" + annualReportExpenseRatio + '\'' + 
			",nextFiscalYearEnd = '" + nextFiscalYearEnd + '\'' + 
			",bookValue = '" + bookValue + '\'' + 
			",latestAmountRaised = '" + latestAmountRaised + '\'' + 
			",morningStarOverallRating = '" + morningStarOverallRating + '\'' + 
			",priceToSalesTrailing12Months = '" + priceToSalesTrailing12Months + '\'' + 
			",totalFundingRounds = '" + totalFundingRounds + '\'' + 
			",shortPercentOfFloat = '" + shortPercentOfFloat + '\'' + 
			",enterpriseToRevenue = '" + enterpriseToRevenue + '\'' + 
			",priceHint = '" + priceHint + '\'' + 
			",sharesPercentSharesOut = '" + sharesPercentSharesOut + '\'' + 
			",ytdReturn = '" + ytdReturn + '\'' + 
			",sharesShortPriorMonth = '" + sharesShortPriorMonth + '\'' + 
			",latestShareClass = '" + latestShareClass + '\'' + 
			",heldPercentInstitutions = '" + heldPercentInstitutions + '\'' + 
			",fundFamily = '" + fundFamily + '\'' + 
			",enterpriseValue = '" + enterpriseValue + '\'' + 
			",impliedSharesOutstanding = '" + impliedSharesOutstanding + '\'' + 
			",lastDividendDate = '" + lastDividendDate + '\'' + 
			",fundingToDate = '" + fundingToDate + '\'' + 
			",sharesShortPreviousMonthDate = '" + sharesShortPreviousMonthDate + '\'' + 
			",trailingEps = '" + trailingEps + '\'' + 
			",threeYearAverageReturn = '" + threeYearAverageReturn + '\'' + 
			",latestImpliedValuation = '" + latestImpliedValuation + '\'' + 
			",fiveYearAverageReturn = '" + fiveYearAverageReturn + '\'' + 
			",lastSplitFactor = '" + lastSplitFactor + '\'' + 
			",lastCapGain = '" + lastCapGain + '\'' + 
			",dateShortInterest = '" + dateShortInterest + '\'' + 
			",pegRatio = '" + pegRatio + '\'' + 
			",yield = '" + yield + '\'' + 
			",latestFundingDate = '" + latestFundingDate + '\'' + 
			",sharesOutstanding = '" + sharesOutstanding + '\'' + 
			",enterpriseToEbitda = '" + enterpriseToEbitda + '\'' + 
			",beta = '" + beta + '\'' + 
			",legalType = '" + legalType + '\'' + 
			",lastFiscalYearEnd = '" + lastFiscalYearEnd + '\'' + 
			",leadInvestor = '" + leadInvestor + '\'' + 
			",lastSplitDate = '" + lastSplitDate + '\'' + 
			",qtdReturn = '" + qtdReturn + '\'' + 
			",netIncomeToCommon = '" + netIncomeToCommon + '\'' + 
			",forwardPE = '" + forwardPE + '\'' + 
			",sharesShort = '" + sharesShort + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",52WeekChange = '" + jsonMember52WeekChange + '\'' + 
			",shortRatio = '" + shortRatio + '\'' + 
			",fundInceptionDate = '" + fundInceptionDate + '\'' + 
			",beta3Year = '" + beta3Year + '\'' + 
			",annualHoldingsTurnover = '" + annualHoldingsTurnover + '\'' + 
			",category = '" + category + '\'' + 
			",morningStarRiskRating = '" + morningStarRiskRating + '\'' + 
			",priceToBook = '" + priceToBook + '\'' + 
			"}";
		}
}