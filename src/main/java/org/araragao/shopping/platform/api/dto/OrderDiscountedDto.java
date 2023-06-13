package org.araragao.shopping.platform.api.dto;

import java.math.BigInteger;

public record OrderDiscountedDto(BigInteger amount, String productId, String discountPolicyId) {}
