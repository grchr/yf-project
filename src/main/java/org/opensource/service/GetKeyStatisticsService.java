package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.KeyStatisticsTitles;
import org.opensource.model.CompanyKeyStatistics;
import org.opensource.model.CompanyTradingInformation;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import static org.opensource.service.helpers.ReaderHelpers.createURL;
import static org.opensource.service.helpers.ReaderHelpers.getCompanyName;
import static org.opensource.service.helpers.ReaderHelpers.getCurrentPrice;
import static org.opensource.service.helpers.ReaderHelpers.getDoubleFromString;

public class GetKeyStatisticsService extends AbstractWebDataService<KeyStatisticsTitles> implements IWebExecutableService<CompanyKeyStatistics>{

  private static final String URL = "https://finance.yahoo.com/quote/%s/key-statistics/";
  private static final String KEY_STATISTICS_SELECTOR = "td";

  public GetKeyStatisticsService() {
    super();
  }

  @Override
  public CompanyKeyStatistics execute(String ticker) {
    CompanyKeyStatistics.Builder builder = new CompanyKeyStatistics.Builder();
    HtmlUnitDriver driver = null;
    String tickerCaps = StringUtils.capitalize(ticker);
    try {
      driver = acquireDriver();
      String tickerURL = createURL(URL, tickerCaps);
      driver.get(tickerURL);
      if (!tickerURL.equals(driver.getCurrentUrl())) {
        return builder.build();
      }
      Document pageDocument = Jsoup.parse(driver.getPageSource());
      Elements dataElements = pageDocument.select(KEY_STATISTICS_SELECTOR);
      if (CollectionUtils.isNotEmpty(dataElements)) {
        builder = populateBuilderWithMainInfo(dataElements);
      }

      builder.withCompanyName(getCompanyName(pageDocument));
      builder.withCurrentPrice(getDoubleFromString(getCurrentPrice(pageDocument, ticker)));
      builder.withCompanyTicker(tickerCaps);

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      if (driver != null) {
        releaseDriver(driver);  // Release driver back to pool
      }
    }

    return builder.build();
  }

  @Override
  public CompletableFuture<CompanyKeyStatistics> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), executor);
  }

  @Override
  public CompletableFuture<CompanyKeyStatistics> executeAsync(String ticker, ExecutorService customExecutor) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), customExecutor);
  }

  @Override
  protected CompanyKeyStatistics.Builder populateBuilderWithMainInfo(Elements tdElements) {
    CompanyKeyStatistics.Builder builder = new CompanyKeyStatistics.Builder();
    Map<KeyStatisticsTitles, String> mainDataMap = fillMap(tdElements, 1);
    return builder.withMarketCap(getTitleValue(mainDataMap, KeyStatisticsTitles.MARKET_CAP))
        .withEnterpriseValue(getTitleValue(mainDataMap, KeyStatisticsTitles.ENTERPRISE_VALUE))
        .withTrailingPE(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.TRAILING_PE)))
        .withForwardPE(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.FORWARD_PE)))
        .withPegRatio(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.PEG_RATIO)))
        .withRatioPS(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.PS_RATIO)))
        .withRatioPB(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.PB_RATIO)))
        .withEvToRevenue(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.EV_TO_REVENUE)))
        .withEvToEBITDA(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.EV_TO_EBITDA)))
        .withProfitMarginPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.PROFIT_MARGIN)))
        .withOperatingMarginPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.OPERATING_MARGIN)))
        .withReturnOnAssetsPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.RETURN_ON_ASSETS)))
        .withReturnOnEquityPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.RETURN_ON_EQUITY)))
        .withQuarterlyRevenueGrowthPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.QUARTERLY_REV_GROWTH)))
        .withGrossProfit(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.GROSS_PROFIT)))
        .withEBITDA(getTitleValue(mainDataMap, KeyStatisticsTitles.EBITDA))
        .withNetIncomeAviToCommon(getTitleValue(mainDataMap, KeyStatisticsTitles.NET_INC_AVI_TO_COMMON))
        .withDilutedEPS(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.DILUTED_EPS)))
        .withQuartEarningsGrowthPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.QUARTERLY_EARNINGS_GROWTH)))
        .withTotalCash(getTitleValue(mainDataMap, KeyStatisticsTitles.TOTAL_CASH))
        .withTotalCashPerShare(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.TOTAL_CASH_PER_SHARE)))
        .withTotalDebt(getTitleValue(mainDataMap, KeyStatisticsTitles.TOTAL_DEBT))
        .withTotalDebtToEquityPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.TOTAL_DEBT_TO_EQUITY)))
        .withRevenue(getTitleValue(mainDataMap, KeyStatisticsTitles.REVENUE))
        .withRevenuePerShare(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.REVENUE_PER_SHARE)))
        .withTradingInformation(getCompanyTradingInformation(mainDataMap));

  }

  @Override
  protected EnumMap<KeyStatisticsTitles, String> fillMap(Elements dataElements, int valueOffset) {
    EnumMap<KeyStatisticsTitles, String> map = new EnumMap<>(KeyStatisticsTitles.class);

    for (int currentPosition = 0; currentPosition < dataElements.size(); currentPosition++) {
      Element currentElement = dataElements.get(currentPosition);
      KeyStatisticsTitles title = KeyStatisticsTitles.fromTitle(currentElement.text());

      if (title != null && currentPosition + valueOffset < dataElements.size()) {
        Element nextElement = dataElements.get(currentPosition + valueOffset);
        map.put(title, nextElement.text());
      }
    }

    return map;
  }

  private CompanyTradingInformation getCompanyTradingInformation(Map<KeyStatisticsTitles, String> mainDataMap) {
    CompanyTradingInformation.Builder builder = new CompanyTradingInformation.Builder();
    builder.withBeta(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.BETA)))
            .withCurrentRatio(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.CURRENT_RATIO)))
            .withWeek52RangePercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.WEEK_52_RANGE)))
            .withWeek52High(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.WEEK_52_HIGH)))
            .withWeek52Low(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.WEEK_52_LOW)))
            .withDay50MovingAvg(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.DAY_50_MOVING_AVG)))
            .withDay200MovingAverage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.DAY_200_MOVING_AVG)))
            .withForwardAnnualDividendYieldPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.DIVIDEND_YIELD_FWD_ANNUAL)))
            .withForwardAnnualDividendRate(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.DIVIDEND_RATE_FWD_ANNUAL)))
            .withDividendYield5YearAvg(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.DIVIDEND_YIELD_5_YEAR_AVG)))
            .withTrailingAnnualDividendRate(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.DIVIDEND_RATE_TRAILING_ANNUAL)))
            .withTrailingAnnualDividendYieldPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.DIVIDEND_YIELD_TRAILING_ANNUAL)))
            .withPayoutRatioPercentage(getDoubleFromString(getTitleValue(mainDataMap, KeyStatisticsTitles.PAYOUT_RATIO)))
            .withDividendDate(getTitleValue(mainDataMap, KeyStatisticsTitles.DIVIDEND_DATE))
            .withExDividendDate(getTitleValue(mainDataMap, KeyStatisticsTitles.DIVIDEND_EX_DATE));
    return builder.build();
  }
}
