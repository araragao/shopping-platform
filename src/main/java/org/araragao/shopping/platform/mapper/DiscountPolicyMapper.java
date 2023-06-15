package org.araragao.shopping.platform.mapper;

import java.util.List;
import org.araragao.shopping.platform.api.dto.DiscountPolicyDto;
import org.araragao.shopping.platform.config.MapStructConfig;
import org.araragao.shopping.platform.dao.database.document.DiscountPolicyDocument;
import org.araragao.shopping.platform.mapper.annotation.MappingIgnoreAuditableFields;
import org.araragao.shopping.platform.model.DiscountPolicy;
import org.araragao.shopping.platform.model.Page;
import org.mapstruct.Mapper;
import org.springframework.data.domain.PageImpl;

@Mapper(config = MapStructConfig.class)
public interface DiscountPolicyMapper {

  DiscountPolicyDto toDto(DiscountPolicy discountPolicy);

  List<DiscountPolicyDto> toDtos(List<DiscountPolicy> discountPolicy);

  default Page<DiscountPolicyDto> toDtoPage(Page<DiscountPolicy> discountPolicyPage) {
    Page<DiscountPolicyDto> discountPolicyDtoPage = new Page<>();
    discountPolicyDtoPage.setContent(toDtos(discountPolicyPage.getContent()));
    discountPolicyDtoPage.setPageInfo(discountPolicyPage.getPageInfo());
    discountPolicyDtoPage.setSortInfo(discountPolicyPage.getSortInfo());
    return discountPolicyDtoPage;
  }

  DiscountPolicy toModel(DiscountPolicyDto discountPolicyDto);

  DiscountPolicy toModel(DiscountPolicyDocument discountPolicyDocument);

  List<DiscountPolicy> toModels(List<DiscountPolicyDocument> discountPolicyDocuments);

  default Page<DiscountPolicy> toModelPage(
      org.springframework.data.domain.Page<DiscountPolicyDocument> discountPolicyDocumentPage) {
    List<DiscountPolicy> products = toModels(discountPolicyDocumentPage.getContent());
    return new Page<>(
        new PageImpl<>(
            products,
            discountPolicyDocumentPage.getPageable(),
            discountPolicyDocumentPage.getTotalElements()));
  }

  @MappingIgnoreAuditableFields
  DiscountPolicyDocument toDocument(DiscountPolicy discountPolicy);
}
