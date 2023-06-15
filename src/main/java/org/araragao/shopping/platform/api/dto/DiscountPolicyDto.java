package org.araragao.shopping.platform.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.araragao.shopping.platform.model.DiscountType;

public record DiscountPolicyDto(
    String id,
    @NotNull(message = "Product ID must not be null")
        @NotEmpty(message = "Product ID must not be empty")
        String productId,
    @NotNull(message = "Discount type must not be null") DiscountType type,
    @NotNull(message = "Active must not be null") Boolean active,
    @NotNull(message = "Threshold must not be null")
        @PositiveOrZero(message = "Threshold must be positive or zero")
        BigInteger threshold,
    @NotNull(message = "Value must not be null") @Positive(message = "Value must be positive")
        BigDecimal value) {}
