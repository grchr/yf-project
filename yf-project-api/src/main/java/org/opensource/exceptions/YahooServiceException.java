package org.opensource.exceptions;

public class YahooServiceException extends Exception {
  public YahooServiceException(String message) {
    super(message);
  }

  public YahooServiceException(String message, Throwable cause) {
    super(message, cause);
  }
}
