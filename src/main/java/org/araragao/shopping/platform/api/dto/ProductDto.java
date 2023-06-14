package org.araragao.shopping.platform.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductDto(
    String id,
    @NotNull(message = "Name must not be null") @NotEmpty(message = "Name must not be empty")
        String name,
    @NotNull(message = "Price must not be null") @Positive(message = "Price must be positive")
        BigDecimal price,
    @NotNull(message = "Stock must not be null")
        @PositiveOrZero(message = "Stock must be positive or zero")
        BigInteger stock) {}
