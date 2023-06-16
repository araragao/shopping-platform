package org.araragao.shopping.platform.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.araragao.shopping.platform.api.dto.ProductDto;
import org.araragao.shopping.platform.api.dto.page.PageProductDto;
import org.araragao.shopping.platform.model.Page;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/api/products")
@Tag(name = "Products", description = "CRUD operations related to Products")
public interface ProductApi {

  @GetMapping("/{id}")
  @Operation(summary = "Get a Product by ID", description = "Get a `Product` by ID.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product found",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ProductDto.class))
            }),
        @ApiResponse(
            responseCode = "404",
            description = "Product not found",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content(mediaType = "application/json"))
      })
  ProductDto getProductById(@PathVariable String id);

  @GetMapping
  @Operation(
      summary = "Get a Page of Product given page, size and sort query parameters",
      description = "Get a `Page` of `Product` given page, size and sort query parameters.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Page of Product",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = PageProductDto.class))
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
  Page<ProductDto> getProducts(@PageableDefault @SortDefault @ParameterObject Pageable pageable);

  @PostMapping
  @Operation(summary = "Create a Product", description = "Create a `Product`.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product created",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ProductDto.class))
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
  ProductDto createProduct(@RequestBody @Valid ProductDto productDto);

  @PutMapping
  @Operation(summary = "Update a Product", description = "Update a `Product`.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Product updated",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = ProductDto.class))
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
  ProductDto updateProduct(@RequestBody @Valid ProductDto productDto);

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a Product by ID", description = "Delete a `Product` by ID.")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Deleted Product")})
  void deleteProductById(@PathVariable String id);
}
