package org.araragao.shopping.platform.dao;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.araragao.shopping.platform.dao.database.repository.DiscountPolicyRepository;
import org.araragao.shopping.platform.exception.custom.DiscountPolicyNotFoundException;
import org.araragao.shopping.platform.mapper.DiscountPolicyMapper;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscountPolicyDaoImpl implements DiscountPolicyDao {

  private final DiscountPolicyRepository discountPolicyRepository;
  private final DiscountPolicyMapper discountPolicyMapper;

  @Override
  public DiscountPolicy find(String discountPolicyId) {
    return discountPolicyMapper.toModel(
        discountPolicyRepository
            .findById(discountPolicyId)
            .orElseThrow(
                () ->
                    new DiscountPolicyNotFoundException(
                        "DiscountPolicy with id: "
                            + discountPolicyId
                            + "was not found in the database")));
  }

  @Override
  public Page<DiscountPolicy> find(Pageable pageable) {
    return discountPolicyMapper.toModelPage(discountPolicyRepository.findAll(pageable));
  }

  @Override
  public List<DiscountPolicy> findByProductId(String productId) {
    return discountPolicyMapper.toModels(discountPolicyRepository.findByProductId(productId));
  }

  @Override
  public List<DiscountPolicy> findByProductIdAndActive(String productId, Boolean active) {
    return discountPolicyMapper.toModels(
        discountPolicyRepository.findByProductIdAndActive(productId, active));
  }

  @Override
  public DiscountPolicy save(DiscountPolicy discountPolicy) {
    return discountPolicyMapper.toModel(
        discountPolicyRepository.save(discountPolicyMapper.toDocument(discountPolicy)));
  }

  @Override
  public void remove(String discountPolicyId) {
    discountPolicyRepository.deleteById(discountPolicyId);
  }

  @Override
  public void removeByProductId(String productId) {
    discountPolicyRepository.deleteByProductId(productId);
  }
}
