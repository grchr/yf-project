package org.opensource.enums;

public enum KeyStatisticsTitles {

  MARKET_CAP("Market Cap"),
  ENTERPRISE_VALUE("Enterprise Value"),
  TRAILING_PE("Trailing P/E"),
  FORWARD_PE("Forward P/E"),
  PEG_RATIO("PEG Ratio (5yr expected)"),
  PS_RATIO("Price/Sales"),
  PB_RATIO("Price/Book"),
  EV_TO_REVENUE("Enterprise Value/Revenue"),
  EV_TO_EBITDA("Enterprise Value/EBITDA"),
  PROFIT_MARGIN("Profit Margin"),
  OPERATING_MARGIN("Operating Margin (ttm)"),
  RETURN_ON_ASSETS("Return on Assets (ttm)"),
  RETURN_ON_EQUITY("Return on Equity (ttm)"),
  REVENUE("Revenue (ttm)"),
  REVENUE_PER_SHARE("Revenue Per Share (ttm)"),
  QUARTERLY_REV_GROWTH("Quarterly Revenue Growth (yoy)"),
  GROSS_PROFIT("Gross Profit (ttm)"),
  EBITDA("EBITDA"),
  NET_INC_AVI_TO_COMMON("Net Income Avi to Common (ttm)"),
  DILUTED_EPS("Diluted EPS (ttm)"),
  QUARTERLY_EARNINGS_GROWTH("Quarterly Earnings Growth (yoy)"),
  TOTAL_CASH("Total Cash (mrq)"),
  TOTAL_CASH_PER_SHARE("Total Cash Per Share (mrq)"),
  TOTAL_DEBT("Total Debt (mrq)"),
  TOTAL_DEBT_TO_EQUITY("Total Debt/Equity (mrq)"),
  CURRENT_RATIO("Current Ratio (mrq)"),
  BOOK_VALUE_PER_SHARE("Book Value Per Share (mrq)"),
  OPERATING_CASH_FLOW("Operating Cash Flow (ttm)"),
  LEVERED_FREE_CASH_FLOW("Levered Free Cash Flow (ttm)"),
  BETA("Beta (5Y Monthly)"),
  WEEK_52_RANGE("52 Week Range"),
  WEEK_52_CHANGE("WEEK_52_CHANGE"),
  WEEK_52_HIGH("WEEK_52_HIGH"),
  WEEK_52_LOW("WEEK_52_LOW"),
  DAY_50_MOVING_AVG("DAY_50_MOVING_AVG"),
  DAY_200_MOVING_AVG("DAY_200_MOVING_AVG"),
  AVG_3_MONTH_VOL("AVG_3_MONTH_VOL"),
  AVG_10_DAY_VOL("AVG_10_DAY_VOL"),
  SHARES_OUTSTANDING("SHARES_OUTSTANDING"),
  IMPLIED_SHARES_OUTSTANDING("IMPLIED_SHARES_OUTSTANDING"),
  FLOAT("FLOAT"),
  HELD_BY_INSIDERS("HELD_BY_INSIDERS"),
  HELD_BY_INSTITUTIONS("HELD_BY_INSTITUTIONS"),
  SHARES_SHORT("SHARES_SHORT"),
  SHARES_SHORT_RATIO("SHARES_SHORT_RATIO"),
  SHORT_PERC_FLOAT("SHORT_PERC_FLOAT"),
  SHORT_PERC_OF_SHARES_OUTSTANDING("SHORT_PERC_OF_SHARES_OUTSTANDING"),
  SHARES_SHORT_PRIOR_MONTH("SHARES_SHORT_PRIOR_MONTH"),
  DIVIDEND_RATE_FWD_ANNUAL("DIVIDEND_RATE_FWD_ANNUAL"),
  DIVIDEND_YIELD_FWD_ANNUAL("DIVIDEND_YIELD_FWD_ANNUAL"),
  DIVIDEND_RATE_TRAILING_ANNUAL("DIVIDEND_RATE_TRAILING_ANNUAL"),
  DIVIDEND_YIELD_TRAILING_ANNUAL("DIVIDEND_YIELD_TRAILING_ANNUAL"),
  DIVIDEND_YIELD_5_YEAR_AVG("DIVIDEND_YIELD_5_YEAR_AVG"),
  PAYOUT_RATIO("PAYOUT_RATIO"),
  DIVIDEND_RATE("DIVIDEND_RATE"),
  DIVIDEND_EX_DATE("DIVIDEND_EX_DATE"),
  LAST_SPLIT_FACTOR("LAST_SPLIT_FACTOR"),
  LAST_SPLIT_DATE("LAST_SPLIT_DATE");


  private final String title;

  KeyStatisticsTitles(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public static KeyStatisticsTitles fromTitle(String title) {
    for (KeyStatisticsTitles titles : values()) {
      if (titles.getTitle().equalsIgnoreCase(title)) {
        return titles;
      }
    }
    return null;
  }
}
