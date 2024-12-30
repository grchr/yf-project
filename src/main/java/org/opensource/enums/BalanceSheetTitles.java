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
  WORKING_CAPITAL("Working Capital"),
  ORDINARY_SHARES_NUMBER("Ordinary Shares Number");

  private final String title;

  BalanceSheetTitles(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public static BalanceSheetTitles fromTitle(String title) {
    String sanitizedTitle = title.trim().replaceFirst("\\s\\d+$", "");
    for (BalanceSheetTitles balanceSheetTitle : values()) {
      if (balanceSheetTitle.getTitle().equalsIgnoreCase(sanitizedTitle)) {
        return balanceSheetTitle;
      }
    }
    return null;
  }
}

