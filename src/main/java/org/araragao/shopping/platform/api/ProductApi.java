package org.araragao.shopping.platform.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.araragao.shopping.platform.api.dto.ProductDto;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Products", description = "CRUD operations related to Products")
@RequestMapping("/api/products")
public interface ProductApi {

  @GetMapping("/{id}")
  @Operation(summary = "Get a Product by ID", description = "Get a `Product` by ID.")
  ProductDto getProductById(String id);

  @GetMapping
  @Operation(
      summary = "Get a Page of Product given page, size and sort query parameters",
      description = "Get a `Page` of `Product` given page, size and sort query parameters.")
  Page<ProductDto> getProducts(@ParameterObject Pageable pageable);

  @PostMapping
  @RequestBody
  @Operation(summary = "Create a Product", description = "Create a `Product`.")
  ProductDto createProduct(ProductDto productDto);

  @PutMapping
  @RequestBody
  @Operation(summary = "Update a Product", description = "Update a `Product`.")
  ProductDto updateProduct(ProductDto productDto);

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete a Product by ID", description = "Delete a `Product` by ID.")
  void deleteProductById(String id);
}
