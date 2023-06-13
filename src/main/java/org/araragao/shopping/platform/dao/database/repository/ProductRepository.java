package org.araragao.shopping.platform.dao.database.repository;

import org.araragao.shopping.platform.dao.database.document.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductDocument, String> {}
