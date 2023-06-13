package org.araragao.shopping.platform.mapper;

import java.util.List;
import org.araragao.shopping.platform.api.dto.ProductDto;
import org.araragao.shopping.platform.dao.database.document.ProductDocument;
import org.araragao.shopping.platform.model.Product;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductDto toDto(Product product);

  List<ProductDto> toDtos(List<Product> product);

  default Page<ProductDto> toDtoPage(Page<Product> productPage) {
    List<ProductDto> productDtos = toDtos(productPage.getContent());
    return new PageImpl<>(productDtos, productPage.getPageable(), productPage.getTotalElements());
  }

  Product toModel(ProductDto productDto);

  Product toModel(ProductDocument productDocument);

  List<Product> toModels(List<ProductDocument> productDocuments);

  default Page<Product> toModelPage(Page<ProductDocument> productDocumentPage) {
    List<Product> products = toModels(productDocumentPage.getContent());
    return new PageImpl<>(
        products, productDocumentPage.getPageable(), productDocumentPage.getTotalElements());
  }

  ProductDocument toDocument(Product product);
}
