package org.araragao.shopping.platform.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigInteger;

public record OrderPriceDiscountedBestDto(
    @Positive(message = "Amount must be positive")
    BigInteger amount,

    @NotBlank(message = "Product ID must not be blank")
    String productId) {}
