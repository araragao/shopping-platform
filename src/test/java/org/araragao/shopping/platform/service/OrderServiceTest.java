package org.araragao.shopping.platform.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import org.araragao.shopping.platform.DataUtils;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

  @Mock DiscountPolicyService discountPolicyService;
  @InjectMocks OrderService orderService;

  @Test
  void testGetOrderPrice() {
    assertEquals(BigDecimal.TEN, orderService.getOrderPrice(BigInteger.TEN, BigDecimal.ONE));
  }

  @Test
  public void testGetDiscountedOrderPriceWithNoDiscount() {
    BigInteger amount = BigInteger.TEN;
    Product product = DataUtils.getProduct(BigDecimal.TEN, BigInteger.valueOf(1000));
    DiscountPolicy discountPolicy =
        DataUtils.getActiveCountDiscountPolicy(BigDecimal.valueOf(5), BigInteger.valueOf(15));

    BigDecimal discountedOrderPrice =
        orderService.getDiscountedOrderPrice(amount, product, discountPolicy);

    assertEquals(BigDecimal.valueOf(100), discountedOrderPrice);
  }

  @Test
  public void testGetDiscountedOrderPriceWithCountDiscount() {
    BigInteger amount = BigInteger.TEN;
    Product product = DataUtils.getProduct(BigDecimal.TEN, BigInteger.valueOf(1000));
    DiscountPolicy discountPolicy =
        DataUtils.getActiveCountDiscountPolicy(BigDecimal.ONE, BigInteger.ONE);

    BigDecimal discountedOrderPrice =
        orderService.getDiscountedOrderPrice(amount, product, discountPolicy);

    assertEquals(BigDecimal.valueOf(90), discountedOrderPrice);
  }

  @Test
  public void testGetDiscountedOrderPriceWithPercentageDiscount() {
    BigInteger amount = BigInteger.TEN;
    Product product = DataUtils.getProduct(BigDecimal.TEN, BigInteger.valueOf(1000));
    DiscountPolicy discountPolicy =
        DataUtils.getActivePercentageDiscountPolicy(BigDecimal.valueOf(0.2));

    BigDecimal discountedOrderPrice =
        orderService.getDiscountedOrderPrice(amount, product, discountPolicy);

    assertEquals(BigDecimal.valueOf(80.0), discountedOrderPrice);
  }

  @Test
  public void testGetBestDiscountedOrderPrice() {
    BigInteger amount = BigInteger.valueOf(100);
    Product product = DataUtils.getProduct(BigDecimal.valueOf(200), BigInteger.valueOf(100));
    List<DiscountPolicy> discountPolicies =
        Arrays.asList(
            DataUtils.getActiveCountDiscountPolicy(BigDecimal.valueOf(50), BigInteger.valueOf(100)),
            DataUtils.getActivePercentageDiscountPolicy(BigDecimal.valueOf(0.2)));

    when(discountPolicyService.getActiveDiscountPoliciesByProductId(product.getId()))
        .thenReturn(discountPolicies);

    BigDecimal bestDiscountedOrderPrice = orderService.getBestDiscountedOrderPrice(amount, product);

    assertEquals(BigDecimal.valueOf(10000), bestDiscountedOrderPrice);
  }

  @Test
  public void testGetBestDiscountedOrderPriceWithNoDiscountPolicies() {
    BigInteger amount = BigInteger.valueOf(100);
    Product product = DataUtils.getProduct(BigDecimal.valueOf(200), BigInteger.valueOf(100));
    List<DiscountPolicy> discountPolicies = List.of();

    when(discountPolicyService.getActiveDiscountPoliciesByProductId(product.getId()))
        .thenReturn(discountPolicies);

    BigDecimal bestDiscountedOrderPrice = orderService.getBestDiscountedOrderPrice(amount, product);

    assertEquals(BigDecimal.valueOf(20000), bestDiscountedOrderPrice);
  }
}
