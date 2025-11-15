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

import static org.opensource.service.helpers.ReaderHelpers.createURL;
import static org.opensource.service.helpers.ReaderHelpers.getDoubleFromString;

public class GetIncomeStatementService extends AbstractWebDataService<IncomeStatementTitles> implements IWebExecutableService<CompanyIncomeStatement> {

  private static final String URL = "https://finance.yahoo.com/quote/%s/financials/";
  private final ExecutorService executor = Executors.newCachedThreadPool();

  @Override
  public CompanyIncomeStatement execute(String ticker) {
    CompanyIncomeStatement.Builder builder = new CompanyIncomeStatement.Builder();
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
      Elements dataElements = pageDocument.select(TITLES_SELECTOR);
      if (CollectionUtils.isNotEmpty(dataElements)) {
        builder = populateBuilderWithMainInfo(dataElements);
      }

      builder = populateCommonFields(builder, pageDocument, tickerCaps);

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
  public CompletableFuture<CompanyIncomeStatement> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), executor);
  }

  @Override
  public CompletableFuture<CompanyIncomeStatement> executeAsync(String ticker, ExecutorService customExecutor) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), customExecutor);
  }

  @Override
  protected CompanyIncomeStatement.Builder populateBuilderWithMainInfo(Elements dataElements) {
    CompanyIncomeStatement.Builder builder = new CompanyIncomeStatement.Builder();
    Map<IncomeStatementTitles, String> incomeStatementTTMMap = fillMap(dataElements, 1);
    Map<IncomeStatementTitles, String> incomeStatementLastUpdateMap = fillMap(dataElements, 2);

    builder.withTotalRevenueTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.TOTAL_REVENUE)))
            .withTotalRevenueLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.TOTAL_REVENUE)))
            .withPretaxIncomeTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.PRETAX_INCOME)))
            .withPretaxIncomeLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.PRETAX_INCOME)))
            .withTaxProvisionTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.TAX_PROVISION)))
            .withTaxProvisionLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.TAX_PROVISION)))
            .withNetIncomeCommonStockholdersTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.NET_INCOME_COMMON_STOCKHOLDERS)))
            .withNetIncomeCommonStockholdersLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.NET_INCOME_COMMON_STOCKHOLDERS)))
            .withBasicEPSTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.BASIC_EPS)))
            .withBasicEPSLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.BASIC_EPS)))
            .withDilutedEPSTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.DILUTED_EPS)))
            .withDilutedEPSLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.DILUTED_EPS)))
            .withBasicAvgSharesTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.BASIC_AVERAGE_SHARES)))
            .withBasicAvgSharesLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.BASIC_AVERAGE_SHARES)))
            .withDilutedAvgSharesTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.DILUTED_AVERAGE_SHARES)))
            .withDilutedAvgSharesLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.DILUTED_AVERAGE_SHARES)))
            .withNetIncomeContinuingDiscontinuedOpsTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.NET_INCOME_FROM_CONTINUING_DISCONTINUED_OPERATION)))
            .withNetIncomeContinuingDiscontinuedOpsLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.NET_INCOME_FROM_CONTINUING_DISCONTINUED_OPERATION)))
            .withNormalizedIncomeTTM(getDoubleFromString(getTitleValue(incomeStatementTTMMap, IncomeStatementTitles.NORMALIZED_INCOME)))
            .withNormalizedIncomeLastUpdate(getDoubleFromString(getTitleValue(incomeStatementLastUpdateMap, IncomeStatementTitles.NORMALIZED_INCOME)));

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

}
