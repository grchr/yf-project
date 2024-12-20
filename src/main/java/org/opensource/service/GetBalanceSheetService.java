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
import java.util.concurrent.Executors;

import static org.opensource.service.ReaderHelpers.createURL;
import static org.opensource.service.ReaderHelpers.getCompanyName;
import static org.opensource.service.ReaderHelpers.getCurrentPrice;
import static org.opensource.service.ReaderHelpers.getDoubleFromStringSimpleCase;

public class GetBalanceSheetService extends AbstractWebTitleIterableService<BalanceSheetTitles> implements IWebExecutableService<CompanyBalanceSheet> {

  private static final String URL = "https://finance.yahoo.com/quote/%s/balance-sheet/";
  private final ExecutorService executor = Executors.newCachedThreadPool();

  @Override
  public CompanyBalanceSheet execute(String ticker) {
    CompanyBalanceSheet.Builder builder = new CompanyBalanceSheet.Builder();
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
      builder.withCurrentPrice(getDoubleFromStringSimpleCase(getCurrentPrice(pageDocument, ticker)));
      builder.withCompanyTicker(tickerCaps);

    } finally {
      driver.quit();
    }
    return builder.build();
  }

  @Override
  public CompletableFuture<CompanyBalanceSheet> executeAsync(String ticker) {
    return CompletableFuture.supplyAsync(() -> {
      CompanyBalanceSheet.Builder builder = new CompanyBalanceSheet.Builder();
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

  @Override
  protected CompanyBalanceSheet.Builder populateBuilderWithMainInfo(Elements dataElements) {
    CompanyBalanceSheet.Builder builder = new CompanyBalanceSheet.Builder();
    Map<BalanceSheetTitles, String> balanceSheetTitlesMap = fillMap(dataElements, 1);

    builder.withTotalAssets(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_ASSETS)))
            .withTotalLiabilitiesNetMinorityInterest(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_LIABILITIES_NET_MINORITY_INTEREST)))
            .withTotalEquityGrossMinorityInterest(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_EQUITY_GROSS_MINORITY_INTEREST)))
            .withTotalCapitalization(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_CAPITALIZATION)))
            .withCommonStockEquity(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.COMMON_STOCK_EQUITY)))
            .withNetTangibleAssets(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.NET_TANGIBLE_ASSETS)))
            .withInvestedCapital(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.INVESTED_CAPITAL)))
            .withTangibleBookValue(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TANGIBLE_BOOK_VALUE)))
            .withTotalDebt(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.TOTAL_DEBT)))
            .withNetDebt(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.NET_DEBT)))
            .withSharesIssued(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.SHARE_ISSUED)))
            .withWorkingCapital(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.WORKING_CAPITAL)))
            .withOrdinarySharesNumber(getDoubleFromStringSimpleCase(getTitleValue(balanceSheetTitlesMap, BalanceSheetTitles.ORDINARY_SHARES_NUMBER)));

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
