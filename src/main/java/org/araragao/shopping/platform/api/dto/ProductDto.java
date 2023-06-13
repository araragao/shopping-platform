package org.araragao.shopping.platform.api.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductDto(String id, String name, BigDecimal price, BigInteger stock) {}
