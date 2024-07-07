package org.opensource.enums;

public enum IncomeStatementTitles {
  TOTAL_REVENUE("Total Revenue"),
  PRETAX_INCOME("Pretax Income"),
  TAX_PROVISION("Tax Provision"),
  NET_INCOME_COMMON_STOCKHOLDERS("Net Income Common Stockholders"),
  BASIC_EPS("Basic EPS"),
  DILUTED_EPS("Diluted EPS"),
  BASIC_AVERAGE_SHARES("Basic Average Shares"),
  DILUTED_AVERAGE_SHARES("Diluted Average Shares"),
  NET_INCOME_FROM_CONTINUING_DISCONTINUED_OPERATION("Net Income from Continuing & Discontinued Operation"),
  NORMALIZED_INCOME("Normalized Income");

  private final String title;

  IncomeStatementTitles(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public static IncomeStatementTitles fromTitle(String title) {
    for (IncomeStatementTitles balanceSheetTitle : values()) {
      if (balanceSheetTitle.getTitle().equalsIgnoreCase(title)) {
        return balanceSheetTitle;
      }
    }
    return null;
  }
}

