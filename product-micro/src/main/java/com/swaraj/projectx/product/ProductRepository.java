package com.swaraj.projectx.product;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
    Optional<Product> findById(String id);
    Iterable<Product> findByName(String name);
}
