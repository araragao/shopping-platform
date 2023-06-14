package org.araragao.shopping.platform.api.dto.page;

import org.araragao.shopping.platform.api.dto.ProductDto;
import org.araragao.shopping.platform.model.Page;

/*
 PageProductDto class is required for Swagger API @Schema implementation since it does not
 support parameterized implementations, i.e., Page<ProductDto>.
*/
public class PageProductDto extends Page<ProductDto> {}
