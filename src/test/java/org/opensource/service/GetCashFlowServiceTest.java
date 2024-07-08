package org.opensource.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensource.model.CompanyCashFlow;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetCashFlowServiceTest {

  private static GetCashFlowService service;

  @BeforeAll
  static void setUp() {
    service = new GetCashFlowService();
  }

  @AfterAll
  static void tearDown() {
    service.shutdown();
  }

  @Test
  void testExecute() {
    String ticker = "AAPL";
    CompanyCashFlow companyCashFlow = service.execute(ticker);

    assertNotNull(companyCashFlow);
    assertNoFieldsContainDoubleDash(companyCashFlow);
  }

  @Test
  void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = "AAPL";
    CompanyCashFlow companyCashFlow = service.executeAsync(ticker).get();

    assertNotNull(companyCashFlow);
    assertNoFieldsContainDoubleDash(companyCashFlow);
  }

  private void assertNoFieldsContainDoubleDash(CompanyCashFlow companyCashFlow) {
    assertNotEquals("--", companyCashFlow.getOperatingCashFlowTTM());
    assertNotEquals("--", companyCashFlow.getInvestingCashFlowTTM());
    assertNotEquals("--", companyCashFlow.getFinancingCashFlowTTM());
    assertNotEquals("--", companyCashFlow.getEndCashPositionTTM());
    assertNotEquals("--", companyCashFlow.getCapitalExpenditureTTM());
    assertNotEquals("--", companyCashFlow.getFreeCashFlowTTM());
    assertNotEquals("--", companyCashFlow.getOperatingCashFlowLastUpdate());
    assertNotEquals("--", companyCashFlow.getInvestingCashFlowLastUpdate());
    assertNotEquals("--", companyCashFlow.getFinancingCashFlowLastUpdate());
    assertNotEquals("--", companyCashFlow.getEndCashPositionLastUpdate());
    assertNotEquals("--", companyCashFlow.getCapitalExpenditureLastUpdate());
    assertNotEquals("--", companyCashFlow.getFreeCashFlowLastUpdate());
  }
}
