package org.araragao.shopping.platform.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscountPolicy {
  private String id;
  private String productId;
  private DiscountType type;
  private Boolean active;
  private BigInteger threshold;
  private BigDecimal value;
}
