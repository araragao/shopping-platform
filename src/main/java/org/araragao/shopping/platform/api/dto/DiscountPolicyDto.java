package org.araragao.shopping.platform.api.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.araragao.shopping.platform.model.DiscountType;

public record DiscountPolicyDto(
    String id,
    String productId,
    DiscountType type,
    Boolean active,
    BigInteger threshold,
    BigDecimal value) {}
