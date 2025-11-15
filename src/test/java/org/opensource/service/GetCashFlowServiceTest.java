package org.opensource.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.model.CompanyCashFlow;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.opensource.service.TestUtils.getRandomStockToTest;

public class GetCashFlowServiceTest {

  private static GetCashFlowService service;

  @BeforeEach
  void setUp() {
    service = new GetCashFlowService();
  }

  @AfterEach
  void tearDown() {
    service.shutdown();
  }

  @Test
  void testExecute() {
    String ticker = getRandomStockToTest();
    CompanyCashFlow companyCashFlow = service.execute(ticker);

    assertNotNull(companyCashFlow);
    System.out.println(companyCashFlow);
    assertNoFieldsContainDoubleDash(companyCashFlow);
  }

  @Test
  void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = getRandomStockToTest();
    CompanyCashFlow companyCashFlow = service.executeAsync(ticker).get();

    assertNotNull(companyCashFlow);
    System.out.println(companyCashFlow);
    assertNoFieldsContainDoubleDash(companyCashFlow);
  }

  private void assertNoFieldsContainDoubleDash(CompanyCashFlow companyCashFlow) {
    assertNotEquals(Double.NaN, companyCashFlow.getOperatingCashFlowTTM());
    assertNotEquals("--", companyCashFlow.getCurrency());
    assertNotEquals(Double.NaN, companyCashFlow.getInvestingCashFlowTTM());
    assertNotEquals(Double.NaN, companyCashFlow.getFinancingCashFlowTTM());
    assertNotEquals(Double.NaN, companyCashFlow.getEndCashPositionTTM());
    assertNotEquals(Double.NaN, companyCashFlow.getCapitalExpenditureTTM());
    assertNotEquals(Double.NaN, companyCashFlow.getFreeCashFlowTTM());
    assertNotEquals(Double.NaN, companyCashFlow.getOperatingCashFlowLastUpdate());
    assertNotEquals(Double.NaN, companyCashFlow.getInvestingCashFlowLastUpdate());
    assertNotEquals(Double.NaN, companyCashFlow.getFinancingCashFlowLastUpdate());
    assertNotEquals(Double.NaN, companyCashFlow.getEndCashPositionLastUpdate());
    assertNotEquals(Double.NaN, companyCashFlow.getCapitalExpenditureLastUpdate());
    assertNotEquals(Double.NaN, companyCashFlow.getFreeCashFlowLastUpdate());
  }
}
