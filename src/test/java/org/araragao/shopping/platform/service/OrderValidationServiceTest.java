package org.araragao.shopping.platform.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.araragao.shopping.platform.DataUtils;
import org.araragao.shopping.platform.exception.custom.OrderValidationException;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.Product;
import org.junit.jupiter.api.Test;

class OrderValidationServiceTest {

  OrderValidationService orderValidationService = new OrderValidationService();

  @Test
  void testValidateRelationship() {
    Product product = DataUtils.getProduct(BigDecimal.ONE, BigInteger.ONE);
    DiscountPolicy discountPolicy =
        DataUtils.getActiveCountDiscountPolicyWithProductId(
            product.getId(), BigDecimal.ONE, BigInteger.TEN);

    assertDoesNotThrow(() -> orderValidationService.validateRelationship(product, discountPolicy));
  }

  @Test
  void testValidateRelationshipThrowsException() {
    Product product = DataUtils.getProduct(BigDecimal.ONE, BigInteger.ONE);
    DiscountPolicy discountPolicy =
        DataUtils.getActiveCountDiscountPolicy(BigDecimal.ONE, BigInteger.TEN);

    assertThrows(
        OrderValidationException.class,
        () -> orderValidationService.validateRelationship(product, discountPolicy));
  }

  @Test
  void testValidateAvailability() {
    BigInteger amount = BigInteger.ONE;
    Product product = DataUtils.getProduct(BigDecimal.ONE, BigInteger.ONE);

    assertDoesNotThrow(() -> orderValidationService.validateAvailability(amount, product));
  }

  @Test
  void testValidateAvailabilityProductOutOfStockThrowsException() {
    BigInteger amount = BigInteger.ONE;
    Product product = DataUtils.getProduct(BigDecimal.ONE, BigInteger.ZERO);

    assertThrows(
        OrderValidationException.class,
        () -> orderValidationService.validateAvailability(amount, product));
  }

  @Test
  void testValidateAvailabilityOrderAmountHigherThanProductStockThrowsException() {
    BigInteger amount = BigInteger.TEN;
    Product product = DataUtils.getProduct(BigDecimal.ONE, BigInteger.ONE);

    assertThrows(
        OrderValidationException.class,
        () -> orderValidationService.validateAvailability(amount, product));
  }
}
