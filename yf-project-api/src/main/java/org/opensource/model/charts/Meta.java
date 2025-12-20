package org.opensource.model.charts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta{

	@JsonProperty("fullExchangeName")
	private String fullExchangeName;

	@JsonProperty("symbol")
	private String symbol;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("range")
	private String range;

	@JsonProperty("regularMarketTime")
	private int regularMarketTime;

	@JsonProperty("dataGranularity")
	private String dataGranularity;

	@JsonProperty("gmtoffset")
	private int gmtoffset;

	@JsonProperty("regularMarketDayHigh")
	private double regularMarketDayHigh;

	@JsonProperty("chartPreviousClose")
	private double chartPreviousClose;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("currentTradingPeriod")
	private CurrentTradingPeriod currentTradingPeriod;

	@JsonProperty("fiftyTwoWeekHigh")
	private double fiftyTwoWeekHigh;

	@JsonProperty("exchangeTimezoneName")
	private String exchangeTimezoneName;

	@JsonProperty("instrumentType")
	private String instrumentType;

	@JsonProperty("firstTradeDate")
	private int firstTradeDate;

	@JsonProperty("validRanges")
	private List<String> validRanges;

	@JsonProperty("hasPrePostMarketData")
	private boolean hasPrePostMarketData;

	@JsonProperty("regularMarketPrice")
	private double regularMarketPrice;

	@JsonProperty("fiftyTwoWeekLow")
	private double fiftyTwoWeekLow;

	@JsonProperty("regularMarketVolume")
	private int regularMarketVolume;

	@JsonProperty("priceHint")
	private int priceHint;

	@JsonProperty("exchangeName")
	private String exchangeName;

	@JsonProperty("regularMarketDayLow")
	private double regularMarketDayLow;

	@JsonProperty("shortName")
	private String shortName;

	@JsonProperty("longName")
	private String longName;

	public String getFullExchangeName(){
		return fullExchangeName;
	}

	public String getSymbol(){
		return symbol;
	}

	public String getTimezone(){
		return timezone;
	}

	public String getRange(){
		return range;
	}

	public int getRegularMarketTime(){
		return regularMarketTime;
	}

	public String getDataGranularity(){
		return dataGranularity;
	}

	public int getGmtoffset(){
		return gmtoffset;
	}

	public double getRegularMarketDayHigh(){
		return regularMarketDayHigh;
	}

	public double getChartPreviousClose(){
		return chartPreviousClose;
	}

	public String getCurrency(){
		return currency;
	}

	public CurrentTradingPeriod getCurrentTradingPeriod(){
		return currentTradingPeriod;
	}

	public double getFiftyTwoWeekHigh(){
		return fiftyTwoWeekHigh;
	}

	public String getExchangeTimezoneName(){
		return exchangeTimezoneName;
	}

	public String getInstrumentType(){
		return instrumentType;
	}

	public int getFirstTradeDate(){
		return firstTradeDate;
	}

	public List<String> getValidRanges(){
		return validRanges;
	}

	public boolean isHasPrePostMarketData(){
		return hasPrePostMarketData;
	}

	public double getRegularMarketPrice(){
		return regularMarketPrice;
	}

	public double getFiftyTwoWeekLow(){
		return fiftyTwoWeekLow;
	}

	public int getRegularMarketVolume(){
		return regularMarketVolume;
	}

	public int getPriceHint(){
		return priceHint;
	}

	public String getExchangeName(){
		return exchangeName;
	}

	public double getRegularMarketDayLow(){
		return regularMarketDayLow;
	}

	public String getShortName(){
		return shortName;
	}

	public String getLongName(){
		return longName;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"fullExchangeName = '" + fullExchangeName + '\'' + 
			",symbol = '" + symbol + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",range = '" + range + '\'' + 
			",regularMarketTime = '" + regularMarketTime + '\'' + 
			",dataGranularity = '" + dataGranularity + '\'' + 
			",gmtoffset = '" + gmtoffset + '\'' + 
			",regularMarketDayHigh = '" + regularMarketDayHigh + '\'' + 
			",chartPreviousClose = '" + chartPreviousClose + '\'' + 
			",currency = '" + currency + '\'' + 
			",currentTradingPeriod = '" + currentTradingPeriod + '\'' + 
			",fiftyTwoWeekHigh = '" + fiftyTwoWeekHigh + '\'' + 
			",exchangeTimezoneName = '" + exchangeTimezoneName + '\'' + 
			",instrumentType = '" + instrumentType + '\'' + 
			",firstTradeDate = '" + firstTradeDate + '\'' + 
			",validRanges = '" + validRanges + '\'' + 
			",hasPrePostMarketData = '" + hasPrePostMarketData + '\'' + 
			",regularMarketPrice = '" + regularMarketPrice + '\'' + 
			",fiftyTwoWeekLow = '" + fiftyTwoWeekLow + '\'' + 
			",regularMarketVolume = '" + regularMarketVolume + '\'' + 
			",priceHint = '" + priceHint + '\'' + 
			",exchangeName = '" + exchangeName + '\'' + 
			",regularMarketDayLow = '" + regularMarketDayLow + '\'' + 
			",shortName = '" + shortName + '\'' + 
			",longName = '" + longName + '\'' + 
			"}";
		}
}