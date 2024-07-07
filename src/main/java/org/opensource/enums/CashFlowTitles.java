package org.opensource.enums;

public enum CashFlowTitles {
  OPERATING_CASH_FLOW("Operating Cash Flow"),
  INVESTING_CASH_FLOW("Investing Cash Flow"),
  FINANCING_CASH_FLOW("Financing Cash Flow"),
  END_CASH_POSITION("End Cash Position"),
  CAPITAL_EXPENDITURE("Capital Expenditure"),
  FREE_CASH_FLOW("Free Cash Flow");

  private final String description;

  CashFlowTitles(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}

