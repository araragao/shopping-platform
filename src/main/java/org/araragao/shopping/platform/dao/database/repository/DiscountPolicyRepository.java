package org.araragao.shopping.platform.dao.database.repository;

import java.util.List;
import org.araragao.shopping.platform.dao.database.document.DiscountPolicyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountPolicyRepository extends MongoRepository<DiscountPolicyDocument, String> {

  List<DiscountPolicyDocument> findByProductId(String productId);

  List<DiscountPolicyDocument> findByProductIdAndActive(String productId, Boolean active);

  void deleteByProductId(String productId);
}
