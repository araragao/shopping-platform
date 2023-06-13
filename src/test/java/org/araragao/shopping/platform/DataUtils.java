package org.araragao.shopping.platform;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.RandomStringUtils;
import org.araragao.shopping.platform.model.Product;

public class DataUtils {

  public static Product getMockProduct(BigDecimal price, BigInteger stock) {
    return Product.builder()
        // todo: change id to a valid mongo id
        .id("1234556788")
        .name(RandomStringUtils.random(10))
        .price(price)
        .stock(stock)
        .build();
  }

  public static Product getMockProduct(String price, String stock) {
    return Product.builder()
        // todo: change id to a valid mongo id
        .id("1234556788")
        .name(RandomStringUtils.random(10))
        .price(new BigDecimal(price))
        .stock(new BigInteger(stock))
        .build();
  }
}
