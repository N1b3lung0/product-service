package com.n1b3lung0.product.infrastructure;

import com.n1b3lung0.product.domain.Product;
import com.n1b3lung0.product.domain.ProductRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository extends ProductRepository, MongoRepository<Product, String> {
}
