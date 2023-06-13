package org.araragao.shopping.platform.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.araragao.shopping.platform.api.dto.OrderDiscountedBestDto;
import org.araragao.shopping.platform.api.dto.OrderDiscountedDto;
import org.araragao.shopping.platform.api.dto.OrderDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Orders", description = "Operations related to order processing")
@RequestMapping("/api/orders")
public interface OrderApi {

  @PostMapping("/price")
  @RequestBody
  @Operation(
      summary = "Get the (standard) order price",
      description = "Get the (standard) order price.")
  OrderPriceDto getOrderPrice(OrderDto orderDto);

  @PostMapping("/price/discounted")
  @RequestBody
  @Operation(
      summary = "Get the discounted order price based on a specific PolicyDiscount",
      description = "Get the discounted order price based on a specific `PolicyDiscount`.")
  OrderPriceDto getDiscountedOrderPrice(OrderDiscountedDto orderDiscountedDto);

  @PostMapping("/price/discounted/best")
  @RequestBody
  @Operation(
      summary = "Get the best order price based on active related PolicyDiscount",
      description = "Get the best order price based on active related `PolicyDiscount`.")
  OrderPriceDto getBestDiscountedOrderPrice(OrderDiscountedBestDto orderDiscountedBestDto);
}
