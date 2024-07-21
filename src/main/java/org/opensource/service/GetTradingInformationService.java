package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.KeyStatisticsPositions;
import org.opensource.model.CompanyTradingInformation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.opensource.service.ReaderHelpers.createURL;
import static org.opensource.service.ReaderHelpers.getCompanyName;
import static org.opensource.service.ReaderHelpers.getCurrentPrice;
import static org.opensource.service.ReaderHelpers.getDoubleFromPercentageValue;
import static org.opensource.service.ReaderHelpers.getDoubleFromStringSimpleCase;
import static org.opensource.service.ReaderHelpers.getValueFromElements;

public class GetTradingInformationService implements IWebExecutableService<CompanyTradingInformation>{

  private static final String URL = "https://finance.yahoo.com/quote/%s/key-statistics/";
  private static final String KEY_STATISTICS_SELECTOR = "td";

  private final ExecutorService executor = Executors.newCachedThreadPool();

  @Override
  public CompanyTradingInformation execute(String ticker) {
    CompanyTradingInformation.Builder builder = new CompanyTradingInformation.Builder();
    HtmlUnitDriver driver = new HtmlUnitDriver();
    String tickerCaps = StringUtils.capitalize(ticker);
    try {
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
      builder.withCurrentPrice(getDoubleFromStringSimpleCase(getCurrentPrice(pageDocument, ticker)));
      builder.withCompanyTicker(tickerCaps);

    } finally {
      driver.quit();
    }

    return builder.build();
  }

  @Override
  public CompletableFuture<CompanyTradingInformation> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() -> {
      CompanyTradingInformation.Builder builder = new CompanyTradingInformation.Builder();
      String tickerCaps = StringUtils.capitalize(ticker);
      HtmlUnitDriver driver = new HtmlUnitDriver();
      try {
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
        builder.withCurrentPrice(getDoubleFromStringSimpleCase(getCurrentPrice(pageDocument, ticker)));
        builder.withCompanyTicker(tickerCaps);

      } finally {
        driver.quit();
      }
      return builder.build();
    }, executor);
  }

  @Override
  public void shutdown() {
    // Shutdown the executor service
    executor.shutdown();
  }

  private CompanyTradingInformation.Builder populateBuilderWithMainInfo(Elements tdElements) {
    CompanyTradingInformation.Builder builder = new CompanyTradingInformation.Builder();
    builder.withBeta(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.BETA.getValue())))
            .withCurrentRatio(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.CURRENT_RATIO.getValue())))
            .withWeek52RangePercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.WEEK_52_RANGE.getValue())))
            .withWeek52High(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.WEEK_52_HIGH.getValue())))
            .withWeek52Low(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.WEEK_52_LOW.getValue())))
            .withDay50MovingAvg(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.DAY_50_MOVING_AVG.getValue())))
            .withDay200MovingAverage(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.DAY_200_MOVING_AVG.getValue())))
            .withForwardAnnualDividendYieldPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_YIELD_FWD_ANNUAL.getValue())))
            .withForwardAnnualDividendRate(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_RATE_FWD_ANNUAL.getValue())))
            .withDividendYield5YearAvg(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_YIELD_5_YEAR_AVG.getValue())))
            .withTrailingAnnualDividendRate(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_RATE_TRAILING_ANNUAL.getValue())))
            .withTrailingAnnualDividendYieldPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_YIELD_TRAILING_ANNUAL.getValue())))
            .withPayoutRatioPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.PAYOUT_RATIO.getValue())));
    return builder;
  }
}
