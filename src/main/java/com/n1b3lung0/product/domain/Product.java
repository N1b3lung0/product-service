package com.n1b3lung0.product.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Data
public final class Product {

    @With @Id
    private final String id;
    @With
    private final String name;
    @With
    private final String description;
    @With
    private final BigDecimal price;

    public static Product create(String name, String description, BigDecimal price) {
        return new Product(null, name, description, price);
    }
}
