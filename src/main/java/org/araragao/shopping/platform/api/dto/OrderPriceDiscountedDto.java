package org.araragao.shopping.platform.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigInteger;

public record OrderPriceDiscountedDto(
    @Positive(message = "Amount must be positive")
    BigInteger amount,

    @NotBlank(message = "Product ID must not be blank")
    String productId,

    @NotBlank(message = "DiscountPolicy ID must not be blank")
    String discountPolicyId) {}
