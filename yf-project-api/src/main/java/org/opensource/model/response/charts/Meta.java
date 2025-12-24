package org.opensource.model.response.charts;

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
	private Long regularMarketTime;

	@JsonProperty("dataGranularity")
	private String dataGranularity;

	@JsonProperty("gmtoffset")
	private Long gmtoffset;

	@JsonProperty("regularMarketDayHigh")
	private Double regularMarketDayHigh;

	@JsonProperty("chartPreviousClose")
	private Double chartPreviousClose;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("currentTradingPeriod")
	private CurrentTradingPeriod currentTradingPeriod;

	@JsonProperty("fiftyTwoWeekHigh")
	private Double fiftyTwoWeekHigh;

	@JsonProperty("exchangeTimezoneName")
	private String exchangeTimezoneName;

	@JsonProperty("instrumentType")
	private String instrumentType;

	@JsonProperty("firstTradeDate")
	private Long firstTradeDate;

	@JsonProperty("validRanges")
	private List<String> validRanges;

	@JsonProperty("hasPrePostMarketData")
	private boolean hasPrePostMarketData;

	@JsonProperty("regularMarketPrice")
	private Double regularMarketPrice;

	@JsonProperty("fiftyTwoWeekLow")
	private Double fiftyTwoWeekLow;

	@JsonProperty("regularMarketVolume")
	private Long regularMarketVolume;

	@JsonProperty("priceHint")
	private Long priceHint;

	@JsonProperty("exchangeName")
	private String exchangeName;

	@JsonProperty("regularMarketDayLow")
	private Double regularMarketDayLow;

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

	public Long getRegularMarketTime(){
		return regularMarketTime;
	}

	public String getDataGranularity(){
		return dataGranularity;
	}

	public Long getGmtoffset(){
		return gmtoffset;
	}

	public Double getRegularMarketDayHigh(){
		return regularMarketDayHigh;
	}

	public Double getChartPreviousClose(){
		return chartPreviousClose;
	}

	public String getCurrency(){
		return currency;
	}

	public CurrentTradingPeriod getCurrentTradingPeriod(){
		return currentTradingPeriod;
	}

	public Double getFiftyTwoWeekHigh(){
		return fiftyTwoWeekHigh;
	}

	public String getExchangeTimezoneName(){
		return exchangeTimezoneName;
	}

	public String getInstrumentType(){
		return instrumentType;
	}

	public Long getFirstTradeDate(){
		return firstTradeDate;
	}

	public List<String> getValidRanges(){
		return validRanges;
	}

	public boolean isHasPrePostMarketData(){
		return hasPrePostMarketData;
	}

	public Double getRegularMarketPrice(){
		return regularMarketPrice;
	}

	public Double getFiftyTwoWeekLow(){
		return fiftyTwoWeekLow;
	}

	public Long getRegularMarketVolume(){
		return regularMarketVolume;
	}

	public Long getPriceHint(){
		return priceHint;
	}

	public String getExchangeName(){
		return exchangeName;
	}

	public Double getRegularMarketDayLow(){
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