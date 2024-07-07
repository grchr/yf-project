package org.opensource.exceptions;

public class TickerNotFoundException extends Exception{

  public TickerNotFoundException() {
    super("Ticker not found");
  }

  // Constructor that accepts a custom message
  public TickerNotFoundException(String message) {
    super(message);
  }
}
