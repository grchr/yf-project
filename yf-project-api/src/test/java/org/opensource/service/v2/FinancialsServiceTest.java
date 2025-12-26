package org.opensource.service.v2;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.model.response.financials.YahooFinancials;
import org.opensource.service.v2.FinancialsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinancialsServiceTest {

  @BeforeEach
  void setup() throws InterruptedException {
    // Wait before each test to avoid rate limiting
    Thread.sleep(1000);
  }

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
