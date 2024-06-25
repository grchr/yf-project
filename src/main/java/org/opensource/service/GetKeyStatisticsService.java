package org.opensource.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.model.CompanyKeyStatistics;

public class GetKeyStatisticsService {

  private static final String URL = "https://finance.yahoo.com/quote/%s/key-statistics/";

  public CompanyKeyStatistics execute(String ticker) {
    HtmlUnitDriver driver = new HtmlUnitDriver();
    driver.get(createURL(ticker));

    Document pageDocument = Jsoup.parse(driver.getPageSource());




    driver.quit();
    return new CompanyKeyStatistics.Builder()
        .build();
  }

  public String createURL(String ticker) {
    return String.format(URL, ticker);
  }
}
