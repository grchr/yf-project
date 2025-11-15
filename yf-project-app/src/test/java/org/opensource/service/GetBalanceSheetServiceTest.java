package org.opensource.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensource.model.CompanyBalanceSheet;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.opensource.service.TestUtils.getRandomStockToTest;

public class GetBalanceSheetServiceTest {

  private static GetBalanceSheetService service;

  @BeforeEach
  void setUp() {
    service = new GetBalanceSheetService();
  }

  @AfterEach
  void tearDown() {
    service.shutdown();
  }

  @Test
  void testExecute() {
    String ticker = getRandomStockToTest();
    CompanyBalanceSheet companyBalanceSheet = service.execute(ticker);

    assertNotNull(companyBalanceSheet);
    System.out.println(companyBalanceSheet);
    assertNoFieldsContainNan(companyBalanceSheet);
  }

  @Test
  void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = getRandomStockToTest();
    CompanyBalanceSheet companyBalanceSheet = service.executeAsync(ticker).get();

    assertNotNull(companyBalanceSheet);
    System.out.println(companyBalanceSheet);
    assertNoFieldsContainNan(companyBalanceSheet);
  }

  private void assertNoFieldsContainNan(CompanyBalanceSheet companyBalanceSheet) {
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalAssets());
    assertNotEquals("--", companyBalanceSheet.getCurrency());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalLiabilitiesNetMinorityInterest());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalEquityGrossMinorityInterest());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalCapitalization());
    assertNotEquals(Double.NaN, companyBalanceSheet.getCommonStockEquity());
    assertNotEquals(Double.NaN, companyBalanceSheet.getNetTangibleAssets());
    assertNotEquals(Double.NaN, companyBalanceSheet.getInvestedCapital());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTangibleBookValue());
    assertNotEquals(Double.NaN, companyBalanceSheet.getTotalDebt());
    assertNotEquals(Double.NaN, companyBalanceSheet.getSharesIssued());
    assertNotEquals(Double.NaN, companyBalanceSheet.getOrdinarySharesNumber());

  }
}
