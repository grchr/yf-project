package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.CashFlowTitles;
import org.opensource.enums.IncomeStatementTitles;
import org.opensource.enums.KeyStatisticsPositions;
import org.opensource.enums.KeyStatisticsTitles;
import org.opensource.model.CompanyKeyStatistics;
import org.opensource.model.CompanyTradingInformation;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.opensource.service.ReaderHelpers.createURL;
import static org.opensource.service.ReaderHelpers.getCompanyName;
import static org.opensource.service.ReaderHelpers.getCurrentPrice;
import static org.opensource.service.ReaderHelpers.getDoubleFromPercentageValue;
import static org.opensource.service.ReaderHelpers.getDoubleFromStringSimpleCase;
import static org.opensource.service.ReaderHelpers.getValueFromElements;

public class GetKeyStatisticsService extends AbstractWebTitleIterableService<KeyStatisticsTitles> implements IWebExecutableService<CompanyKeyStatistics>{

  private static final String URL = "https://finance.yahoo.com/quote/%s/key-statistics/";
  private static final String KEY_STATISTICS_SELECTOR = "td";

  private final ExecutorService executor =  new ThreadPoolExecutor(10, 50,
          60L, TimeUnit.SECONDS,
          new SynchronousQueue<>());

  private final BlockingQueue<HtmlUnitDriver> driverPool = new LinkedBlockingQueue<>(10);

  public GetKeyStatisticsService() {
    // Initialize pool with pre-created drivers (you can adjust the pool size)
    for (int i = 0; i < 10; i++) {
      driverPool.add(new HtmlUnitDriver());
    }
  }

  private HtmlUnitDriver acquireDriver() throws InterruptedException {
    return driverPool.take(); // Blocks if no driver is available
  }

  private void releaseDriver(HtmlUnitDriver driver) {
    driverPool.offer(driver); // Return driver to pool
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
      builder.withCurrentPrice(getDoubleFromStringSimpleCase(getCurrentPrice(pageDocument, ticker)));
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
  public void shutdown() {
    // Shutdown the executor service
    executor.shutdown();
  }

  @Override
  protected CompanyKeyStatistics.Builder populateBuilderWithMainInfo(Elements tdElements) {
    CompanyKeyStatistics.Builder builder = new CompanyKeyStatistics.Builder();
    Map<KeyStatisticsTitles, String> mainDataMap = fillMap(tdElements, 1);

    return builder.withMarketCap(getTitleValue(mainDataMap, KeyStatisticsTitles.MARKET_CAP))
            .withEnterpriseValue(getTitleValue(mainDataMap, KeyStatisticsTitles.ENTERPRISE_VALUE))
            .withTrailingPE(getDoubleFromStringSimpleCase(getTitleValue(mainDataMap, KeyStatisticsTitles.TRAILING_PE)));

//    return builder.withMarketCap(getValueFromElements(tdElements, KeyStatisticsPositions.MARKET_CAP.getValue()))
//            .withEnterpriseValue(getValueFromElements(tdElements, KeyStatisticsPositions.ENTERPRISE_VALUE.getValue()))
//            .withTrailingPE(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.TRAILING_PE.getValue())))
//            .withForwardPE(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.FORWARD_PE.getValue())))
//            .withPegRatio(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.PEG_RATIO.getValue())))
//            .withRatioPS(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.PS_RATIO.getValue())))
//            .withRatioPB(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.PB_RATIO.getValue())))
//            .withEvToRevenue(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.EV_TO_REVENUE.getValue())))
//            .withEvToEBITDA(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.EV_TO_EBITDA.getValue())))
//            .withProfitMarginPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.PROFIT_MARGIN.getValue())))
//            .withOperatingMarginPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.OPERATING_MARGIN.getValue())))
//            .withReturnOnAssetsPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.RETURN_ON_ASSETS.getValue())))
//            .withReturnOnEquityPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.RETURN_ON_EQUITY.getValue())))
//            .withRevenue(getValueFromElements(tdElements, KeyStatisticsPositions.REVENUE.getValue()))
//            .withRevenuePerShare(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.REVENUE_PER_SHARE.getValue())))
//            .withQuarterlyRevenueGrowthPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.QUARTERLY_REV_GROWTH.getValue())))
//            .withGrossProfit(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.GROSS_PROFIT.getValue())))
//            .withEBITDA(getValueFromElements(tdElements, KeyStatisticsPositions.EBITDA.getValue()))
//            .withNetIncomeAviToCommon(getValueFromElements(tdElements, KeyStatisticsPositions.NET_INC_AVI_TO_COMMON.getValue()))
//            .withDilutedEPS(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.DILUTED_EPS.getValue())))
//            .withQuartEarningsGrowthPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.QUARTERLY_EARNINGS_GROWTH.getValue())))
//            .withTotalCash(getValueFromElements(tdElements, KeyStatisticsPositions.TOTAL_CASH.getValue()))
//            .withTotalCashPerShare(getDoubleFromStringSimpleCase(getValueFromElements(tdElements, KeyStatisticsPositions.TOTAL_CASH_PER_SHARE.getValue())))
//            .withTotalDebt(getValueFromElements(tdElements, KeyStatisticsPositions.TOTAL_DEBT.getValue()))
//            .withTotalDebtToEquityPercentage(getDoubleFromPercentageValue(getValueFromElements(tdElements, KeyStatisticsPositions.TOTAL_DEBT_TO_EQUITY.getValue())))
//            .withTradingInformation(getCompanyTradingInformation(tdElements));
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

  @Override
  protected String getTitleValue(Map<KeyStatisticsTitles, String> keyStatisticsMap, KeyStatisticsTitles title) {
    if (keyStatisticsMap.containsKey(title)) {
      return keyStatisticsMap.get(title);
    }
    return DEFAULT;
  }

  private CompanyTradingInformation getCompanyTradingInformation(Elements tdElements) {
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
    return builder.build();
  }
}
