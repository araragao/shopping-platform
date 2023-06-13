package org.araragao.shopping.platform.exception.custom;

import org.springframework.dao.DataAccessException;

public class DiscountPolicyNotFoundException extends DataAccessException {

  public DiscountPolicyNotFoundException(String msg) {
    super(msg);
  }

  public DiscountPolicyNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
