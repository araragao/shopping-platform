package org.araragao.shopping.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.api.OrderApi;
import org.araragao.shopping.platform.api.dto.OrderDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDiscountedBestDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDiscountedDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDto;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.Product;
import org.araragao.shopping.platform.service.DiscountPolicyService;
import org.araragao.shopping.platform.service.OrderService;
import org.araragao.shopping.platform.service.OrderValidationService;
import org.araragao.shopping.platform.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

  private final OrderService orderService;
  private final OrderValidationService orderValidationService;
  private final ProductService productService;
  private final DiscountPolicyService discountPolicyService;

  @Override
  public OrderPriceDto getOrderPrice(OrderDto orderDto) {
    log.info("getOrderPrice with orderDto: {}", orderDto);

    Product product = productService.getProductById(orderDto.productId());
    orderValidationService.validate(orderDto.amount(), product);

    return new OrderPriceDto(orderService.getOrderPrice(orderDto.amount(), product.getPrice()));
  }

  @Override
  public OrderPriceDto getDiscountedOrderPrice(OrderPriceDiscountedDto orderPriceDiscountedDto) {
    log.info("getDiscountedOrderPrice with orderDiscountedDto: {}", orderPriceDiscountedDto);

    Product product = productService.getProductById(orderPriceDiscountedDto.productId());
    orderValidationService.validate(orderPriceDiscountedDto.amount(), product);

    DiscountPolicy discountPolicy =
        discountPolicyService.getDiscountPolicyById(orderPriceDiscountedDto.discountPolicyId());

    return new OrderPriceDto(
        orderService.getDiscountedOrderPrice(
            orderPriceDiscountedDto.amount(), product, discountPolicy));
  }

  @Override
  public OrderPriceDto getBestDiscountedOrderPrice(
      OrderPriceDiscountedBestDto orderPriceDiscountedBestDto) {
    log.info(
        "getBestDiscountedOrderPrice with orderDiscountedBestDto: {}", orderPriceDiscountedBestDto);

    Product product = productService.getProductById(orderPriceDiscountedBestDto.productId());
    orderValidationService.validate(orderPriceDiscountedBestDto.amount(), product);

    return new OrderPriceDto(
        orderService.getBestDiscountedOrderPrice(orderPriceDiscountedBestDto.amount(), product));
  }
}
