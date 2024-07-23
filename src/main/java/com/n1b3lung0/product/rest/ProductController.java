package com.n1b3lung0.product.rest;

import com.n1b3lung0.product.application.create.ProductCreateRequest;
import com.n1b3lung0.product.application.create.ProductCreator;
import com.n1b3lung0.product.application.find.ProductFinder;
import com.n1b3lung0.product.application.find.ProductResponse;
import com.n1b3lung0.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductCreator creator;
    private final ProductFinder finder;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody ProductCreateRequest request) {
        Product saved = creator.create(request);
        URI location = UriComponentsBuilder.fromPath("/products/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductResponse>> getAll() {
        return ResponseEntity.ok(finder.findAll());
    }
}
