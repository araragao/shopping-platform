package org.araragao.shopping.platform.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.araragao.shopping.platform.api.dto.DiscountPolicyDto;
import org.araragao.shopping.platform.api.dto.list.ListDiscountPolicyDto;
import org.araragao.shopping.platform.api.dto.page.PageDiscountPolicyDto;
import org.araragao.shopping.platform.model.Page;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/api/discount-policies")
@Tag(name = "Discount Policies", description = "CRUD operations related to Discount Policies")
public interface DiscountPolicyApi {

  @GetMapping("/{id}")
  @Operation(summary = "Get a DiscountPolicy by ID", description = "Get a `DiscountPolicy` by ID.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "DiscountPolicy found",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = DiscountPolicyDto.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "DiscountPolicy not found",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  DiscountPolicyDto getDiscountPolicyById(@PathVariable String id);

  @GetMapping
  @Operation(
      summary = "Get a Page of DiscountPolicy given page, size and sort query parameters",
      description = "Get a `Page` of `DiscountPolicy` given page, size and sort query parameters.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Page of DiscountPolicy",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = PageDiscountPolicyDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  Page<DiscountPolicyDto> getDiscountPolicies(@PageableDefault @ParameterObject Pageable pageable);

  @GetMapping("/product/{productId}")
  @Operation(
      summary = "Get a DiscountPolicy by Product ID",
      description = "Get a `DiscountPolicy` by `Product` ID.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "List of DiscountPolicy",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ListDiscountPolicyDto.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "DiscountPolicy not found",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  List<DiscountPolicyDto> getDiscountPoliciesByProductId(@PathVariable String productId);

  @GetMapping("/product/{productId}/active")
  @Operation(
      summary = "Get a List of active DiscountPolicy by Product ID",
      description = "Get a List of active `DiscountPolicy` by `Product` ID.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "List of DiscountPolicy",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ListDiscountPolicyDto.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "DiscountPolicy not found",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  List<DiscountPolicyDto> getActiveDiscountPoliciesByProductId(@PathVariable String productId);

  @PostMapping
  @Operation(summary = "Create a DiscountPolicy", description = "Create a `DiscountPolicy`.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "DiscountPolicy created",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = DiscountPolicyDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  DiscountPolicyDto createDiscountPolicy(@RequestBody @Valid DiscountPolicyDto discountPolicyDto);

  @PutMapping
  @Operation(summary = "Update a DiscountPolicy", description = "Update a `DiscountPolicy`.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "DiscountPolicy updated",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = DiscountPolicyDto.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Bad request",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404",
            description = "DiscountPolicy not found",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  DiscountPolicyDto updateDiscountPolicy(@RequestBody @Valid DiscountPolicyDto discountPolicy);

  @DeleteMapping("/{id}")
  @Operation(
      summary = "Delete a DiscountPolicy by ID",
      description = "Delete a `DiscountPolicy` by ID.")
  @ApiResponses(
      value = {@ApiResponse(responseCode = "200", description = "Deleted DiscountPolicy")})
  void deleteDiscountPolicyById(@PathVariable String id);

  @DeleteMapping("/product/{productId}")
  @Operation(
      summary = "Delete all DiscountPolicy by Product ID",
      description = "Delete all `DiscountPolicy` by `Product` ID.")
  @ApiResponses(
      value = {@ApiResponse(responseCode = "200", description = "Deleted DiscountPolicy")})
  void deleteDiscountPoliciesByProductId(@PathVariable String productId);
}
