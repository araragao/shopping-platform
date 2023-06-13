package org.araragao.shopping.platform.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
  private String id;
  private String name;
  private BigDecimal price;
  private BigInteger stock;
}
