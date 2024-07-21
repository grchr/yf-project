package org.opensource.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensource.model.CompanyIncomeStatement;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.opensource.service.TestUtils.getRandomStockToTest;

public class GetIncomeStatementServiceTest {
  private static GetIncomeStatementService service;

  @BeforeAll
  static void setUp() {
    service = new GetIncomeStatementService();
  }

  @AfterAll
  static void tearDown() {
    service.shutdown();
  }

  @Test
  void testExecute() {
    String ticker = getRandomStockToTest();
    CompanyIncomeStatement companyIncomeStatement = service.execute(ticker);

    assertNotNull(companyIncomeStatement);
    assertNoFieldsContainDoubleDash(companyIncomeStatement);
  }

  @Test
  void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = getRandomStockToTest();
    CompanyIncomeStatement companyIncomeStatement = service.executeAsync(ticker).get();

    assertNotNull(companyIncomeStatement);
    assertNoFieldsContainDoubleDash(companyIncomeStatement);
  }

  private void assertNoFieldsContainDoubleDash(CompanyIncomeStatement companyIncomeStatement) {

    assertNotEquals(Double.NaN, companyIncomeStatement.getTotalRevenueTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getTotalRevenueLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getPretaxIncomeTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getPretaxIncomeLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getTaxProvisionTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getTaxProvisionLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getNetIncomeCommonStockholdersTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getNetIncomeCommonStockholdersLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getBasicEPSTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getBasicEPSLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getDilutedEPSTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getDilutedEPSLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getBasicAvgSharesTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getBasicAvgSharesLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getDilutedAvgSharesTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getDilutedAvgSharesLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getNetIncomeContinuingDiscontinuedOpsTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getNetIncomeContinuingDiscontinuedOpsLastUpdate());
    assertNotEquals(Double.NaN, companyIncomeStatement.getNormalizedIncomeTTM());
    assertNotEquals(Double.NaN, companyIncomeStatement.getNormalizedIncomeLastUpdate());

  }
}
