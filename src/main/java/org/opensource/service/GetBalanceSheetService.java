package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.BalanceSheetTitles;
import org.opensource.model.CompanyBalanceSheet;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import static org.opensource.service.helpers.ReaderHelpers.createURL;
import static org.opensource.service.helpers.ReaderHelpers.getCompanyName;
import static org.opensource.service.helpers.ReaderHelpers.getCurrentPrice;
import static org.opensource.service.helpers.ReaderHelpers.getDoubleFromString;

public class GetBalanceSheetService extends AbstractWebDataService<BalanceSheetTitles> implements IWebExecutableService<CompanyBalanceSheet> {

  private static final String URL = "https://finance.yahoo.com/quote/%s/balance-sheet/";

  public GetBalanceSheetService() {
    super();
  }

  @Override
  public CompanyBalanceSheet execute(String ticker) {
    CompanyBalanceSheet.Builder builder = new CompanyBalanceSheet.Builder();
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
  public CompletableFuture<CompanyBalanceSheet> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), executor);
  }

  @Override
  public CompletableFuture<CompanyBalanceSheet> executeAsync(String ticker, ExecutorService customExecutor) {
    return CompletableFuture.supplyAsync(() ->  execute(ticker), customExecutor);
  }

  @Override
  protected CompanyBalanceSheet.Builder populateBuilderWithMainInfo(Elements dataElements) {
    CompanyBalanceSheet.Builder builder = new CompanyBalanceSheet.Builder();
    Map<BalanceSheetTitles, String> balanceSheetTitlesMap = fillMap(dataElements, 1);

    builder.withTotalAssets(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_ASSETS)))
            .withTotalLiabilitiesNetMinorityInterest(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_LIABILITIES_NET_MINORITY_INTEREST)))
            .withTotalEquityGrossMinorityInterest(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_EQUITY_GROSS_MINORITY_INTEREST)))
            .withTotalCapitalization(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_CAPITALIZATION)))
            .withCommonStockEquity(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.COMMON_STOCK_EQUITY)))
            .withNetTangibleAssets(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.NET_TANGIBLE_ASSETS)))
            .withInvestedCapital(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.INVESTED_CAPITAL)))
            .withTangibleBookValue(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TANGIBLE_BOOK_VALUE)))
            .withTotalDebt(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_DEBT)))
            .withNetDebt(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.NET_DEBT)))
            .withSharesIssued(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.SHARE_ISSUED)))
            .withWorkingCapital(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.WORKING_CAPITAL)))
            .withOrdinarySharesNumber(getDoubleFromString(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.ORDINARY_SHARES_NUMBER)));

    return builder;
  }

  @Override
  protected EnumMap<BalanceSheetTitles, String> fillMap(Elements dataElements, int valueOffset) {
    EnumMap<BalanceSheetTitles, String> map = new EnumMap<>(BalanceSheetTitles.class);

    for (int currentPosition = 0; currentPosition < dataElements.size(); currentPosition++) {
      Element currentElement = dataElements.get(currentPosition);
      BalanceSheetTitles title = BalanceSheetTitles.fromTitle(currentElement.text());

      if (title != null && currentPosition + valueOffset < dataElements.size()) {
        Element nextElement = dataElements.get(currentPosition + valueOffset);
        map.put(title, nextElement.text());
      }
    }

    return map;
  }
}
