package org.opensource;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.model.CompanyKeyStatistics;
import org.opensource.service.GetKeyStatisticsService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

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

  private static void seleniumTest() {
    System.out.println("------------------KEY STATISTICS----------------------");
    HtmlUnitDriver driver = new HtmlUnitDriver();
    // Navigate to the financials page of BNP Paribas on Yahoo Finance
    driver.get("https://finance.yahoo.com/quote/BNP.PA/key-statistics/");

    Document doc = Jsoup.parse(driver.getPageSource());
    Element container = doc.selectFirst("div.container.svelte-mgkamr");

    GetKeyStatisticsService getKeyStatisticsService = new GetKeyStatisticsService();

    CompanyKeyStatistics companyKeyStatistics = getKeyStatisticsService.execute("BNP.PA");

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

    String pageSourceFinancials = driver.getPageSource();

    Document docFinancials = Jsoup.parse(pageSourceFinancials);

    Element containerFinancials = docFinancials.selectFirst("div.container.svelte-mgkamr");

    // Select all span elements within the specific container
    if (containerFinancials != null) {
      Elements spans = containerFinancials.select("span");

      // Iterate through the spans and print their text content
      for (Element span : spans) {
        System.out.println(span.text());
      }
    }

    Elements divFinancials = docFinancials.select("div.column.svelte-1xjz32c, div.column.svelte-1xjz32c.alt");

    for (Element div : divFinancials) {
      System.out.println(div.text());
    }

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
