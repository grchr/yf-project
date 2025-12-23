package org.opensource.service;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.opensource.model.financials.YahooFinancials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinancialsServiceTest {

  @Test
  void financialsServiceTest() {
    FinancialsService financialsService = new FinancialsService();
    YahooFinancials result = financialsService.execute("BNP.PA");
    assertEquals(1, result.getQuoteSummary().getResult().size());
    assertTrue(CollectionUtils.isNotEmpty(result.getQuoteSummary().getResult().get(0).getIncomeStatementHistory().getIncomeStatementHistory()));
    assertTrue(CollectionUtils.isNotEmpty(result.getQuoteSummary().getResult().get(0).getCashflowStatementHistory().getCashflowStatements()));
    assertTrue(CollectionUtils.isNotEmpty(result.getQuoteSummary().getResult().get(0).getCashflowStatementHistoryQuarterly().getCashflowStatements()));
    assertTrue(CollectionUtils.isNotEmpty(result.getQuoteSummary().getResult().get(0).getBalanceSheetHistory().getBalanceSheetStatements()));
    assertTrue(CollectionUtils.isNotEmpty(result.getQuoteSummary().getResult().get(0).getBalanceSheetHistoryQuarterly().getBalanceSheetStatements()));
    System.out.println(result);
  }
}
