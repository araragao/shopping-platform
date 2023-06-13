package org.araragao.shopping.platform.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.dao.ProductDao;
import org.araragao.shopping.platform.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductDao productDao;

  public Product getProductById(String productId) {
    return productDao.find(productId);
  }

  public Page<Product> getProducts(Pageable pageable) {
    return productDao.find(pageable);
  }

  public Product createProduct(Product product) {
    return productDao.save(product);
  }

  public Product updateProduct(Product product) {
    return productDao.save(product);
  }

  public void deleteProductById(String productId) {
    productDao.remove(productId);
  }
}
