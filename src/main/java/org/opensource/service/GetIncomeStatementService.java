package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.IncomeStatementTitles;
import org.opensource.model.CompanyIncomeStatement;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.opensource.service.ReaderHelpers.createURL;
import static org.opensource.service.ReaderHelpers.getCompanyName;
import static org.opensource.service.ReaderHelpers.getCurrentPrice;

public class GetIncomeStatementService extends AbstractWebTitleIterableService<IncomeStatementTitles> implements IWebExecutableService<CompanyIncomeStatement> {

  private static final String URL = "https://finance.yahoo.com/quote/%s/financials/";
  private final ExecutorService executor = Executors.newCachedThreadPool();

  @Override
  public CompanyIncomeStatement execute(String ticker) {
    CompanyIncomeStatement.Builder builder = new CompanyIncomeStatement.Builder();
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
  protected CompanyIncomeStatement.Builder populateBuilderWithMainInfo(Elements dataElements) {
    CompanyIncomeStatement.Builder builder = new CompanyIncomeStatement.Builder();
    Map<IncomeStatementTitles, String> incomeStatementTTMMap = fillMap(dataElements, 1);
    Map<IncomeStatementTitles, String> incomeStatementLastUpdateMap = fillMap(dataElements, 2);

    builder.withTotalRevenueTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.TOTAL_REVENUE))
            .withTotalRevenueLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.TOTAL_REVENUE))
            .withPretaxIncomeTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.PRETAX_INCOME))
            .withPretaxIncomeLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.PRETAX_INCOME))
            .withTaxProvisionTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.TAX_PROVISION))
            .withTaxProvisionLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.TAX_PROVISION))
            .withNetIncomeCommonStockholdersTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.NET_INCOME_COMMON_STOCKHOLDERS))
            .withNetIncomeCommonStockholdersLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.NET_INCOME_COMMON_STOCKHOLDERS))
            .withBasicEPSTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.BASIC_EPS))
            .withBasicEPSLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.BASIC_EPS))
            .withDilutedEPSTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.DILUTED_EPS))
            .withDilutedEPSLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.DILUTED_EPS))
            .withBasicAvgSharesTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.BASIC_AVERAGE_SHARES))
            .withBasicAvgSharesLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.BASIC_AVERAGE_SHARES))
            .withDilutedAvgSharesTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.DILUTED_AVERAGE_SHARES))
            .withDilutedAvgSharesLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.DILUTED_AVERAGE_SHARES))
            .withNetIncomeContinuingDiscontinuedOpsTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.NET_INCOME_FROM_CONTINUING_DISCONTINUED_OPERATION))
            .withNetIncomeContinuingDiscontinuedOpsLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.NET_INCOME_FROM_CONTINUING_DISCONTINUED_OPERATION))
            .withNormalizedIncomeTTM(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.NORMALIZED_INCOME))
            .withNormalizedIncomeLastUpdate(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.NORMALIZED_INCOME));

    return builder;
  }

  @Override
  public EnumMap<IncomeStatementTitles, String> fillMap(Elements dataElements, int valueOffset) {
    EnumMap<IncomeStatementTitles, String> map = new EnumMap<>(IncomeStatementTitles.class);

    for (int currentPosition = 0; currentPosition < dataElements.size(); currentPosition++) {
      Element currentElement = dataElements.get(currentPosition);
      IncomeStatementTitles title = IncomeStatementTitles.fromTitle(currentElement.text());

      if (title != null && currentPosition + valueOffset < dataElements.size()) {
        Element nextElement = dataElements.get(currentPosition + valueOffset);
        map.put(title, nextElement.text());
      }
    }

    return map;
  }

  @Override
  protected String getTitleValue(Map<IncomeStatementTitles, String> incomeStatementMap, IncomeStatementTitles title) {
    if (incomeStatementMap.containsKey(title)) {
      return incomeStatementMap.get(title);
    }
    return DEFAULT;
  }

  @Override
  public CompletableFuture<CompanyIncomeStatement> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() -> {
      CompanyIncomeStatement.Builder builder = new CompanyIncomeStatement.Builder();
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

}
