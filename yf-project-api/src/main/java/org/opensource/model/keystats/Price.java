package org.opensource.model.keystats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price{

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("openInterest")
	private OpenInterest openInterest;

	@JsonProperty("regularMarketOpen")
	private RegularMarketOpen regularMarketOpen;

	@JsonProperty("regularMarketTime")
	private Integer regularMarketTime;

	@JsonProperty("regularMarketChangePercent")
	private RegularMarketChangePercent regularMarketChangePercent;

	@JsonProperty("quoteType")
	private String quoteType;

	@JsonProperty("circulatingSupply")
	private CirculatingSupply circulatingSupply;

	@JsonProperty("averageDailyVolume10Day")
	private AverageDailyVolume10Day averageDailyVolume10Day;

	@JsonProperty("underlyingSymbol")
	private Object underlyingSymbol;

	@JsonProperty("regularMarketDayHigh")
	private RegularMarketDayHigh regularMarketDayHigh;

	@JsonProperty("regularMarketSource")
	private String regularMarketSource;

	@JsonProperty("preMarketPrice")
	private PreMarketPrice preMarketPrice;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("fromCurrency")
	private Object fromCurrency;

	@JsonProperty("regularMarketPreviousClose")
	private RegularMarketPreviousClose regularMarketPreviousClose;

	@JsonProperty("marketCap")
	private MarketCap marketCap;

	@JsonProperty("volume24Hr")
	private Volume24Hr volume24Hr;

	@JsonProperty("regularMarketChange")
	private RegularMarketChange regularMarketChange;

	@JsonProperty("lastMarket")
	private Object lastMarket;

	@JsonProperty("volumeAllCurrencies")
	private VolumeAllCurrencies volumeAllCurrencies;

	@JsonProperty("averageDailyVolume3Month")
	private AverageDailyVolume3Month averageDailyVolume3Month;

	@JsonProperty("exchangeDataDelayedBy")
	private Integer exchangeDataDelayedBy;

	@JsonProperty("currencySymbol")
	private String currencySymbol;

	@JsonProperty("regularMarketPrice")
	private RegularMarketPrice regularMarketPrice;

	@JsonProperty("marketState")
	private String marketState;

	@JsonProperty("regularMarketVolume")
	private RegularMarketVolume regularMarketVolume;

	@JsonProperty("preMarketChange")
	private PreMarketChange preMarketChange;

	@JsonProperty("postMarketPrice")
	private PostMarketPrice postMarketPrice;

	@JsonProperty("quoteSourceName")
	private String quoteSourceName;

	@JsonProperty("postMarketChange")
	private PostMarketChange postMarketChange;

	@JsonProperty("maxAge")
	private Integer maxAge;

	@JsonProperty("toCurrency")
	private Object toCurrency;

	@JsonProperty("priceHint")
	private PriceHint priceHint;

	@JsonProperty("regularMarketDayLow")
	private RegularMarketDayLow regularMarketDayLow;

	@JsonProperty("exchange")
	private String exchange;

	@JsonProperty("exchangeName")
	private String exchangeName;

	@JsonProperty("shortName")
	private String shortName;

	@JsonProperty("strikePrice")
	private StrikePrice strikePrice;

	@JsonProperty("longName")
	private String longName;

	public String getSymbol(){
		return symbol;
	}

	public OpenInterest getOpenInterest(){
		return openInterest;
	}

	public RegularMarketOpen getRegularMarketOpen(){
		return regularMarketOpen;
	}

	public Integer getRegularMarketTime(){
		return regularMarketTime;
	}

	public RegularMarketChangePercent getRegularMarketChangePercent(){
		return regularMarketChangePercent;
	}

	public String getQuoteType(){
		return quoteType;
	}

	public CirculatingSupply getCirculatingSupply(){
		return circulatingSupply;
	}

	public AverageDailyVolume10Day getAverageDailyVolume10Day(){
		return averageDailyVolume10Day;
	}

	public Object getUnderlyingSymbol(){
		return underlyingSymbol;
	}

	public RegularMarketDayHigh getRegularMarketDayHigh(){
		return regularMarketDayHigh;
	}

	public String getRegularMarketSource(){
		return regularMarketSource;
	}

	public PreMarketPrice getPreMarketPrice(){
		return preMarketPrice;
	}

	public String getCurrency(){
		return currency;
	}

	public Object getFromCurrency(){
		return fromCurrency;
	}

	public RegularMarketPreviousClose getRegularMarketPreviousClose(){
		return regularMarketPreviousClose;
	}

	public MarketCap getMarketCap(){
		return marketCap;
	}

	public Volume24Hr getVolume24Hr(){
		return volume24Hr;
	}

	public RegularMarketChange getRegularMarketChange(){
		return regularMarketChange;
	}

	public Object getLastMarket(){
		return lastMarket;
	}

	public VolumeAllCurrencies getVolumeAllCurrencies(){
		return volumeAllCurrencies;
	}

	public AverageDailyVolume3Month getAverageDailyVolume3Month(){
		return averageDailyVolume3Month;
	}

	public Integer getExchangeDataDelayedBy(){
		return exchangeDataDelayedBy;
	}

	public String getCurrencySymbol(){
		return currencySymbol;
	}

	public RegularMarketPrice getRegularMarketPrice(){
		return regularMarketPrice;
	}

	public String getMarketState(){
		return marketState;
	}

	public RegularMarketVolume getRegularMarketVolume(){
		return regularMarketVolume;
	}

	public PreMarketChange getPreMarketChange(){
		return preMarketChange;
	}

	public PostMarketPrice getPostMarketPrice(){
		return postMarketPrice;
	}

	public String getQuoteSourceName(){
		return quoteSourceName;
	}

	public PostMarketChange getPostMarketChange(){
		return postMarketChange;
	}

	public Integer getMaxAge(){
		return maxAge;
	}

	public Object getToCurrency(){
		return toCurrency;
	}

	public PriceHint getPriceHint(){
		return priceHint;
	}

	public RegularMarketDayLow getRegularMarketDayLow(){
		return regularMarketDayLow;
	}

	public String getExchange(){
		return exchange;
	}

	public String getExchangeName(){
		return exchangeName;
	}

	public String getShortName(){
		return shortName;
	}

	public StrikePrice getStrikePrice(){
		return strikePrice;
	}

	public String getLongName(){
		return longName;
	}

	@Override
 	public String toString(){
		return 
			"Price{" + 
			"symbol = '" + symbol + '\'' + 
			",openInterest = '" + openInterest + '\'' + 
			",regularMarketOpen = '" + regularMarketOpen + '\'' + 
			",regularMarketTime = '" + regularMarketTime + '\'' + 
			",regularMarketChangePercent = '" + regularMarketChangePercent + '\'' + 
			",quoteType = '" + quoteType + '\'' + 
			",circulatingSupply = '" + circulatingSupply + '\'' + 
			",averageDailyVolume10Day = '" + averageDailyVolume10Day + '\'' + 
			",underlyingSymbol = '" + underlyingSymbol + '\'' + 
			",regularMarketDayHigh = '" + regularMarketDayHigh + '\'' + 
			",regularMarketSource = '" + regularMarketSource + '\'' + 
			",preMarketPrice = '" + preMarketPrice + '\'' + 
			",currency = '" + currency + '\'' + 
			",fromCurrency = '" + fromCurrency + '\'' + 
			",regularMarketPreviousClose = '" + regularMarketPreviousClose + '\'' + 
			",marketCap = '" + marketCap + '\'' + 
			",volume24Hr = '" + volume24Hr + '\'' + 
			",regularMarketChange = '" + regularMarketChange + '\'' + 
			",lastMarket = '" + lastMarket + '\'' + 
			",volumeAllCurrencies = '" + volumeAllCurrencies + '\'' + 
			",averageDailyVolume3Month = '" + averageDailyVolume3Month + '\'' + 
			",exchangeDataDelayedBy = '" + exchangeDataDelayedBy + '\'' + 
			",currencySymbol = '" + currencySymbol + '\'' + 
			",regularMarketPrice = '" + regularMarketPrice + '\'' + 
			",marketState = '" + marketState + '\'' + 
			",regularMarketVolume = '" + regularMarketVolume + '\'' + 
			",preMarketChange = '" + preMarketChange + '\'' + 
			",postMarketPrice = '" + postMarketPrice + '\'' + 
			",quoteSourceName = '" + quoteSourceName + '\'' + 
			",postMarketChange = '" + postMarketChange + '\'' + 
			",maxAge = '" + maxAge + '\'' + 
			",toCurrency = '" + toCurrency + '\'' + 
			",priceHint = '" + priceHint + '\'' + 
			",regularMarketDayLow = '" + regularMarketDayLow + '\'' + 
			",exchange = '" + exchange + '\'' + 
			",exchangeName = '" + exchangeName + '\'' + 
			",shortName = '" + shortName + '\'' + 
			",strikePrice = '" + strikePrice + '\'' + 
			",longName = '" + longName + '\'' + 
			"}";
		}
}