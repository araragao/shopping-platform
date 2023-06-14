package org.araragao.shopping.platform.api.dto.page;

import org.araragao.shopping.platform.api.dto.DiscountPolicyDto;
import org.araragao.shopping.platform.model.Page;

/*
 PageDiscountPolicyDto class is required for Swagger API @Schema implementation since it does not
 support parameterized implementations, i.e., Page<DiscountPolicyDto>.
*/
public class PageDiscountPolicyDto extends Page<DiscountPolicyDto> {}
