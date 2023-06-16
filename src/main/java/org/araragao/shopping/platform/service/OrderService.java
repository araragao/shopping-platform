package org.araragao.shopping.platform.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.Product;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

  private final DiscountPolicyService discountPolicyService;

  /**
   * Calculates the order price based on the given amount and price.
   *
   * @param amount the amount of the product to be ordered (as a BigInteger)
   * @param price the price of the product (as a BigDecimal)
   * @return the calculated order price (as a BigDecimal)
   */
  public BigDecimal getOrderPrice(BigInteger amount, BigDecimal price) {
    return calculatePrice(amount, price);
  }

  /**
   * Calculates the discounted order price based on the given amount, product, and discount policy.
   *
   * @param amount the amount of the product to be ordered (as a BigInteger)
   * @param product the product for which the order is being placed
   * @param discountPolicy the discount policy to be applied
   * @return the calculated discounted order price (as a BigDecimal)
   */
  public BigDecimal getDiscountedOrderPrice(
      BigInteger amount, Product product, DiscountPolicy discountPolicy) {

    return switch (discountPolicy.getType()) {
      case COUNT -> calculateCountDiscountedOrderPrice(amount, product, discountPolicy);
      case PERCENTAGE -> calculatePercentageDiscountedOrderPrice(amount, product, discountPolicy);
    };
  }

  /**
   * Calculates the best discounted order price, i.e. lowest, for the given amount and product. The
   * best discounted price, in this case, refers to the lowest price achieved by applying active
   * discount policies to the product.
   *
   * @param amount the amount of the product to be ordered (as a BigInteger)
   * @param product the product for which the order is being placed
   * @return the best discounted order price (as a BigDecimal)
   */
  public BigDecimal getBestDiscountedOrderPrice(BigInteger amount, Product product) {
    log.info("getBestDiscountedOrderPrice for product: {} with amount: {}", product, amount);

    List<DiscountPolicy> discountPolicies =
        discountPolicyService.getActiveDiscountPoliciesByProductId(product.getId());

    log.info(
        "Found {} active discount policies for productId: {}",
        discountPolicies.size(),
        product.getId());

    return discountPolicies.parallelStream()
        .map(discountPolicy -> getDiscountedOrderPrice(amount, product, discountPolicy))
        .min(BigDecimal::compareTo)
        .orElse(getOrderPrice(amount, product.getPrice()));
  }

  private BigDecimal calculatePrice(BigInteger amount, BigDecimal price) {
    BigDecimal result = new BigDecimal(amount).multiply(price);
    return result.compareTo(BigDecimal.ZERO) < 0 ? BigDecimal.ZERO : result;
  }

  private BigDecimal calculateCountDiscountedOrderPrice(
      BigInteger amount, Product product, DiscountPolicy discountPolicy) {
    if (!isCountThresholdMet(amount, discountPolicy)) {
      return calculatePrice(amount, product.getPrice());
    }

    BigInteger discountedAmount = amount.subtract(discountPolicy.getValue().toBigInteger());

    return calculatePrice(discountedAmount, product.getPrice());
  }

  private BigDecimal calculatePercentageDiscountedOrderPrice(
      BigInteger amount, Product product, DiscountPolicy discountPolicy) {
    BigDecimal discountedPrice =
        product.getPrice().subtract(product.getPrice().multiply(discountPolicy.getValue()));

    return calculatePrice(amount, discountedPrice);
  }

  private boolean isCountThresholdMet(BigInteger amount, DiscountPolicy discountPolicy) {
    return amount.compareTo(discountPolicy.getThreshold()) >= 0;
  }
}
