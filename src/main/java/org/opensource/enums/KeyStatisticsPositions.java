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
  REVENUE(76);



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
