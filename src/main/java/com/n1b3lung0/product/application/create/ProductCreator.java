package com.n1b3lung0.product.application.create;

import com.n1b3lung0.product.domain.Product;
import com.n1b3lung0.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductCreator {

    private final ProductRepository repository;

    public Product create(ProductCreateRequest request) {
        Product product = request.toProduct(request.name(), request.description(), request.price());
        Product saved = repository.save(product);
        log.info("Product created successfully: {}", saved);
        return saved;
    }
}
