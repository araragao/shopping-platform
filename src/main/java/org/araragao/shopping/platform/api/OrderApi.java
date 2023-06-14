package org.araragao.shopping.platform.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.araragao.shopping.platform.api.dto.OrderDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDiscountedBestDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDiscountedDto;
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
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Order price",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = OrderPriceDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404",
            description = "Product not found",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  OrderPriceDto getOrderPrice(OrderDto orderDto);

  @PostMapping("/price/discounted")
  @RequestBody
  @Operation(
      summary = "Get the discounted order price based on a specific PolicyDiscount",
      description = "Get the discounted order price based on a specific `PolicyDiscount`.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Discounted order price",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = OrderPriceDiscountedDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404",
            description = "Object not found",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  OrderPriceDto getDiscountedOrderPrice(OrderPriceDiscountedDto orderPriceDiscountedDto);

  @PostMapping("/price/discounted/best")
  @RequestBody
  @Operation(
      summary = "Get the best order price based on active related PolicyDiscount",
      description = "Get the best order price based on active related `PolicyDiscount`.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Discounted order price",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = OrderPriceDiscountedDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404",
            description = "Object not found",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  OrderPriceDto getBestDiscountedOrderPrice(
      OrderPriceDiscountedBestDto orderPriceDiscountedBestDto);
}
