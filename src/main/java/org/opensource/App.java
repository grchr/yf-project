package org.opensource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.model.CompanyIncomeStatement;
import org.opensource.model.CompanyKeyStatistics;
import org.opensource.service.GetIncomeStatementService;
import org.opensource.service.GetKeyStatisticsService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws ExecutionException, InterruptedException {

      seleniumTest();

      System.out.println(wrongTickerTest());
    }

  private static boolean wrongTickerTest() {
    HtmlUnitDriver driver = new HtmlUnitDriver();

    // Navigate to the financials page of BNP Paribas on Yahoo Finance
    driver.get("https://finance.yahoo.com/quote/xx/key-statistics/");
    if (driver.getCurrentUrl().contains("lookup")) return true;
    Document doc = Jsoup.parse(driver.getPageSource());

    Elements title = doc.select("tr");

    return false;
  }

  private static void seleniumTest() throws ExecutionException, InterruptedException {
    System.out.println("------------------KEY STATISTICS----------------------");
    HtmlUnitDriver driver = new HtmlUnitDriver();
    // Navigate to the financials page of BNP Paribas on Yahoo Finance
    driver.get("https://finance.yahoo.com/quote/BNP.PA/key-statistics/");

    Document doc = Jsoup.parse(driver.getPageSource());
    Element container = doc.selectFirst("div.container.svelte-mgkamr");

    GetKeyStatisticsService getKeyStatisticsService = new GetKeyStatisticsService();

    CompanyKeyStatistics companyKeyStatistics = getKeyStatisticsService.execute("BNP.PA");
    System.out.println(companyKeyStatistics);
    CompletableFuture<CompanyKeyStatistics> companyKeyStatisticsCompletableFuture = getKeyStatisticsService.executeAsync("BNP.PA");

//    CompanyKeyStatistics companyKeyStatistics1 = companyKeyStatisticsCompletableFuture.get();
//    getKeyStatisticsService.shutdown();
//
//    boolean equals = companyKeyStatistics.equals(companyKeyStatistics1);
//    System.out.println("Equality achieved: " + equals);

//    CompletableFuture<CompanyKeyStatistics> futureStats = getKeyStatisticsService.executeAsync("AAPL");
//
//    // Handle the completion of the async task
//    futureStats.thenAccept(stats -> {
//      System.out.println("Received key statistics: " + stats);
//      getKeyStatisticsService.shutdown(); // Shutdown executor when done
//    }).exceptionally(ex -> {
//      System.err.println("Error fetching key statistics: " + ex.getMessage());
//      getKeyStatisticsService.shutdown(); // Shutdown executor on error
//      return null;
//    });

    // Select all span elements within the specific container
    if (container != null) {
      Elements spans = container.select("span");

      // Iterate through the spans and print their text content
      for (Element span : spans) {
        System.out.println(span.text());
      }
    }

    Elements trElements = doc.select("tr");

    for (Element trElement : trElements) {
      System.out.println(trElement.text());
    }

    Elements tdElements = doc.select("td");

    for (Element tdElement : tdElements) {
      System.out.println(tdElement.text());
    }

    System.out.println("------------------FINANCIALS----------------------");

    driver.get("https://finance.yahoo.com/quote/BNP.PA/financials/");

    GetIncomeStatementService getFinancialsService = new GetIncomeStatementService();

//    CompanyIncomeStatement companyFinancials = getFinancialsService.execute("BNP.PA");
//    System.out.println(companyFinancials);
    CompanyIncomeStatement companyFinancials2 = getFinancialsService.execute("APPL");
    System.out.println(companyFinancials2);

//    String pageSourceFinancials = driver.getPageSource();
//
//    Document docFinancials = Jsoup.parse(pageSourceFinancials);
//
//    Element containerFinancials = docFinancials.selectFirst("div.container.svelte-mgkamr");
//
//    // Select all span elements within the specific container
//    if (containerFinancials != null) {
//      Elements spans = containerFinancials.select("span");
//
//      // Iterate through the spans and print their text content
//      for (Element span : spans) {
//        System.out.println(span.text());
//      }
//    }
//
//    Elements divFinancials = docFinancials.select("div.column.svelte-1xjz32c, div.column.svelte-1xjz32c.alt");
//
//    for (Element div : divFinancials) {
//      System.out.println(div.text());
//    }

    System.out.println("++++++++++++++++++BALANCE SHEET+++++++++++++++++++");

    driver.get("https://finance.yahoo.com/quote/BNP.PA/balance-sheet/");

    String pageSourceBalanceSheet = driver.getPageSource();

    Document docBalanceSheet = Jsoup.parse(pageSourceBalanceSheet);

    Elements divBalanceSheet = docBalanceSheet.select("div.column.svelte-1xjz32c, div.column.svelte-1xjz32c.alt");

    for (Element div : divBalanceSheet) {
      System.out.println(div.text());
    }

    System.out.println("===================CASH FLOWS===================");

    driver.get("https://finance.yahoo.com/quote/BNP.PA/cash-flow/");

    String pageSourceCashFlow = driver.getPageSource();

    Document docCashFlow = Jsoup.parse(pageSourceCashFlow);

    Elements divCashFlow = docCashFlow.select("div.column.svelte-1xjz32c, div.column.svelte-1xjz32c.alt");

    for (Element div : divCashFlow) {
      System.out.println(div.text());
    }

    // Close the browser
    driver.quit();
  }
}
