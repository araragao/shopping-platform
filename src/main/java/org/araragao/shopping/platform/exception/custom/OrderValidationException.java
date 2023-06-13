package org.araragao.shopping.platform.exception.custom;

public class OrderValidationException extends RuntimeException {

  public OrderValidationException(String msg) {
    super(msg);
  }

  public OrderValidationException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
