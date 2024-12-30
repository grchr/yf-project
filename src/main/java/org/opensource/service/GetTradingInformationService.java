package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.KeyStatisticsTitles;
import org.opensource.model.CompanyTradingInformation;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.opensource.service.ReaderHelpers.createURL;
import static org.opensource.service.ReaderHelpers.getCompanyName;
import static org.opensource.service.ReaderHelpers.getCurrentPrice;
import static org.opensource.service.ReaderHelpers.getDoubleFromString;

public class GetTradingInformationService extends AbstractWebDataService<KeyStatisticsTitles> implements IWebExecutableService<CompanyTradingInformation>{

  private static final String URL = "https://finance.yahoo.com/quote/%s/key-statistics/";
  private static final String KEY_STATISTICS_SELECTOR = "td";

  private final ExecutorService executor = Executors.newCachedThreadPool();

  @Override
  public CompanyTradingInformation execute(String ticker) {
    CompanyTradingInformation.Builder builder = new CompanyTradingInformation.Builder();
    HtmlUnitDriver driver = null;
    String tickerCaps = StringUtils.capitalize(ticker);
    try {
      driver  = acquireDriver();
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
  public CompletableFuture<CompanyTradingInformation> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), executor);
  }

  @Override
  protected CompanyTradingInformation.Builder populateBuilderWithMainInfo(Elements tdElements) {
    CompanyTradingInformation.Builder builder = new CompanyTradingInformation.Builder();
    Map<KeyStatisticsTitles, String> mainDataMap = fillMap(tdElements, 1);

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
    return builder;
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
}
