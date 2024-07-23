package com.n1b3lung0.product.application.create;

import com.n1b3lung0.product.domain.Product;

import java.math.BigDecimal;

public record ProductCreateRequest(String id, String name, String description, BigDecimal price) {

    public Product toProduct(String name, String description, BigDecimal price) {
        return Product.create(name, description, price);
    }
}
