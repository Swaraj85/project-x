package com.swaraj.projectx.product;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Optional<Product> findById(Long id);
}
