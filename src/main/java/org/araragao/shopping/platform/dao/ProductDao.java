package org.araragao.shopping.platform.dao;

import org.araragao.shopping.platform.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductDao {

  Product find(String productId);

  Page<Product> find(Pageable pageable);

  Product save(Product product);

  void remove(String productId);
}
