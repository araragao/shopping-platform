package org.araragao.shopping.platform.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.api.ProductApi;
import org.araragao.shopping.platform.api.dto.ProductDto;
import org.araragao.shopping.platform.mapper.ProductMapper;
import org.araragao.shopping.platform.model.Page;
import org.araragao.shopping.platform.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

  private final ProductService productService;
  private final ProductMapper productMapper;

  @Override
  public ProductDto getProductById(String id) {
    log.info("getProduct with productId: {}", id);
    return productMapper.toDto(productService.getProductById(id));
  }

  @Override
  public Page<ProductDto> getProducts(Pageable pageable) {
    log.info("getProducts with pageable: {}", pageable);
    return productMapper.toDtoPage(productService.getProducts(pageable));
  }

  @Override
  public ProductDto createProduct(@RequestBody ProductDto productDto) {
    log.info("createProduct with productDto: {}", productDto);
    return productMapper.toDto(productService.createProduct(productMapper.toModel(productDto)));
  }

  @Override
  public ProductDto updateProduct(@RequestBody ProductDto productDto) {
    log.info("updateProduct with productDto: {}", productDto);
    return productMapper.toDto(productService.updateProduct(productMapper.toModel(productDto)));
  }

  @Override
  public void deleteProductById(String id) {
    log.info("deleteProduct with productId: {}", id);
    productService.deleteProductById(id);
  }
}
