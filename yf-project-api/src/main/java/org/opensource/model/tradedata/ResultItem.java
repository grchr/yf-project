package org.opensource.model.tradedata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultItem{

	@JsonProperty("fullExchangeName")
	private String fullExchangeName;

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("fiftyTwoWeekLowChangePercent")
	private FiftyTwoWeekLowChangePercent fiftyTwoWeekLowChangePercent;

	@JsonProperty("gmtOffSetMilliseconds")
	private int gmtOffSetMilliseconds;

	@JsonProperty("regularMarketOpen")
	private RegularMarketOpen regularMarketOpen;

	@JsonProperty("language")
	private String language;

	@JsonProperty("regularMarketTime")
	private RegularMarketTime regularMarketTime;

	@JsonProperty("regularMarketChangePercent")
	private RegularMarketChangePercent regularMarketChangePercent;

	@JsonProperty("quoteType")
	private String quoteType;

	@JsonProperty("regularMarketDayRange")
	private RegularMarketDayRange regularMarketDayRange;

	@JsonProperty("fiftyTwoWeekLowChange")
	private FiftyTwoWeekLowChange fiftyTwoWeekLowChange;

	@JsonProperty("fiftyTwoWeekHighChangePercent")
	private FiftyTwoWeekHighChangePercent fiftyTwoWeekHighChangePercent;

	@JsonProperty("regularMarketDayHigh")
	private RegularMarketDayHigh regularMarketDayHigh;

	@JsonProperty("typeDisp")
	private String typeDisp;

	@JsonProperty("tradeable")
	private boolean tradeable;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("sharesOutstanding")
	private SharesOutstanding sharesOutstanding;

	@JsonProperty("fiftyTwoWeekHigh")
	private FiftyTwoWeekHigh fiftyTwoWeekHigh;

	@JsonProperty("regularMarketPreviousClose")
	private RegularMarketPreviousClose regularMarketPreviousClose;

	@JsonProperty("exchangeTimezoneName")
	private String exchangeTimezoneName;

	@JsonProperty("fiftyTwoWeekHighChange")
	private FiftyTwoWeekHighChange fiftyTwoWeekHighChange;

	@JsonProperty("marketCap")
	private MarketCap marketCap;

	@JsonProperty("regularMarketChange")
	private RegularMarketChange regularMarketChange;

	@JsonProperty("fiftyTwoWeekRange")
	private FiftyTwoWeekRange fiftyTwoWeekRange;

	@JsonProperty("cryptoTradeable")
	private boolean cryptoTradeable;

	@JsonProperty("firstTradeDateMilliseconds")
	private long firstTradeDateMilliseconds;

	@JsonProperty("exchangeDataDelayedBy")
	private int exchangeDataDelayedBy;

	@JsonProperty("exchangeTimezoneShortName")
	private String exchangeTimezoneShortName;

	@JsonProperty("hasPrePostMarketData")
	private boolean hasPrePostMarketData;

	@JsonProperty("quartrId")
	private String quartrId;

	@JsonProperty("marketState")
	private String marketState;

	@JsonProperty("fiftyTwoWeekLow")
	private FiftyTwoWeekLow fiftyTwoWeekLow;

	@JsonProperty("customPriceAlertConfidence")
	private String customPriceAlertConfidence;

	@JsonProperty("regularMarketPrice")
	private RegularMarketPrice regularMarketPrice;

	@JsonProperty("regularMarketVolume")
	private RegularMarketVolume regularMarketVolume;

	@JsonProperty("market")
	private String market;

	@JsonProperty("quoteSourceName")
	private String quoteSourceName;

	@JsonProperty("messageBoardId")
	private String messageBoardId;

	@JsonProperty("priceHint")
	private int priceHint;

	@JsonProperty("regularMarketDayLow")
	private RegularMarketDayLow regularMarketDayLow;

	@JsonProperty("sourceInterval")
	private int sourceInterval;

	@JsonProperty("exchange")
	private String exchange;

	@JsonProperty("shortName")
	private String shortName;

	@JsonProperty("region")
	private String region;

	@JsonProperty("triggerable")
	private boolean triggerable;

	@JsonProperty("longName")
	private String longName;

	public String getFullExchangeName(){
		return fullExchangeName;
	}

	public String getSymbol(){
		return symbol;
	}

	public FiftyTwoWeekLowChangePercent getFiftyTwoWeekLowChangePercent(){
		return fiftyTwoWeekLowChangePercent;
	}

	public int getGmtOffSetMilliseconds(){
		return gmtOffSetMilliseconds;
	}

	public RegularMarketOpen getRegularMarketOpen(){
		return regularMarketOpen;
	}

	public String getLanguage(){
		return language;
	}

	public RegularMarketTime getRegularMarketTime(){
		return regularMarketTime;
	}

	public RegularMarketChangePercent getRegularMarketChangePercent(){
		return regularMarketChangePercent;
	}

	public String getQuoteType(){
		return quoteType;
	}

	public RegularMarketDayRange getRegularMarketDayRange(){
		return regularMarketDayRange;
	}

	public FiftyTwoWeekLowChange getFiftyTwoWeekLowChange(){
		return fiftyTwoWeekLowChange;
	}

	public FiftyTwoWeekHighChangePercent getFiftyTwoWeekHighChangePercent(){
		return fiftyTwoWeekHighChangePercent;
	}

	public RegularMarketDayHigh getRegularMarketDayHigh(){
		return regularMarketDayHigh;
	}

	public String getTypeDisp(){
		return typeDisp;
	}

	public boolean isTradeable(){
		return tradeable;
	}

	public String getCurrency(){
		return currency;
	}

	public SharesOutstanding getSharesOutstanding(){
		return sharesOutstanding;
	}

	public FiftyTwoWeekHigh getFiftyTwoWeekHigh(){
		return fiftyTwoWeekHigh;
	}

	public RegularMarketPreviousClose getRegularMarketPreviousClose(){
		return regularMarketPreviousClose;
	}

	public String getExchangeTimezoneName(){
		return exchangeTimezoneName;
	}

	public FiftyTwoWeekHighChange getFiftyTwoWeekHighChange(){
		return fiftyTwoWeekHighChange;
	}

	public MarketCap getMarketCap(){
		return marketCap;
	}

	public RegularMarketChange getRegularMarketChange(){
		return regularMarketChange;
	}

	public FiftyTwoWeekRange getFiftyTwoWeekRange(){
		return fiftyTwoWeekRange;
	}

	public boolean isCryptoTradeable(){
		return cryptoTradeable;
	}

	public long getFirstTradeDateMilliseconds(){
		return firstTradeDateMilliseconds;
	}

	public int getExchangeDataDelayedBy(){
		return exchangeDataDelayedBy;
	}

	public String getExchangeTimezoneShortName(){
		return exchangeTimezoneShortName;
	}

	public boolean isHasPrePostMarketData(){
		return hasPrePostMarketData;
	}

	public String getQuartrId(){
		return quartrId;
	}

	public String getMarketState(){
		return marketState;
	}

	public FiftyTwoWeekLow getFiftyTwoWeekLow(){
		return fiftyTwoWeekLow;
	}

	public String getCustomPriceAlertConfidence(){
		return customPriceAlertConfidence;
	}

	public RegularMarketPrice getRegularMarketPrice(){
		return regularMarketPrice;
	}

	public RegularMarketVolume getRegularMarketVolume(){
		return regularMarketVolume;
	}

	public String getMarket(){
		return market;
	}

	public String getQuoteSourceName(){
		return quoteSourceName;
	}

	public String getMessageBoardId(){
		return messageBoardId;
	}

	public int getPriceHint(){
		return priceHint;
	}

	public RegularMarketDayLow getRegularMarketDayLow(){
		return regularMarketDayLow;
	}

	public int getSourceInterval(){
		return sourceInterval;
	}

	public String getExchange(){
		return exchange;
	}

	public String getShortName(){
		return shortName;
	}

	public String getRegion(){
		return region;
	}

	public boolean isTriggerable(){
		return triggerable;
	}

	public String getLongName(){
		return longName;
	}
}