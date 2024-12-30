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
  WEEK_52_CHANGE("52 Week Change"),
  WEEK_52_HIGH("52 Week High"),
  WEEK_52_LOW("52 Week Low"),
  DAY_50_MOVING_AVG("50-Day Moving Average"),
  DAY_200_MOVING_AVG("200-Day Moving Average"),
  AVG_3_MONTH_VOL("Avg Vol (3 month)"),
  AVG_10_DAY_VOL("Avg Vol (10 day)"),
  SHARES_OUTSTANDING("Shares Outstanding"),
  IMPLIED_SHARES_OUTSTANDING("Implied Shares Outstanding"),
  FLOAT("Float"),
  HELD_BY_INSIDERS("% Held by Insiders"),
  HELD_BY_INSTITUTIONS("% Held by Institutions"),
  SHARES_SHORT("SHARES_SHORT"),
  SHARES_SHORT_RATIO("SHARES_SHORT_RATIO"),
  SHORT_PERC_FLOAT("SHORT_PERC_FLOAT"),
  SHORT_PERC_OF_SHARES_OUTSTANDING("SHORT_PERC_OF_SHARES_OUTSTANDING"),
  SHARES_SHORT_PRIOR_MONTH("SHARES_SHORT_PRIOR_MONTH"),
  DIVIDEND_RATE_FWD_ANNUAL("Forward Annual Dividend Rate"),
  DIVIDEND_YIELD_FWD_ANNUAL("Forward Annual Dividend Yield"),
  DIVIDEND_RATE_TRAILING_ANNUAL("Trailing Annual Dividend Rate"),
  DIVIDEND_YIELD_TRAILING_ANNUAL("Trailing Annual Dividend Yield"),
  DIVIDEND_YIELD_5_YEAR_AVG("5 Year Average Dividend Yield"),
  PAYOUT_RATIO("Payout Ratio"),
  DIVIDEND_DATE("Dividend Date"),
  DIVIDEND_EX_DATE("Ex-Dividend Date"),
  LAST_SPLIT_FACTOR("Last Split Factor"),
  LAST_SPLIT_DATE("Last Split Date");


  private final String title;

  KeyStatisticsTitles(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public static KeyStatisticsTitles fromTitle(String title) {
    String sanitizedTitle = title.trim().replaceFirst("\\s\\d+$", "");
    for (KeyStatisticsTitles enumTitles : values()) {
      if (enumTitles.getTitle().equalsIgnoreCase(sanitizedTitle)) {
        return enumTitles;
      }
    }
    return null;
  }
}
