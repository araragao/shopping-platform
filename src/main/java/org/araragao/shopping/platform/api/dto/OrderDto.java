package org.araragao.shopping.platform.api.dto;

import java.math.BigInteger;

public record OrderDto(BigInteger amount, String productId) {}
