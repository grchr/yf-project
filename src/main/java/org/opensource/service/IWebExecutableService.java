package org.opensource.service;

import org.apache.commons.collections.CollectionUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.opensource.model.AbstractCompanyInformation;

import java.util.concurrent.CompletableFuture;

public interface IWebExecutableService<T extends AbstractCompanyInformation> {

  static final String COMPANY_NAME_SELECTOR = "h1";
  static final int COMPANY_NAME_POSITION = 1;
  static final String CURRENT_PRICE_FIRST_SELECTOR = "div.container.svelte-mgkamr";
  static final String CURRENT_PRICE_SECOND_SELECTOR = "span";
  static final int CURRENT_PRICE_POSITION = 0;
  String DEFAULT = "--";

  T execute(String ticker);

  CompletableFuture<T> executeAsync(String ticker);

  void shutdown();

  default String getValueFromElements(Elements elements, int position) {
    if (elements.size() > position) {
      return elements.get(position).text();
    }
    return "--";
  }

  default String getCurrentPrice(Document pageDocument) {
    Element container = pageDocument.selectFirst(CURRENT_PRICE_FIRST_SELECTOR);
    // Select all span elements within the specific container
    if (container != null) {
      Elements spans = container.select(CURRENT_PRICE_SECOND_SELECTOR);
      if (CollectionUtils.isNotEmpty(spans)) {
        return getValueFromElements(spans, CURRENT_PRICE_POSITION);
      }
    }
    return "--";
  }

  default String getCompanyName(Document pageDocument) {
    Elements headTitles = pageDocument.select(COMPANY_NAME_SELECTOR);
    if (CollectionUtils.isNotEmpty(headTitles)) {
      return getValueFromElements(headTitles, COMPANY_NAME_POSITION);
    }
    return "--";
  }
}
