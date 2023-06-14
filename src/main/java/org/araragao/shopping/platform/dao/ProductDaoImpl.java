package org.araragao.shopping.platform.dao;

import lombok.RequiredArgsConstructor;
import org.araragao.shopping.platform.dao.database.repository.ProductRepository;
import org.araragao.shopping.platform.exception.custom.ProductNotFoundException;
import org.araragao.shopping.platform.mapper.ProductMapper;
import org.araragao.shopping.platform.model.Page;
import org.araragao.shopping.platform.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  @Override
  public Product find(String productId) {
    return productMapper.toModel(
        productRepository
            .findById(productId)
            .orElseThrow(
                () ->
                    new ProductNotFoundException(
                        "Product with id: " + productId + " was not found in the database")));
  }

  @Override
  public Page<Product> find(Pageable pageable) {
    return productMapper.toModelPage(productRepository.findAll(pageable));
  }

  @Override
  public Product save(Product product) {
    return productMapper.toModel(productRepository.save(productMapper.toDocument(product)));
  }

  @Override
  public void remove(String productId) {
    productRepository.deleteById(productId);
  }
}
