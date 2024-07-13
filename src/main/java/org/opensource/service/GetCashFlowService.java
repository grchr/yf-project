package org.opensource.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.BalanceSheetTitles;
import org.opensource.enums.CashFlowTitles;
import org.opensource.model.AbstractCompanyInformation;
import org.opensource.model.CompanyBalanceSheet;
import org.opensource.model.CompanyCashFlow;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.opensource.service.ReaderHelpers.createURL;
import static org.opensource.service.ReaderHelpers.getCompanyName;
import static org.opensource.service.ReaderHelpers.getCurrentPrice;

public class GetCashFlowService extends AbstractWebTitleIterableService<CashFlowTitles> implements IWebExecutableService<CompanyCashFlow>{

  private static final String URL = "https://finance.yahoo.com/quote/%s/cash-flow/";
  private final ExecutorService executor = Executors.newCachedThreadPool();

  @Override
  public CompanyCashFlow execute(String ticker) {
    CompanyCashFlow.Builder builder = new CompanyCashFlow.Builder();
    HtmlUnitDriver driver = new HtmlUnitDriver();
    String tickerCaps = StringUtils.capitalize(ticker);
    try {
      String tickerURL = createURL(URL, tickerCaps);
      driver.get(tickerURL);
      if (!tickerURL.equals(driver.getCurrentUrl())) {
        return builder.build();
      }
      Document pageDocument = Jsoup.parse(driver.getPageSource());
      Elements dataElements = pageDocument.select(TITLES_SELECTOR);
      if (CollectionUtils.isNotEmpty(dataElements)) {
        builder = populateBuilderWithMainInfo(dataElements);
      }

      builder.withCompanyName(getCompanyName(pageDocument));
      builder.withCurrentPrice(getCurrentPrice(pageDocument));
      builder.withCompanyTicker(tickerCaps);

    } finally {
      driver.quit();
    }
    return builder.build();
  }

  @Override
  public CompletableFuture<CompanyCashFlow> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() -> {
      CompanyCashFlow.Builder builder = new CompanyCashFlow.Builder();
      HtmlUnitDriver driver = new HtmlUnitDriver();
      String tickerCaps = StringUtils.capitalize(ticker);
      try {
        String tickerURL = createURL(URL, tickerCaps);
        driver.get(tickerURL);
        if (!tickerURL.equals(driver.getCurrentUrl())) {
          return builder.build();
        }
        Document pageDocument = Jsoup.parse(driver.getPageSource());
        Elements dataElements = pageDocument.select(TITLES_SELECTOR);
        if (CollectionUtils.isNotEmpty(dataElements)) {
          builder = populateBuilderWithMainInfo(dataElements);
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

  @Override
  public void shutdown() {
    // Shutdown the executor service
    executor.shutdown();
  }
  @Override
  protected CompanyCashFlow.Builder populateBuilderWithMainInfo(Elements dataElements) {
    CompanyCashFlow.Builder builder = new CompanyCashFlow.Builder();
    Map<CashFlowTitles, String> cashFlowTitlesMapTTM = fillMap(dataElements, 1);
    Map<CashFlowTitles, String> cashFlowTitlesMapLastUpdate = fillMap(dataElements, 2);

    builder.withOperatingCashFlowTTM(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.OPERATING_CASH_FLOW))
            .withInvestingCashFlowTTM(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.INVESTING_CASH_FLOW))
            .withFinancingCashFlowTTM(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.FINANCING_CASH_FLOW))
            .withEndCashPositionTTM(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.END_CASH_POSITION))
            .withCapitalExpenditureTTM(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.CAPITAL_EXPENDITURE))
            .withFreeCashFlowTTM(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.FREE_CASH_FLOW))
            .withOperatingCashFlowLastUpdate(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.OPERATING_CASH_FLOW))
            .withInvestingCashFlowLastUpdate(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.INVESTING_CASH_FLOW))
            .withFinancingCashFlowLastUpdate(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.FINANCING_CASH_FLOW))
            .withEndCashPositionLastUpdate(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.END_CASH_POSITION))
            .withCapitalExpenditureLastUpdate(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.CAPITAL_EXPENDITURE))
            .withFreeCashFlowLastUpdate(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.FREE_CASH_FLOW));

    return builder;
  }

  @Override
  protected EnumMap<CashFlowTitles, String> fillMap(Elements dataElements, int valueOffset) {
    EnumMap<CashFlowTitles, String> map = new EnumMap<>(CashFlowTitles.class);

    for (int currentPosition = 0; currentPosition < dataElements.size(); currentPosition++) {
      Element currentElement = dataElements.get(currentPosition);
      CashFlowTitles title = CashFlowTitles.fromTitle(currentElement.text());

      if (title != null && currentPosition + valueOffset < dataElements.size()) {
        Element nextElement = dataElements.get(currentPosition + valueOffset);
        map.put(title, nextElement.text());
      }
    }

    return map;
  }

  @Override
  protected String getTitleValue(Map<CashFlowTitles, String> cashFlowMap, CashFlowTitles title) {
    if (cashFlowMap.containsKey(title)) {
      return cashFlowMap.get(title);
    }
    return DEFAULT;
  }

}
