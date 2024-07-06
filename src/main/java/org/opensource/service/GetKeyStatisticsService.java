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

      builder.withCompanyName(getCompanyName(pageDocument));
      builder.withCurrentPrice(getCurrentPrice(pageDocument));

      Elements tdElements = pageDocument.select(KEY_STATISTICS_SELECTOR);

      if (CollectionUtils.isNotEmpty(tdElements)) {
        builder.withCompanyTicker(tickerCaps)
                .withMarketCap(getValueFromElements(tdElements, KeyStatisticsPositions.MARKET_CAP.getValue()))
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
                .withRevenue(getValueFromElements(tdElements, KeyStatisticsPositions.REVENUE.getValue()));
      }
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

        builder.withCompanyName(getCompanyName(pageDocument));
        builder.withCurrentPrice(getCurrentPrice(pageDocument));

        Elements tdElements = pageDocument.select(KEY_STATISTICS_SELECTOR);
        if (CollectionUtils.isNotEmpty(tdElements)) {
          builder.withCompanyTicker(tickerCaps)
                  .withMarketCap(getValueFromElements(tdElements, KeyStatisticsPositions.MARKET_CAP.getValue()))
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
                  .withRevenue(getValueFromElements(tdElements, KeyStatisticsPositions.REVENUE.getValue()));
        }
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
    if (elements.size() >= position) {
      return elements.get(position).text();
    }
    return "--";
  }
}
