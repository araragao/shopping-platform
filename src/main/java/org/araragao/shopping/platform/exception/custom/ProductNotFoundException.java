package org.araragao.shopping.platform.exception.custom;

import org.springframework.dao.DataAccessException;

public class ProductNotFoundException extends DataAccessException {

  public ProductNotFoundException(String msg) {
    super(msg);
  }

  public ProductNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
