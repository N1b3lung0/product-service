package com.n1b3lung0.product.application.find;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, BigDecimal price) {
}
