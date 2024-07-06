package org.opensource.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.opensource.enums.KeyStatisticsPositions;
import org.opensource.model.CompanyKeyStatistics;

public class GetKeyStatisticsService {

  private static final String URL = "https://finance.yahoo.com/quote/%s/key-statistics/";

  public CompanyKeyStatistics execute(String ticker) {
    HtmlUnitDriver driver = new HtmlUnitDriver();
    driver.get(createURL(ticker));

    Document pageDocument = Jsoup.parse(driver.getPageSource());

    Element container = pageDocument.selectFirst("div.container.svelte-mgkamr");
    CompanyKeyStatistics.Builder builder = new CompanyKeyStatistics.Builder();

    // Select all span elements within the specific container
    if (container != null) {
      Elements spans = container.select("span");

      // Get current price
      for (Element span : spans) {
        System.out.println(span.text());
      }
      builder.withCurrentPrice(getValueFromElements(spans, 0));
    }

//    Elements trElements = pageDocument.select("tr");
//    //Get Current Date (split by
//    for (Element trElement : trElements) {
//      System.out.println(trElement.text());
//    }

    Elements tdElements = pageDocument.select("td");
    // Get actual data: /Market Cap/EnterpriseValue/Forward PE/Trailing PE/PEG Ratio/PS ratio/PB Ratio/PS ratio/ EV to Revenue/ EV to EBITDA/ProfitMargin/Operating Margin/Return on Assets/Return on Equity/Revenue/Rev per share/Quart Rev growth/Gross profit/EBITDA/
//    for (Element tdElement : tdElements) {
//      System.out.println(tdElement.text());
//    }

    //tdElements.get()

    builder.withCompanyTicker(ticker)
            .withMarketCap(getValueFromElements(tdElements, KeyStatisticsPositions.MARKET_CAP.getValue()))
            .withEnterpriseValue(getValueFromElements(tdElements, KeyStatisticsPositions.ENTERPRISE_VALUE.getValue()))
            .withTrailingPE(getValueFromElements(tdElements, KeyStatisticsPositions.TRAILING_PE.getValue()))
            .withForwardPE(getValueFromElements(tdElements, KeyStatisticsPositions.FORWARD_PE.getValue()))
            .withPegRatio(getValueFromElements(tdElements, KeyStatisticsPositions.PEG_RATIO.getValue()))
            .withRatioPS(getValueFromElements(tdElements, KeyStatisticsPositions.PS_RATIO.getValue()))
            .withRatioPB(getValueFromElements(tdElements, KeyStatisticsPositions.PB_RATIO.getValue()))
            .withEvToRevenue(getValueFromElements(tdElements, KeyStatisticsPositions.EV_TO_REVENUE.getValue()))
            .withEvToEBITDA(getValueFromElements(tdElements, KeyStatisticsPositions.EV_TO_EBITDA.getValue()))
            .withProfitMargin(getValueFromElements(tdElements, KeyStatisticsPositions.PROFIT_MARGIN.getValue()))
            .withOperatingMargin(getValueFromElements(tdElements, KeyStatisticsPositions.OPERATING_MARGIN.getValue()))
            .withReturnOnAssets(getValueFromElements(tdElements, KeyStatisticsPositions.RETURN_ON_ASSETS.getValue()))
            .withReturnOnEquity(getValueFromElements(tdElements, KeyStatisticsPositions.RETURN_ON_EQUITY.getValue()))
            .withRevenue(getValueFromElements(tdElements, KeyStatisticsPositions.REVENUE.getValue()));


    driver.quit();
    return builder.build();
  }

  private String createURL(String ticker) {
    return String.format(URL, ticker);
  }

  private String getValueFromElements(Elements elements, int position) {
    if (elements.size() >= position) {
      return elements.get(position).text();
    }
    return "--";
  }
}
