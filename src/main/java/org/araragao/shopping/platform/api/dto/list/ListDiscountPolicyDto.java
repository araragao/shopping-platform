package org.araragao.shopping.platform.api.dto.list;

import java.util.ArrayList;
import org.araragao.shopping.platform.api.dto.DiscountPolicyDto;

/*
 ListDiscountPolicyDto class is required for Swagger API @Schema implementation since it does not
 support parameterized implementations, i.e., List<DiscountPolicyDto>.
*/
public class ListDiscountPolicyDto extends ArrayList<DiscountPolicyDto> {}
