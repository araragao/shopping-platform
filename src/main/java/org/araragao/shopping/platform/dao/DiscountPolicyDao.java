package org.araragao.shopping.platform.dao;

import java.util.List;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiscountPolicyDao {

  DiscountPolicy find(String discountPolicyId);

  Page<DiscountPolicy> find(Pageable pageable);

  List<DiscountPolicy> findByProductId(String productId);

  List<DiscountPolicy> findByProductIdAndActive(String productId, Boolean active);

  DiscountPolicy save(DiscountPolicy discountPolicy);

  void remove(String discountPolicyId);

  void removeByProductId(String productId);
}
