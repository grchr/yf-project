package org.opensource.service;

import org.jsoup.select.Elements;
import org.opensource.model.AbstractCompanyInformation;

import java.util.EnumMap;
import java.util.Map;

public abstract class AbstractWebTitleIterableService<T extends Enum<T>> {

  protected static String DEFAULT = "--";
  protected static final String TITLES_SELECTOR = "div[class^=column sticky], div[class^=column]";

  protected abstract AbstractCompanyInformation.Builder populateBuilderWithMainInfo(Elements dataElements);

  protected abstract EnumMap<T, String> fillMap(Elements dataElements, int valueOffset);

  protected abstract String getTitleValue(Map<T, String> map, T title);
}
