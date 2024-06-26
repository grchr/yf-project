package org.opensource;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.IOException;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    private static final String YAHOO_FINANCE_URL = "https://finance.yahoo.com/quote/%s/key-statistics";

    public static void main( String[] args ) {
      //jsoupTest();

      seleniumTest();
    }

  private static void jsoupTest() {
    String symbol = "ASML";
    String url = String.format(YAHOO_FINANCE_URL, symbol);
    try {
      Connection.Response initialResponse = Jsoup.connect(url)
          .method(Connection.Method.GET)
          .execute();

      // Extract cookies from the initial response
      Map<String, String> cookies = initialResponse.cookies();

      // Add the necessary cookies to indicate acceptance
      cookies.put("cookie-consent", "accepted"); // Adjust the cookie name and value as needed

      // Second request with the cookies to bypass the prompt
      Document document = Jsoup.connect(url)
          .cookies(cookies)
          .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
          .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
          .header("Accept-Language", "en-US,en;q=0.9")
          .header("Connection", "keep-alive")
          .header("Upgrade-Insecure-Requests", "1")
          .header("DNT", "1")
          .get();

      // Output the document title
      System.out.println(document.body());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void seleniumTest() {
    HtmlUnitDriver driver = new HtmlUnitDriver();

    // Navigate to the financials page of BNP Paribas on Yahoo Finance
    driver.get("https://finance.yahoo.com/quote/BNP.PA/key-statistics/");

    //String pageSource = driver.getPageSource();

    Document doc = Jsoup.parse(driver.getPageSource());
    Elements title = doc.select("tr");
    System.out.println("Title: " + title.text());
    Element container = doc.selectFirst("div.container.svelte-mgkamr");

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
