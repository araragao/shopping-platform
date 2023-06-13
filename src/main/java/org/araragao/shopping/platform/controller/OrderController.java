package org.araragao.shopping.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.api.OrderApi;
import org.araragao.shopping.platform.api.dto.OrderDiscountedBestDto;
import org.araragao.shopping.platform.api.dto.OrderDiscountedDto;
import org.araragao.shopping.platform.api.dto.OrderDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDto;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.Product;
import org.araragao.shopping.platform.service.DiscountPolicyService;
import org.araragao.shopping.platform.service.OrderService;
import org.araragao.shopping.platform.service.OrderValidationService;
import org.araragao.shopping.platform.service.ProductService;
import org.springframework.web.bind.annotation.RequestBody;
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
  public OrderPriceDto getOrderPrice(@RequestBody OrderDto orderDto) {
    log.info("getOrderPrice with orderDto: {}", orderDto);

    Product product = productService.getProductById(orderDto.productId());
    orderValidationService.validate(orderDto.amount(), product);

    return new OrderPriceDto(orderService.getOrderPrice(orderDto.amount(), product.getPrice()));
  }

  @Override
  public OrderPriceDto getDiscountedOrderPrice(@RequestBody OrderDiscountedDto orderDiscountedDto) {
    log.info("getDiscountedOrderPrice with orderDiscountedDto: {}", orderDiscountedDto);

    Product product = productService.getProductById(orderDiscountedDto.productId());
    orderValidationService.validate(orderDiscountedDto.amount(), product);

    DiscountPolicy discountPolicy =
        discountPolicyService.getDiscountPolicyById(orderDiscountedDto.discountPolicyId());

    return new OrderPriceDto(
        orderService.getDiscountedOrderPrice(orderDiscountedDto.amount(), product, discountPolicy));
  }

  @Override
  public OrderPriceDto getBestDiscountedOrderPrice(
      @RequestBody OrderDiscountedBestDto orderDiscountedBestDto) {
    log.info("getBestDiscountedOrderPrice with orderDiscountedBestDto: {}", orderDiscountedBestDto);

    Product product = productService.getProductById(orderDiscountedBestDto.productId());
    orderValidationService.validate(orderDiscountedBestDto.amount(), product);

    return new OrderPriceDto(
        orderService.getBestDiscountedOrderPrice(orderDiscountedBestDto.amount(), product));
  }
}
