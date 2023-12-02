package com.swaraj.projectx.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    ResponseEntity<Iterable<Product>> all() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{start}/{end}")
    List<Product> getPagedResponse(@PathVariable int start, @PathVariable int end) {

        Page<Product> all = productRepository.findAll(PageRequest.of(start, end));
        return all.get().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> findById(@PathVariable String id)
    {
        Optional<Product> byId = productRepository.findById(id);
        return byId.isPresent()? ResponseEntity.ok(byId.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
    }

    @PostMapping("/")
    public ResponseEntity<?> postProduct(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        return ResponseEntity.accepted().build();
    }

}
