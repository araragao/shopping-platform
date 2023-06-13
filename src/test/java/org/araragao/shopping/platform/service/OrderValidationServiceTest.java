package org.araragao.shopping.platform.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.araragao.shopping.platform.DataUtils;
import org.araragao.shopping.platform.exception.custom.OrderValidationException;
import org.araragao.shopping.platform.model.Product;
import org.junit.jupiter.api.Test;

class OrderValidationServiceTest {

  OrderValidationService orderValidationService = new OrderValidationService();

  @Test
  void testValidate_ProductOutOfStock_ThrowsException() {
    BigInteger amount = BigInteger.ONE;
    Product product = DataUtils.getMockProduct(BigDecimal.ONE, BigInteger.ZERO);

    assertThrows(
        OrderValidationException.class, () -> orderValidationService.validate(amount, product));
  }

  @Test
  void testValidate_OrderAmountHigherThanProductStock_ThrowsException() {
    BigInteger amount = BigInteger.TEN;
    Product product = DataUtils.getMockProduct(BigDecimal.ONE, BigInteger.ONE);

    assertThrows(
        OrderValidationException.class, () -> orderValidationService.validate(amount, product));
  }
}
