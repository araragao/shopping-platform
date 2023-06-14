package org.araragao.shopping.platform.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.araragao.shopping.platform.model.DiscountType;

public record DiscountPolicyDto(
    String id,
    @NotBlank(message = "Product ID must not be blank") String productId,
    @NotNull(message = "Discount type must not be null") DiscountType type,
    @NotNull(message = "Active must not be null") Boolean active,
    @PositiveOrZero(message = "Threshold must be positive or zero") BigInteger threshold,
    @Positive(message = "Value must be positive") BigDecimal value) {}
