package org.araragao.shopping.platform.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

  @Mock ProductService productService;
  @Mock DiscountPolicyService discountPolicyService;
  @InjectMocks OrderService orderService;

  @Test
  void testGetOrderPrice() {
    assertEquals(BigDecimal.TEN, orderService.getOrderPrice(BigInteger.TEN, BigDecimal.ONE));
  }
}
