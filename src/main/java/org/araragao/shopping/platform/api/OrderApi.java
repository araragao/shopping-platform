package org.araragao.shopping.platform.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.araragao.shopping.platform.api.dto.OrderDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDiscountedBestDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDiscountedDto;
import org.araragao.shopping.platform.api.dto.OrderPriceDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/api/orders")
@Tag(name = "Orders", description = "Operations related to order processing")
public interface OrderApi {

  @PostMapping("/price")
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
  OrderPriceDto getOrderPrice(@RequestBody @Valid OrderDto orderDto);

  @PostMapping("/price/discounted")
  @Operation(
      summary = "Get the discounted order price based on a specific DiscountPolicy",
      description = "Get the discounted order price based on a specific `DiscountPolicy`.")
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
  OrderPriceDto getDiscountedOrderPrice(
      @RequestBody @Valid OrderPriceDiscountedDto orderPriceDiscountedDto);

  @PostMapping("/price/discounted/best")
  @Operation(
      summary = "Get the best order price based on active related DiscountPolicy",
      description = "Get the best order price based on active related `DiscountPolicy`.")
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
      @RequestBody @Valid OrderPriceDiscountedBestDto orderPriceDiscountedBestDto);
}
