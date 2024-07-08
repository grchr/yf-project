package org.opensource.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opensource.model.CompanyBalanceSheet;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    String ticker = "AAPL";
    CompanyBalanceSheet companyBalanceSheet = service.execute(ticker);

    assertNotNull(companyBalanceSheet);
    assertNoFieldsContainDoubleDash(companyBalanceSheet);
  }

  @Test
  void testExecuteAsync() throws ExecutionException, InterruptedException {
    String ticker = "AAPL";
    CompanyBalanceSheet companyBalanceSheet = service.executeAsync(ticker).get();

    assertNotNull(companyBalanceSheet);
    assertNoFieldsContainDoubleDash(companyBalanceSheet);
  }

  private void assertNoFieldsContainDoubleDash(CompanyBalanceSheet companyBalanceSheet) {
    assertNotEquals("--", companyBalanceSheet.getTotalAssets());
    assertNotEquals("--", companyBalanceSheet.getTotalLiabilitiesNetMinorityInterest());
    assertNotEquals("--", companyBalanceSheet.getTotalEquityGrossMinorityInterest());
    assertNotEquals("--", companyBalanceSheet.getTotalCapitalization());
    assertNotEquals("--", companyBalanceSheet.getCommonStockEquity());
    assertNotEquals("--", companyBalanceSheet.getNetTangibleAssets());
    assertNotEquals("--", companyBalanceSheet.getInvestedCapital());
    assertNotEquals("--", companyBalanceSheet.getTangibleBookValue());
    assertNotEquals("--", companyBalanceSheet.getTotalDebt());
    assertNotEquals("--", companyBalanceSheet.getNetDebt());
    assertNotEquals("--", companyBalanceSheet.getSharesIssued());
    assertNotEquals("--", companyBalanceSheet.getOrdinarySharesNumber());

  }
}
