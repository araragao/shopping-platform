package org.araragao.shopping.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.api.OrderApi;
import org.araragao.shopping.platform.api.dto.OrderDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDto;
import org.araragao.shopping.platform.service.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

  private final OrderService orderService;

  @Override
  public OrderPriceDto getMinOrderPrice(@RequestBody OrderDto orderDto) {
    log.info("getLowestOrderPrice with orderDto: {}", orderDto);
    return new OrderPriceDto(
        orderService.getBestDiscountedOrderPrice(orderDto.amount(), orderDto.productId()));
  }
}
