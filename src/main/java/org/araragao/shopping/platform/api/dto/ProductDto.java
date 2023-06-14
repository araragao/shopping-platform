package org.araragao.shopping.platform.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductDto(
    String id,
    @NotBlank(message = "Name must not be blank") String name,
    @Positive(message = "Price must be positive") BigDecimal price,
    @PositiveOrZero(message = "Stock must be positive or zero") BigInteger stock) {}
