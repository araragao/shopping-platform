package org.araragao.shopping.platform.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.araragao.shopping.platform.api.dto.OrderDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Orders", description = "Operations related to order process")
@RequestMapping("/api/orders")
public interface OrderApi {

  @PostMapping("/best-price")
  @RequestBody
  @Operation(
      summary = "Get the best Order price based on active PolicyDiscount",
      description = "Get the best `Order` price based on active `PolicyDiscount`.")
  OrderPriceDto getMinOrderPrice(OrderDto orderDto);
}
