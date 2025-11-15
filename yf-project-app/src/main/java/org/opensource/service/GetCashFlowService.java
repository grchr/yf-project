package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.CashFlowTitles;
import org.opensource.model.CompanyCashFlow;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import static org.opensource.service.helpers.ReaderHelpers.createURL;
import static org.opensource.service.helpers.ReaderHelpers.getDoubleFromString;

public class GetCashFlowService extends AbstractWebDataService<CashFlowTitles> implements IWebExecutableService<CompanyCashFlow>{

  private static final String URL = "https://finance.yahoo.com/quote/%s/cash-flow/";

  public GetCashFlowService() {
    super();
  }

  @Override
  public CompanyCashFlow execute(String ticker) {
    CompanyCashFlow.Builder builder = new CompanyCashFlow.Builder();
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
  public CompletableFuture<CompanyCashFlow> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), executor);
  }

  @Override
  public CompletableFuture<CompanyCashFlow> executeAsync(String ticker, ExecutorService customExecutor) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), customExecutor);
  }

  @Override
  protected CompanyCashFlow.Builder populateBuilderWithMainInfo(Elements dataElements) {
    CompanyCashFlow.Builder builder = new CompanyCashFlow.Builder();
    Map<CashFlowTitles, String> cashFlowTitlesMapTTM = fillMap(dataElements, 1);
    Map<CashFlowTitles, String> cashFlowTitlesMapLastUpdate = fillMap(dataElements, 2);

    builder.withOperatingCashFlowTTM(getDoubleFromString(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.OPERATING_CASH_FLOW)))
            .withInvestingCashFlowTTM(getDoubleFromString(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.INVESTING_CASH_FLOW)))
            .withFinancingCashFlowTTM(getDoubleFromString(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.FINANCING_CASH_FLOW)))
            .withEndCashPositionTTM(getDoubleFromString(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.END_CASH_POSITION)))
            .withCapitalExpenditureTTM(getDoubleFromString(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.CAPITAL_EXPENDITURE)))
            .withFreeCashFlowTTM(getDoubleFromString(getTitleValue(cashFlowTitlesMapTTM, CashFlowTitles.FREE_CASH_FLOW)))
            .withOperatingCashFlowLastUpdate(getDoubleFromString(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.OPERATING_CASH_FLOW)))
            .withInvestingCashFlowLastUpdate(getDoubleFromString(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.INVESTING_CASH_FLOW)))
            .withFinancingCashFlowLastUpdate(getDoubleFromString(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.FINANCING_CASH_FLOW)))
            .withEndCashPositionLastUpdate(getDoubleFromString(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.END_CASH_POSITION)))
            .withCapitalExpenditureLastUpdate(getDoubleFromString(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.CAPITAL_EXPENDITURE)))
            .withFreeCashFlowLastUpdate(getDoubleFromString(getTitleValue(cashFlowTitlesMapLastUpdate, CashFlowTitles.FREE_CASH_FLOW)));

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

}
