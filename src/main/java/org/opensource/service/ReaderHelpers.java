package org.opensource.service;

import org.apache.commons.collections.CollectionUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReaderHelpers {

  static final String COMPANY_NAME_SELECTOR = "h1";
  static final int COMPANY_NAME_POSITION = 1;
  static final String CURRENT_PRICE_FIRST_SELECTOR = "div.container.svelte-mgkamr";
  static final String CURRENT_PRICE_SECOND_SELECTOR = "span";
  static final int CURRENT_PRICE_POSITION = 0;
  static String DEFAULT = "--";

  static String getValueFromElements(Elements elements, int position) {
    if (elements.size() > position) {
      return elements.get(position).text();
    }
    return DEFAULT;
  }

  static String getCurrentPrice(Document pageDocument) {
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

  static String getCompanyName(Document pageDocument) {
    Elements headTitles = pageDocument.select(COMPANY_NAME_SELECTOR);
    if (CollectionUtils.isNotEmpty(headTitles)) {
      return getValueFromElements(headTitles, COMPANY_NAME_POSITION);
    }
    return DEFAULT;
  }
}
