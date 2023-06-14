package org.araragao.shopping.platform.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.dao.DiscountPolicyDao;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountPolicyService {

  private final DiscountPolicyDao discountPolicyDao;

  public DiscountPolicy getDiscountPolicyById(String id) {
    return discountPolicyDao.find(id);
  }

  public Page<DiscountPolicy> getDiscountPolicies(Pageable pageable) {
    return discountPolicyDao.find(pageable);
  }

  public List<DiscountPolicy> getDiscountPoliciesByProductId(String productId) {
    return discountPolicyDao.findByProductId(productId);
  }

  public List<DiscountPolicy> getActiveDiscountPoliciesByProductId(String productId) {
    return discountPolicyDao.findByProductIdAndActive(productId, true);
  }

  public DiscountPolicy createDiscountPolicy(DiscountPolicy discountPolicy) {
    return discountPolicyDao.save(discountPolicy);
  }

  public DiscountPolicy updateDiscountPolicy(DiscountPolicy discountPolicy) {
    return discountPolicyDao.save(discountPolicy);
  }

  public void deleteDiscountPolicy(String id) {
    discountPolicyDao.remove(id);
  }

  public void deleteDiscountPoliciesByProductId(String productId) {
    discountPolicyDao.removeByProductId(productId);
  }
}
