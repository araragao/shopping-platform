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

  public static Product getProduct(BigDecimal price, BigInteger stock) {
    return Product.builder()
        .id(getRandomMongoId())
        .name(RandomStringUtils.random(10))
        .price(price)
        .stock(stock)
        .build();
  }

  public static DiscountPolicy getActiveCountDiscountPolicy(
      BigDecimal value, BigInteger threshold) {
    return DiscountPolicy.builder()
        .id(getRandomMongoId())
        .productId(getRandomMongoId())
        .type(DiscountType.COUNT)
        .value(value)
        .threshold(threshold)
        .active(true)
        .build();
  }

  public static DiscountPolicy getActiveCountDiscountPolicyWithProductId(
      String productId, BigDecimal value, BigInteger threshold) {
    return DiscountPolicy.builder()
        .id(getRandomMongoId())
        .productId(productId)
        .type(DiscountType.COUNT)
        .value(value)
        .threshold(threshold)
        .active(true)
        .build();
  }

  public static DiscountPolicy getActivePercentageDiscountPolicy(BigDecimal value) {
    return DiscountPolicy.builder()
        .id(getRandomMongoId())
        .productId(getRandomMongoId())
        .type(DiscountType.PERCENTAGE)
        .value(value)
        .active(true)
        .build();
  }

  public static DiscountPolicy getActivePercentageDiscountPolicyWithProductId(
      String productId, BigDecimal value) {
    return DiscountPolicy.builder()
        .id(getRandomMongoId())
        .productId(productId)
        .type(DiscountType.PERCENTAGE)
        .value(value)
        .active(true)
        .build();
  }
}
