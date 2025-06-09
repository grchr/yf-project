package org.opensource.service.helpers;

import org.apache.commons.collections4.CollectionUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReaderHelpers {

  public static final String COMPANY_NAME_SELECTOR = "h1";
  public static final int COMPANY_NAME_POSITION = 1;
  public static final String CURRENT_PRICE_FIRST_SELECTOR = "div.container.yf-mgkamr";

  public static final String CURRENT_PRICE_DATA_SELECTOR = "fin-streamer.livePrice[data-symbol=%s]";
  public static final String CURRENT_PRICE_BACKUP_SELECTOR = "span[data-testid=qsp-price]";
  public static final String CURRENT_PRICE_SECOND_SELECTOR = "span";
  public static final int CURRENT_PRICE_POSITION = 0;
  public static String DEFAULT = "--";

  private ReaderHelpers() {
    // keep constructor private
  }

  public static String getValueFromElements(Elements elements, int position) {
    if (elements.size() > position) {
      return elements.get(position).text();
    }
    return DEFAULT;
  }

  public static double getDoubleFromString(String value) {
    try {
      return Double.parseDouble(value.replace(",", "").replace("%", ""));
    } catch (NumberFormatException e) {
      return Double.NaN;
    }
  }

  public static String getCurrentPrice(Document pageDocument) {
    Element container = pageDocument.selectFirst(CURRENT_PRICE_FIRST_SELECTOR);
    // Select all span elements within the specific container
    if (container != null) {
      Elements spans = container.select(CURRENT_PRICE_SECOND_SELECTOR);
      if (CollectionUtils.isNotEmpty(spans)) {
        return getValueFromElements(spans, CURRENT_PRICE_POSITION);
      }
    }
    return DEFAULT;
  }

  public static String getCurrentPrice(Document pageDocument, String ticker) {
    Element livePriceElement = pageDocument.select(String.format(CURRENT_PRICE_DATA_SELECTOR, ticker)).first();
    if (livePriceElement != null) {
      Element spanElement = livePriceElement.getElementsByAttribute("data-value").get(0);
      if (spanElement != null) {
        return spanElement.text();
      }
    }
    livePriceElement = pageDocument.select(CURRENT_PRICE_BACKUP_SELECTOR).first();
    if (livePriceElement != null) {
      return livePriceElement.text();
    }
    return DEFAULT;
  }

  public static String getCompanyName(Document pageDocument) {
    Elements headTitles = pageDocument.select(COMPANY_NAME_SELECTOR);
    if (CollectionUtils.isNotEmpty(headTitles)) {
      return getValueFromElements(headTitles, COMPANY_NAME_POSITION);
    }
    return DEFAULT;
  }

  public static String createURL(String URL, String ticker) {
    return String.format(URL, ticker);
  }
}
