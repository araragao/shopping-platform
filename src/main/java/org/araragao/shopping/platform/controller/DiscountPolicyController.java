package org.araragao.shopping.platform.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.araragao.shopping.platform.api.DiscountPolicyApi;
import org.araragao.shopping.platform.api.dto.DiscountPolicyDto;
import org.araragao.shopping.platform.mapper.DiscountPolicyMapper;
import org.araragao.shopping.platform.model.Page;
import org.araragao.shopping.platform.service.DiscountPolicyService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DiscountPolicyController implements DiscountPolicyApi {

  private final DiscountPolicyService discountPolicyService;
  private final DiscountPolicyMapper discountPolicyMapper;

  @Override
  public DiscountPolicyDto getDiscountPolicyById(String id) {
    log.info("getDiscountPolicy with discountPolicyId: {}", id);
    return discountPolicyMapper.toDto(discountPolicyService.getDiscountPolicyById(id));
  }

  @Override
  public Page<DiscountPolicyDto> getDiscountPolicies(Pageable pageable) {
    log.info("getDiscountPolicies with pageable: {}", pageable);
    return discountPolicyMapper.toDtoPage(discountPolicyService.getDiscountPolicies(pageable));
  }

  @Override
  public List<DiscountPolicyDto> getDiscountPoliciesByProductId(String productId) {
    log.info("getDiscountPoliciesByProductId with productId: {}", productId);
    return discountPolicyMapper.toDtos(
        discountPolicyService.getDiscountPoliciesByProductId(productId));
  }

  @Override
  public List<DiscountPolicyDto> getActiveDiscountPoliciesByProductId(String productId) {
    return discountPolicyMapper.toDtos(
        discountPolicyService.getActiveDiscountPoliciesByProductId(productId));
  }

  @Override
  public DiscountPolicyDto createDiscountPolicy(@RequestBody DiscountPolicyDto discountPolicyDto) {
    log.info("createDiscountPolicy with discountPolicyDto: {}", discountPolicyDto);
    return discountPolicyMapper.toDto(
        discountPolicyService.createDiscountPolicy(
            discountPolicyMapper.toModel(discountPolicyDto)));
  }

  @Override
  public DiscountPolicyDto updateDiscountPolicy(@RequestBody DiscountPolicyDto discountPolicy) {
    log.info("updateDiscountPolicy with discountPolicyDto: {}", discountPolicy);
    return discountPolicyMapper.toDto(
        discountPolicyService.updateDiscountPolicy(discountPolicyMapper.toModel(discountPolicy)));
  }

  @Override
  public void deleteDiscountPolicyById(String id) {
    log.info("deleteDiscountPolicy with id: {}", id);
    discountPolicyService.deleteDiscountPolicy(id);
  }

  @Override
  public void deleteDiscountPoliciesByProductId(String productId) {
    log.info("deleteAllDiscountPoliciesByProductId with productId: {}", productId);
    discountPolicyService.deleteDiscountPoliciesByProductId(productId);
  }
}
