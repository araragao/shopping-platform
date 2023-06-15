package org.araragao.shopping.platform.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.araragao.shopping.platform.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceIntegrationTest {

  @Autowired
  private OrderService orderService;
  @Autowired
  private ProductService productService;

  @Test
  public void testGetBestDiscountedOrderPrice() {
    Product savedProduct = productService.getProductById("648b4168ca84014e814b3f7b");

    BigDecimal bestDiscountedOrderPrice =
        orderService.getBestDiscountedOrderPrice(BigInteger.valueOf(100), savedProduct);

    assertEquals("7641.500", bestDiscountedOrderPrice.toPlainString());
  }
}
