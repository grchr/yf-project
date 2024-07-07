package org.opensource.enums;

public enum BalanceSheetTitles {
  TOTAL_ASSETS("Total Assets"),
  TOTAL_LIABILITIES_NET_MINORITY_INTEREST("Total Liabilities Net Minority Interest"),
  TOTAL_EQUITY_GROSS_MINORITY_INTEREST("Total Equity Gross Minority Interest"),
  TOTAL_CAPITALIZATION("Total Capitalization"),
  COMMON_STOCK_EQUITY("Common Stock Equity"),
  NET_TANGIBLE_ASSETS("Net Tangible Assets"),
  INVESTED_CAPITAL("Invested Capital"),
  TANGIBLE_BOOK_VALUE("Tangible Book Value"),
  TOTAL_DEBT("Total Debt"),
  NET_DEBT("Net Debt"),
  SHARE_ISSUED("Share Issued"),
  ORDINARY_SHARES_NUMBER("Ordinary Shares Number");

  private final String description;

  BalanceSheetTitles(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}

