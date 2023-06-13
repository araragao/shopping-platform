package org.araragao.shopping.platform.mapper;

import java.util.List;
import org.araragao.shopping.platform.api.dto.DiscountPolicyDto;
import org.araragao.shopping.platform.dao.database.document.DiscountPolicyDocument;
import org.araragao.shopping.platform.mapper.annotation.MappingIgnoreAuditableFields;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

@Mapper(componentModel = "spring")
public interface DiscountPolicyMapper {

  DiscountPolicyDto toDto(DiscountPolicy discountPolicy);

  List<DiscountPolicyDto> toDtos(List<DiscountPolicy> discountPolicy);

  default Page<DiscountPolicyDto> toDtoPage(Page<DiscountPolicy> discountPolicyPage) {
    List<DiscountPolicyDto> discountPolicyDtos = toDtos(discountPolicyPage.getContent());
    return new PageImpl<>(
        discountPolicyDtos,
        discountPolicyPage.getPageable(),
        discountPolicyPage.getTotalElements());
  }

  DiscountPolicy toModel(DiscountPolicyDto discountPolicyDto);

  DiscountPolicy toModel(DiscountPolicyDocument discountPolicyDocument);

  List<DiscountPolicy> toModels(List<DiscountPolicyDocument> discountPolicyDocuments);

  default Page<DiscountPolicy> toModelPage(Page<DiscountPolicyDocument> discountPolicyPage) {
    List<DiscountPolicy> discountPolicies = toModels(discountPolicyPage.getContent());
    return new PageImpl<>(
        discountPolicies, discountPolicyPage.getPageable(), discountPolicyPage.getTotalElements());
  }

  @MappingIgnoreAuditableFields
  DiscountPolicyDocument toDocument(DiscountPolicy discountPolicy);
}
