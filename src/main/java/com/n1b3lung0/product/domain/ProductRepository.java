package com.n1b3lung0.product.domain;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product save(Product product);
}
