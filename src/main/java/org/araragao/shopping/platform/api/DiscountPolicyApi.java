package org.araragao.shopping.platform.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.araragao.shopping.platform.api.dto.DiscountPolicyDto;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Discount Policies", description = "CRUD operations related to Discount Policies")
@RequestMapping("/api/discount-policies")
public interface DiscountPolicyApi {

  @GetMapping("/{id}")
  @Operation(summary = "Get a DiscountPolicy by ID", description = "Get a `DiscountPolicy` by ID.")
  DiscountPolicyDto getDiscountPolicyById(String id);

  @GetMapping
  @Operation(
      summary = "Get a Page of DiscountPolicy given page, size and sort query parameters",
      description = "Get a `Page` of `DiscountPolicy` given page, size and sort query parameters.")
  Page<DiscountPolicyDto> getDiscountPolicies(@ParameterObject Pageable pageable);

  @GetMapping("/{productId}")
  @Operation(
      summary = "Get a DiscountPolicy by Product ID",
      description = "Get a `DiscountPolicy` by `Product` ID.")
  List<DiscountPolicyDto> getDiscountPoliciesByProductId(String productId);

  @GetMapping("/{productId}/active")
  @Operation(
      summary = "Get a List of active DiscountPolicy by Product ID",
      description = "Get a List of active `DiscountPolicy` by `Product` ID.")
  List<DiscountPolicyDto> getActiveDiscountPoliciesByProductId(String productId);

  @PostMapping
  @RequestBody
  @Operation(summary = "Create a DiscountPolicy", description = "Create a `DiscountPolicy`.")
  DiscountPolicyDto createDiscountPolicy(DiscountPolicyDto discountPolicyDto);

  @PutMapping
  @RequestBody
  @Operation(summary = "Update a DiscountPolicy", description = "Update a `DiscountPolicy`.")
  DiscountPolicyDto updateDiscountPolicy(DiscountPolicyDto discountPolicy);

  @DeleteMapping("/{id}")
  @Operation(
      summary = "Delete a DiscountPolicy by ID",
      description = "Delete a `DiscountPolicy` by ID.")
  void deleteDiscountPolicyById(String id);

  @DeleteMapping("/{productId}")
  @Operation(
      summary = "Delete all DiscountPolicy by Product ID",
      description = "Delete all `DiscountPolicy` by `Product` ID.")
  void deleteDiscountPoliciesByProductId(String productId);
}
