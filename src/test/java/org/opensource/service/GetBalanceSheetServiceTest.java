package org.opensource.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensource.model.CompanyBalanceSheet;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.opensource.service.TestUtils.getRandomStockToTest;

public class GetBalanceSheetServiceTest {

  private static GetBalanceSheetService service;

  @BeforeAll
  static void setUp() {
    service = new GetBalanceSheetService();
  }

  @AfterAll
  static void tearDown() {
    service.shutdown();
  }

  @Test
  void testExecute() {
    String ticker = getRandomStockToTest();
    CompanyBalanceSheet companyBalanceSheet = service.execute(ticker);

    assertNotNull(companyBalanceSheet);
    assertNoFieldsContainNan(companyBalanceSheet);
  }

  @Test
  void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = getRandomStockToTest();
    CompanyBalanceSheet companyBalanceSheet = service.executeAsync(ticker).get();

    assertNotNull(companyBalanceSheet);
    assertNoFieldsContainNan(companyBalanceSheet);
  }

  private void assertNoFieldsContainNan(CompanyBalanceSheet companyBalanceSheet) {
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalAssets());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalLiabilitiesNetMinorityInterest());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalEquityGrossMinorityInterest());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalCapitalization());
    assertNotEquals(Double.NaN, companyBalanceSheet.getCommonStockEquity());
    assertNotEquals(Double.NaN, companyBalanceSheet.getNetTangibleAssets());
    assertNotEquals(Double.NaN, companyBalanceSheet.getInvestedCapital());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTangibleBookValue());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalDebt());
    assertNotEquals(Double.NaN, companyBalanceSheet.getNetDebt());
    assertNotEquals(Double.NaN, companyBalanceSheet.getSharesIssued());
    assertNotEquals(Double.NaN, companyBalanceSheet.getOrdinarySharesNumber());

  }
}
