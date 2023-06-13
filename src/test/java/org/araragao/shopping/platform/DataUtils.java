package org.araragao.shopping.platform;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.RandomStringUtils;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.DiscountType;
import org.araragao.shopping.platform.model.Product;
import org.bson.types.ObjectId;

public class DataUtils {

  public static String getRandomMongoId() {
    return new ObjectId().toString();
  }

  public static DiscountPolicy getMockCountDiscountPolicy(BigDecimal value, BigInteger threshold) {
    return DiscountPolicy.builder()
        .id(getRandomMongoId())
        .type(DiscountType.COUNT)
        .value(value)
        .threshold(threshold)
        .build();
  }

  public static DiscountPolicy getMockPercentageDiscountPolicy(BigDecimal value) {
    return DiscountPolicy.builder()
        .id(getRandomMongoId())
        .type(DiscountType.PERCENTAGE)
        .value(value)
        .build();
  }

  public static Product getMockProduct(BigDecimal price, BigInteger stock) {
    return Product.builder()
        .id(getRandomMongoId())
        .name(RandomStringUtils.random(10))
        .price(price)
        .stock(stock)
        .build();
  }
}
