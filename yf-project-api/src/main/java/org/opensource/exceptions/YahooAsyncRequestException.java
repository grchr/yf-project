package org.opensource.exceptions;

public class YahooAsyncRequestException extends RuntimeException {

  public YahooAsyncRequestException(String message) {
    super(message);
  }

  public YahooAsyncRequestException(String message, Throwable cause) {
    super(message, cause);
  }
}
