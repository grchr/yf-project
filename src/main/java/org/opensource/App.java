package org.opensource;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

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

    String pageSource = driver.getPageSource();

    Document doc = Jsoup.parse(pageSource);

    Elements elements = doc.select("td.svelte-104jbnt");

    // Iterate over the selected elements and print their text content
    for (Element element : elements) {
      System.out.println(element.text());
    }


    // Close the browser
    driver.quit();
  }



//    WebDriverWait wait = new WebDriverWait(driver, 30);
//    wait.until((ExpectedCondition<Boolean>) wd ->
//        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
//
//    WebElement dynamicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicElementId")));
//
//    // Example: Waiting for all rows of a table to be present
//    List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".table.svelte-104jbnt tbody tr")));
//
//    // Now you can proceed with your actions after the page has fully loaded
//    System.out.println("Page and dynamic content have fully loaded");
//
//
//    WebElement table = driver.findElement(By.xpath("//table[contains(@class, 'table svelte-104jbnt')]"));
//
//    // Locate table header
//    WebElement thead = table.findElement(By.tagName("thead"));
//    List<WebElement> headers = thead.findElements(By.tagName("th"));
//
//    // Print table headers
//    for (WebElement header : headers) {
//      System.out.print(header.getText() + "\t");
//    }
//    System.out.println();
//
//    // Locate table body
//    WebElement tbody = table.findElement(By.tagName("tbody"));
//    //List<WebElement> rows = tbody.findElements(By.tagName("tr"));
//
//    // Iterate through each row
//    for (WebElement row : rows) {
//      List<WebElement> cells = row.findElements(By.tagName("td"));
//      for (WebElement cell : cells) {
//        System.out.print(cell.getText() + "\t");
//      }
//      System.out.println();
//    }
}
