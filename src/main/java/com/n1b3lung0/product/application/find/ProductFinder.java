package com.n1b3lung0.product.application.find;

import com.n1b3lung0.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductFinder {

    private final ProductRepository repository;

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream().map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice()
                ))
                .toList();
    }
}
