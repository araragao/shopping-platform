package org.araragao.shopping.platform.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record OrderPriceDto(
    @NotNull(message = "Price must not be null")
    @Positive(message = "Price must be positive")
    BigDecimal price) {}
