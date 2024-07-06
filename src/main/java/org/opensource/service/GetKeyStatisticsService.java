package org.opensource.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.KeyStatisticsPositions;
import org.opensource.model.CompanyKeyStatistics;
import org.opensource.model.CompanyTradingInformation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetKeyStatisticsService implements SeleniumExecutableService<CompanyKeyStatistics>{

  private static final String URL = "https://finance.yahoo.com/quote/%s/key-statistics/";
  private static final String KEY_STATISTICS_SELECTOR = "td";
  private static final String COMPANY_NAME_SELECTOR = "h1";
  private static final int COMPANY_NAME_POSITION = 1;
  private static final String CURRENT_PRICE_FIRST_SELECTOR = "div.container.svelte-mgkamr";
  private static final String CURRENT_PRICE_SECOND_SELECTOR = "span";
  private static final int CURRENT_PRICE_POSITION = 0;
  private static final String EXIT_CONDITION = "lookup";

  private final ExecutorService executor = Executors.newCachedThreadPool();

  @Override
  public CompanyKeyStatistics execute(String ticker) {
    CompanyKeyStatistics.Builder builder = new CompanyKeyStatistics.Builder();
    HtmlUnitDriver driver = new HtmlUnitDriver();
    String tickerCaps = StringUtils.capitalize(ticker);
    try {
      driver.get(createURL(tickerCaps));
      Document pageDocument = Jsoup.parse(driver.getPageSource());
      if (driver.getCurrentUrl().contains(EXIT_CONDITION)) {
        return builder.build();
      }
      Elements tdElements = pageDocument.select(KEY_STATISTICS_SELECTOR);
      if (CollectionUtils.isNotEmpty(tdElements)) {
        builder = populateBuilderWithMainInfo(tdElements);
      }

      builder.withCompanyName(getCompanyName(pageDocument));
      builder.withCurrentPrice(getCurrentPrice(pageDocument));
      builder.withCompanyTicker(tickerCaps);

    } finally {
      driver.quit();
    }

    return builder.build();
  }

  private String getCompanyName(Document pageDocument) {
    Elements headTitles = pageDocument.select(COMPANY_NAME_SELECTOR);
    if (CollectionUtils.isNotEmpty(headTitles)) {
      return getValueFromElements(headTitles, COMPANY_NAME_POSITION);
    }
    return "--";
  }

  private String getCurrentPrice(Document pageDocument) {
    Element container = pageDocument.selectFirst(CURRENT_PRICE_FIRST_SELECTOR);
    // Select all span elements within the specific container
    if (container != null) {
      Elements spans = container.select(CURRENT_PRICE_SECOND_SELECTOR);
      if (CollectionUtils.isNotEmpty(spans)) {
        return getValueFromElements(spans, CURRENT_PRICE_POSITION);
      }
    }
    return "--";
  }

  @Override
  public CompletableFuture<CompanyKeyStatistics> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() -> {
      String tickerCaps = StringUtils.capitalize(ticker);
      CompanyKeyStatistics.Builder builder = new CompanyKeyStatistics.Builder();
      HtmlUnitDriver driver = new HtmlUnitDriver();
      try {
        driver.get(createURL(tickerCaps));
        Document pageDocument = Jsoup.parse(driver.getPageSource());
        if (driver.getCurrentUrl().contains(EXIT_CONDITION)) {
          return builder.build();
        }
        Elements tdElements = pageDocument.select(KEY_STATISTICS_SELECTOR);
        if (CollectionUtils.isNotEmpty(tdElements)) {
          builder = populateBuilderWithMainInfo(tdElements);
        }

        builder.withCompanyName(getCompanyName(pageDocument));
        builder.withCurrentPrice(getCurrentPrice(pageDocument));
        builder.withCompanyTicker(tickerCaps);

      } finally {
        driver.quit();
      }
      return builder.build();
    }, executor);
  }

  public void shutdown() {
    // Shutdown the executor service
    executor.shutdown();
  }

  private String createURL(String ticker) {
    return String.format(URL, ticker);
  }

  private String getValueFromElements(Elements elements, int position) {
    if (elements.size() > position) {
      return elements.get(position).text();
    }
    return "--";
  }

  private CompanyKeyStatistics.Builder populateBuilderWithMainInfo(Elements tdElements) {
    return new CompanyKeyStatistics.Builder().withMarketCap(getValueFromElements(tdElements, KeyStatisticsPositions.MARKET_CAP.getValue()))
            .withEnterpriseValue(getValueFromElements(tdElements, KeyStatisticsPositions.ENTERPRISE_VALUE.getValue()))
            .withTrailingPE(getValueFromElements(tdElements, KeyStatisticsPositions.TRAILING_PE.getValue()))
            .withForwardPE(getValueFromElements(tdElements, KeyStatisticsPositions.FORWARD_PE.getValue()))
            .withPegRatio(getValueFromElements(tdElements, KeyStatisticsPositions.PEG_RATIO.getValue()))
            .withRatioPS(getValueFromElements(tdElements, KeyStatisticsPositions.PS_RATIO.getValue()))
            .withRatioPB(getValueFromElements(tdElements, KeyStatisticsPositions.PB_RATIO.getValue()))
            .withEvToRevenue(getValueFromElements(tdElements, KeyStatisticsPositions.EV_TO_REVENUE.getValue()))
            .withEvToEBITDA(getValueFromElements(tdElements, KeyStatisticsPositions.EV_TO_EBITDA.getValue()))
            .withProfitMargin(getValueFromElements(tdElements, KeyStatisticsPositions.PROFIT_MARGIN.getValue()))
            .withOperatingMargin(getValueFromElements(tdElements, KeyStatisticsPositions.OPERATING_MARGIN.getValue()))
            .withReturnOnAssets(getValueFromElements(tdElements, KeyStatisticsPositions.RETURN_ON_ASSETS.getValue()))
            .withReturnOnEquity(getValueFromElements(tdElements, KeyStatisticsPositions.RETURN_ON_EQUITY.getValue()))
            .withRevenue(getValueFromElements(tdElements, KeyStatisticsPositions.REVENUE.getValue()))
            .withRevenuePerShare(getValueFromElements(tdElements, KeyStatisticsPositions.REVENUE_PER_SHARE.getValue()))
            .withQuarterlyRevenueGrowth(getValueFromElements(tdElements, KeyStatisticsPositions.QUARTERLY_REV_GROWTH.getValue()))
            .withGrossProfit(getValueFromElements(tdElements, KeyStatisticsPositions.GROSS_PROFIT.getValue()))
            .withEBITDA(getValueFromElements(tdElements, KeyStatisticsPositions.EBITDA.getValue()))
            .withNetIncomeAviToCommon(getValueFromElements(tdElements, KeyStatisticsPositions.NET_INC_AVI_TO_COMMON.getValue()))
            .withDilutedEPS(getValueFromElements(tdElements, KeyStatisticsPositions.DILUTED_EPS.getValue()))
            .withQuartEarningsGrowth(getValueFromElements(tdElements, KeyStatisticsPositions.QUARTERLY_EARNINGS_GROWTH.getValue()))
            .withTotalCash(getValueFromElements(tdElements, KeyStatisticsPositions.TOTAL_CASH.getValue()))
            .withTotalCashPerShare(getValueFromElements(tdElements, KeyStatisticsPositions.TOTAL_CASH_PER_SHARE.getValue()))
            .withTotalDebt(getValueFromElements(tdElements, KeyStatisticsPositions.TOTAL_DEBT.getValue()))
            .withTotalDebtToEquity(getValueFromElements(tdElements, KeyStatisticsPositions.TOTAL_DEBT_TO_EQUITY.getValue()))
            .withTradingInformation(getCompanyTradingInformation(tdElements));
  }

  private CompanyTradingInformation getCompanyTradingInformation(Elements tdElements) {
    CompanyTradingInformation.Builder builder = new CompanyTradingInformation.Builder();
    builder.withBeta(getValueFromElements(tdElements, KeyStatisticsPositions.BETA.getValue()))
            .withCurrentRatio(getValueFromElements(tdElements, KeyStatisticsPositions.CURRENT_RATIO.getValue()))
            .withWeek52Range(getValueFromElements(tdElements, KeyStatisticsPositions.WEEK_52_RANGE.getValue()))
            .withWeek52High(getValueFromElements(tdElements, KeyStatisticsPositions.WEEK_52_HIGH.getValue()))
            .withWeek52Low(getValueFromElements(tdElements, KeyStatisticsPositions.WEEK_52_LOW.getValue()))
            .withDay50MovingAvg(getValueFromElements(tdElements, KeyStatisticsPositions.DAY_50_MOVING_AVG.getValue()))
            .withDay200MovingAverage(getValueFromElements(tdElements, KeyStatisticsPositions.DAY_200_MOVING_AVG.getValue()))
            .withForwardAnnualDividendYield(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_YIELD_FWD_ANNUAL.getValue()))
            .withForwardAnnualDividendRate(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_RATE_FWD_ANNUAL.getValue()))
            .withDividendYield5YearAvg(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_YIELD_5_YEAR_AVG.getValue()))
            .withTrailingAnnualDividendRate(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_RATE_TRAILING_ANNUAL.getValue()))
            .withTrailingAnnualDividendYield(getValueFromElements(tdElements, KeyStatisticsPositions.DIVIDEND_YIELD_TRAILING_ANNUAL.getValue()))
            .withPayoutRatio(getValueFromElements(tdElements, KeyStatisticsPositions.PAYOUT_RATIO.getValue()));
    return builder.build();
  }
}
