package org.opensource.model.response.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SummaryDetail{

	@JsonProperty("totalAssets")
	private TotalAssets totalAssets;

	@JsonProperty("dividendYield")
	private DividendYield dividendYield;

	@JsonProperty("circulatingSupply")
	private CirculatingSupply circulatingSupply;

	@JsonProperty("navPrice")
	private NavPrice navPrice;

	@JsonProperty("regularMarketDayHigh")
	private RegularMarketDayHigh regularMarketDayHigh;

	@JsonProperty("fromCurrency")
	private String fromCurrency;

	@JsonProperty("dayHigh")
	private DayHigh dayHigh;

	@JsonProperty("askSize")
	private AskSize askSize;

	@JsonProperty("twoHundredDayAverage")
	private TwoHundredDayAverage twoHundredDayAverage;

	@JsonProperty("algorithm")
	private Object algorithm;

	@JsonProperty("marketCap")
	private MarketCap marketCap;

	@JsonProperty("priceToSalesTrailing12Months")
	private PriceToSalesTrailing12Months priceToSalesTrailing12Months;

	@JsonProperty("lastMarket")
	private String lastMarket;

	@JsonProperty("dividendRate")
	private DividendRate dividendRate;

	@JsonProperty("dayLow")
	private DayLow dayLow;

	@JsonProperty("trailingAnnualDividendRate")
	private TrailingAnnualDividendRate trailingAnnualDividendRate;

	@JsonProperty("fiftyTwoWeekLow")
	private FiftyTwoWeekLow fiftyTwoWeekLow;

	@JsonProperty("volume")
	private Volume volume;

	@JsonProperty("regularMarketVolume")
	private RegularMarketVolume regularMarketVolume;

	@JsonProperty("toCurrency")
	private String toCurrency;

	@JsonProperty("priceHint")
	private PriceHint priceHint;

	@JsonProperty("regularMarketDayLow")
	private RegularMarketDayLow regularMarketDayLow;

	@JsonProperty("ytdReturn")
	private YtdReturn ytdReturn;

	@JsonProperty("payoutRatio")
	private PayoutRatio payoutRatio;

	@JsonProperty("strikePrice")
	private StrikePrice strikePrice;

	@JsonProperty("startDate")
	private StartDate startDate;

	@JsonProperty("fullyDilutedValue")
	private FullyDilutedValue fullyDilutedValue;

	@JsonProperty("openInterest")
	private OpenInterest openInterest;

	@JsonProperty("regularMarketOpen")
	private RegularMarketOpen regularMarketOpen;

	@JsonProperty("trailingAnnualDividendYield")
	private TrailingAnnualDividendYield trailingAnnualDividendYield;

	@JsonProperty("previousClose")
	private PreviousClose previousClose;

	@JsonProperty("averageDailyVolume10Day")
	private AverageDailyVolume10Day averageDailyVolume10Day;

	@JsonProperty("allTimeHigh")
	private AllTimeHigh allTimeHigh;

	@JsonProperty("trailingPE")
	private TrailingPE trailingPE;

	@JsonProperty("yield")
	private Yield yield;

	@JsonProperty("tradeable")
	private Boolean tradeable;

	@JsonProperty("averageVolume10days")
	private AverageVolume10days averageVolume10days;

	@JsonProperty("expireDate")
	private ExpireDate expireDate;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("maxSupply")
	private MaxSupply maxSupply;

	@JsonProperty("regularMarketPreviousClose")
	private RegularMarketPreviousClose regularMarketPreviousClose;

	@JsonProperty("fiftyTwoWeekHigh")
	private FiftyTwoWeekHigh fiftyTwoWeekHigh;

	@JsonProperty("beta")
	private Beta beta;

	@JsonProperty("volume24HrMarketCapPercent")
	private Volume24HrMarketCapPercent volume24HrMarketCapPercent;

	@JsonProperty("volume24Hr")
	private Volume24Hr volume24Hr;

	@JsonProperty("coinMarketCapLink")
	private Object coinMarketCapLink;

	@JsonProperty("exDividendDate")
	private ExDividendDate exDividendDate;

	@JsonProperty("bidSize")
	private BidSize bidSize;

	@JsonProperty("totalSupply")
	private TotalSupply totalSupply;

	@JsonProperty("fiveYearAvgDividendYield")
	private FiveYearAvgDividendYield fiveYearAvgDividendYield;

	@JsonProperty("volumeAllCurrencies")
	private VolumeAllCurrencies volumeAllCurrencies;

	@JsonProperty("fiftyDayAverage")
	private FiftyDayAverage fiftyDayAverage;

	@JsonProperty("qtdReturn")
	private QtdReturn qtdReturn;

	@JsonProperty("forwardPE")
	private ForwardPE forwardPE;

	@JsonProperty("maxAge")
	private Long maxAge;

	@JsonProperty("averageVolume")
	private AverageVolume averageVolume;

	@JsonProperty("ask")
	private Ask ask;

	@JsonProperty("bid")
	private Bid bid;

	@JsonProperty("open")
	private Open open;

	@JsonProperty("allTimeLow")
	private AllTimeLow allTimeLow;

	public TotalAssets getTotalAssets(){
		return totalAssets;
	}

	public DividendYield getDividendYield(){
		return dividendYield;
	}

	public CirculatingSupply getCirculatingSupply(){
		return circulatingSupply;
	}

	public NavPrice getNavPrice(){
		return navPrice;
	}

	public RegularMarketDayHigh getRegularMarketDayHigh(){
		return regularMarketDayHigh;
	}

	public String getFromCurrency(){
		return fromCurrency;
	}

	public DayHigh getDayHigh(){
		return dayHigh;
	}

	public AskSize getAskSize(){
		return askSize;
	}

	public TwoHundredDayAverage getTwoHundredDayAverage(){
		return twoHundredDayAverage;
	}

	public Object getAlgorithm(){
		return algorithm;
	}

	public MarketCap getMarketCap(){
		return marketCap;
	}

	public PriceToSalesTrailing12Months getPriceToSalesTrailing12Months(){
		return priceToSalesTrailing12Months;
	}

	public String getLastMarket(){
		return lastMarket;
	}

	public DividendRate getDividendRate(){
		return dividendRate;
	}

	public DayLow getDayLow(){
		return dayLow;
	}

	public TrailingAnnualDividendRate getTrailingAnnualDividendRate(){
		return trailingAnnualDividendRate;
	}

	public FiftyTwoWeekLow getFiftyTwoWeekLow(){
		return fiftyTwoWeekLow;
	}

	public Volume getVolume(){
		return volume;
	}

	public RegularMarketVolume getRegularMarketVolume(){
		return regularMarketVolume;
	}

	public String getToCurrency(){
		return toCurrency;
	}

	public PriceHint getPriceHint(){
		return priceHint;
	}

	public RegularMarketDayLow getRegularMarketDayLow(){
		return regularMarketDayLow;
	}

	public YtdReturn getYtdReturn(){
		return ytdReturn;
	}

	public PayoutRatio getPayoutRatio(){
		return payoutRatio;
	}

	public StrikePrice getStrikePrice(){
		return strikePrice;
	}

	public StartDate getStartDate(){
		return startDate;
	}

	public FullyDilutedValue getFullyDilutedValue(){
		return fullyDilutedValue;
	}

	public OpenInterest getOpenInterest(){
		return openInterest;
	}

	public RegularMarketOpen getRegularMarketOpen(){
		return regularMarketOpen;
	}

	public TrailingAnnualDividendYield getTrailingAnnualDividendYield(){
		return trailingAnnualDividendYield;
	}

	public PreviousClose getPreviousClose(){
		return previousClose;
	}

	public AverageDailyVolume10Day getAverageDailyVolume10Day(){
		return averageDailyVolume10Day;
	}

	public AllTimeHigh getAllTimeHigh(){
		return allTimeHigh;
	}

	public TrailingPE getTrailingPE(){
		return trailingPE;
	}

	public Yield getYield(){
		return yield;
	}

	public Boolean isTradeable(){
		return tradeable;
	}

	public AverageVolume10days getAverageVolume10days(){
		return averageVolume10days;
	}

	public ExpireDate getExpireDate(){
		return expireDate;
	}

	public String getCurrency(){
		return currency;
	}

	public MaxSupply getMaxSupply(){
		return maxSupply;
	}

	public RegularMarketPreviousClose getRegularMarketPreviousClose(){
		return regularMarketPreviousClose;
	}

	public FiftyTwoWeekHigh getFiftyTwoWeekHigh(){
		return fiftyTwoWeekHigh;
	}

	public Beta getBeta(){
		return beta;
	}

	public Volume24HrMarketCapPercent getVolume24HrMarketCapPercent(){
		return volume24HrMarketCapPercent;
	}

	public Volume24Hr getVolume24Hr(){
		return volume24Hr;
	}

	public Object getCoinMarketCapLink(){
		return coinMarketCapLink;
	}

	public ExDividendDate getExDividendDate(){
		return exDividendDate;
	}

	public BidSize getBidSize(){
		return bidSize;
	}

	public TotalSupply getTotalSupply(){
		return totalSupply;
	}

	public FiveYearAvgDividendYield getFiveYearAvgDividendYield(){
		return fiveYearAvgDividendYield;
	}

	public VolumeAllCurrencies getVolumeAllCurrencies(){
		return volumeAllCurrencies;
	}

	public FiftyDayAverage getFiftyDayAverage(){
		return fiftyDayAverage;
	}

	public QtdReturn getQtdReturn(){
		return qtdReturn;
	}

	public ForwardPE getForwardPE(){
		return forwardPE;
	}

	public Long getMaxAge(){
		return maxAge;
	}

	public AverageVolume getAverageVolume(){
		return averageVolume;
	}

	public Ask getAsk(){
		return ask;
	}

	public Bid getBid(){
		return bid;
	}

	public Open getOpen(){
		return open;
	}

	public AllTimeLow getAllTimeLow(){
		return allTimeLow;
	}

	@Override
 	public String toString(){
		return 
			"SummaryDetail{" + 
			"totalAssets = '" + totalAssets + '\'' + 
			",dividendYield = '" + dividendYield + '\'' + 
			",circulatingSupply = '" + circulatingSupply + '\'' + 
			",navPrice = '" + navPrice + '\'' + 
			",regularMarketDayHigh = '" + regularMarketDayHigh + '\'' + 
			",fromCurrency = '" + fromCurrency + '\'' + 
			",dayHigh = '" + dayHigh + '\'' + 
			",askSize = '" + askSize + '\'' + 
			",twoHundredDayAverage = '" + twoHundredDayAverage + '\'' + 
			",algorithm = '" + algorithm + '\'' + 
			",marketCap = '" + marketCap + '\'' + 
			",priceToSalesTrailing12Months = '" + priceToSalesTrailing12Months + '\'' + 
			",lastMarket = '" + lastMarket + '\'' + 
			",dividendRate = '" + dividendRate + '\'' + 
			",dayLow = '" + dayLow + '\'' + 
			",trailingAnnualDividendRate = '" + trailingAnnualDividendRate + '\'' + 
			",fiftyTwoWeekLow = '" + fiftyTwoWeekLow + '\'' + 
			",volume = '" + volume + '\'' + 
			",regularMarketVolume = '" + regularMarketVolume + '\'' + 
			",toCurrency = '" + toCurrency + '\'' + 
			",priceHint = '" + priceHint + '\'' + 
			",regularMarketDayLow = '" + regularMarketDayLow + '\'' + 
			",ytdReturn = '" + ytdReturn + '\'' + 
			",payoutRatio = '" + payoutRatio + '\'' + 
			",strikePrice = '" + strikePrice + '\'' + 
			",startDate = '" + startDate + '\'' + 
			",fullyDilutedValue = '" + fullyDilutedValue + '\'' + 
			",openInterest = '" + openInterest + '\'' + 
			",regularMarketOpen = '" + regularMarketOpen + '\'' + 
			",trailingAnnualDividendYield = '" + trailingAnnualDividendYield + '\'' + 
			",previousClose = '" + previousClose + '\'' + 
			",averageDailyVolume10Day = '" + averageDailyVolume10Day + '\'' + 
			",allTimeHigh = '" + allTimeHigh + '\'' + 
			",trailingPE = '" + trailingPE + '\'' + 
			",yield = '" + yield + '\'' + 
			",tradeable = '" + tradeable + '\'' + 
			",averageVolume10days = '" + averageVolume10days + '\'' + 
			",expireDate = '" + expireDate + '\'' + 
			",currency = '" + currency + '\'' + 
			",maxSupply = '" + maxSupply + '\'' + 
			",regularMarketPreviousClose = '" + regularMarketPreviousClose + '\'' + 
			",fiftyTwoWeekHigh = '" + fiftyTwoWeekHigh + '\'' + 
			",beta = '" + beta + '\'' + 
			",volume24HrMarketCapPercent = '" + volume24HrMarketCapPercent + '\'' + 
			",volume24Hr = '" + volume24Hr + '\'' + 
			",coinMarketCapLink = '" + coinMarketCapLink + '\'' + 
			",exDividendDate = '" + exDividendDate + '\'' + 
			",bidSize = '" + bidSize + '\'' + 
			",totalSupply = '" + totalSupply + '\'' + 
			",fiveYearAvgDividendYield = '" + fiveYearAvgDividendYield + '\'' + 
			",volumeAllCurrencies = '" + volumeAllCurrencies + '\'' + 
			",fiftyDayAverage = '" + fiftyDayAverage + '\'' + 
			",qtdReturn = '" + qtdReturn + '\'' + 
			",forwardPE = '" + forwardPE + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",averageVolume = '" + averageVolume + '\'' + 
			",ask = '" + ask + '\'' + 
			",bid = '" + bid + '\'' + 
			",open = '" + open + '\'' + 
			",allTimeLow = '" + allTimeLow + '\'' + 
			"}";
		}
}