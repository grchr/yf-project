package org.opensource.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensource.model.CompanyIncomeStatement;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    String ticker = "AAPL";
    CompanyIncomeStatement companyIncomeStatement = service.execute(ticker);

    assertNotNull(companyIncomeStatement);
    assertNoFieldsContainDoubleDash(companyIncomeStatement);
  }

  @Test
  void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = "AAPL";
    CompanyIncomeStatement companyIncomeStatement = service.executeAsync(ticker).get();

    assertNotNull(companyIncomeStatement);
    assertNoFieldsContainDoubleDash(companyIncomeStatement);
  }

  private void assertNoFieldsContainDoubleDash(CompanyIncomeStatement companyIncomeStatement) {

    assertNotEquals("--", companyIncomeStatement.getTotalRevenueTTM());
    assertNotEquals("--", companyIncomeStatement.getTotalRevenueLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getPretaxIncomeTTM());
    assertNotEquals("--", companyIncomeStatement.getPretaxIncomeLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getTaxProvisionTTM());
    assertNotEquals("--", companyIncomeStatement.getTaxProvisionLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getNetIncomeCommonStockholdersTTM());
    assertNotEquals("--", companyIncomeStatement.getNetIncomeCommonStockholdersLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getBasicEPSTTM());
    assertNotEquals("--", companyIncomeStatement.getBasicEPSLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getDilutedEPSTTM());
    assertNotEquals("--", companyIncomeStatement.getDilutedEPSLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getBasicAvgSharesTTM());
    assertNotEquals("--", companyIncomeStatement.getBasicAvgSharesLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getDilutedAvgSharesTTM());
    assertNotEquals("--", companyIncomeStatement.getDilutedAvgSharesLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getNetIncomeContinuingDiscontinuedOpsTTM());
    assertNotEquals("--", companyIncomeStatement.getNetIncomeContinuingDiscontinuedOpsLastUpdate());
    assertNotEquals("--", companyIncomeStatement.getNormalizedIncomeTTM());
    assertNotEquals("--", companyIncomeStatement.getNormalizedIncomeLastUpdate());

  }
}
