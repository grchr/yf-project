package org.opensource.exceptions;

public class YahooSessionException extends Exception{
  public YahooSessionException(String message) {
    super(message);
  }

  public YahooSessionException(String message, Throwable cause) {
    super(message, cause);
  }
}
