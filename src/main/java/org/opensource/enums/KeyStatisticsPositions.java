package org.opensource.enums;

public enum KeyStatisticsPositions {

  //Store the positions of the Key Statistics values
  MARKET_CAP(1),
  ENTERPRISE_VALUE(8),
  TRAILING_PE(15),
  FORWARD_PE(22),
  PEG_RATIO(29),
  PS_RATIO(36),
  PB_RATIO(43),
  EV_TO_REVENUE(50),
  EV_TO_EBITDA(57),
  PROFIT_MARGIN(68),
  OPERATING_MARGIN(70),
  RETURN_ON_ASSETS(72),
  RETURN_ON_EQUITY(74),
  REVENUE(76),
  REVENUE_PER_SHARE(78),
  QUARTERLY_REV_GROWTH(80),
  GROSS_PROFIT(82),
  EBITDA(84),
  NET_INC_AVI_TO_COMMON(86),
  DILUTED_EPS(88),
  QUARTERLY_EARNINGS_GROWTH(90),
  TOTAL_CASH(92),
  TOTAL_CASH_PER_SHARE(94),
  TOTAL_DEBT(96),
  TOTAL_DEBT_TO_EQUITY(98),
  CURRENT_RATIO(100),
  BOOK_VALUE_PER_SHARE(102),
  OPERATING_CASH_FLOW(104),
  LEVERED_FREE_CASH_FLOW(106),
  BETA(108),
  WEEK_52_RANGE(110),
  WEEK_52_CHANGE(112),
  WEEK_52_HIGH(114),
  WEEK_52_LOW(116),
  DAY_50_MOVING_AVG(118),
  DAY_200_MOVING_AVG(120),
  AVG_3_MONTH_VOL(122),
  AVG_10_DAY_VOL(124),
  SHARES_OUTSTANDING(126),
  IMPLIED_SHARES_OUTSTANDING(128),
  FLOAT(130),
  HELD_BY_INSIDERS(132),
  HELD_BY_INSTITUTIONS(134),
  SHARES_SHORT(136),
  SHARES_SHORT_RATIO(138),
  SHORT_PERC_FLOAT(140),
  SHORT_PERC_OF_SHARES_OUTSTANDING(142),
  SHARES_SHORT_PRIOR_MONTH(144),
  DIVIDEND_RATE_FWD_ANNUAL(146),
  DIVIDEND_YIELD_FWD_ANNUAL(148),
  DIVIDEND_RATE_TRAILING_ANNUAL(150),
  DIVIDEND_YIELD_TRAILING_ANNUAL(152),
  DIVIDEND_YIELD_5_YEAR_AVG(154),
  PAYOUT_RATIO(156),
  DIVIDEND_RATE(158),
  DIVIDEND_EX_DATE(160),
  LAST_SPLIT_FACTOR(162),
  LAST_SPLIT_DATE(164);

  private final int value;

  // Constructor
  KeyStatisticsPositions(int value) {
    this.value = value;
  }

  // Getter for the value
  public int getValue() {
    return value;
  }

  // Method to get enum by name
  public static KeyStatisticsPositions getByName(String name) {
    for (KeyStatisticsPositions status : KeyStatisticsPositions.values()) {
      if (status.name().equalsIgnoreCase(name)) {
        return status;
      }
    }
    throw new IllegalArgumentException("No enum constant with name " + name);
  }

  // Method to get enum by value
  public static KeyStatisticsPositions getByValue(int value) {
    for (KeyStatisticsPositions status : KeyStatisticsPositions.values()) {
      if (status.getValue() == value) {
        return status;
      }
    }
    throw new IllegalArgumentException("No enum constant with value " + value);
  }
}
