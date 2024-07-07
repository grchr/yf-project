package org.opensource.service;

import org.jsoup.select.Elements;
import org.opensource.enums.IncomeStatementTitles;

import java.util.EnumMap;

public interface IWebTitleIterableService<T extends Enum<T>> {

  EnumMap<T, String> fillMap(Elements dataElements, int valueOffset);
}
