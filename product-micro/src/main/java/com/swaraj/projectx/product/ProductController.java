package com.swaraj.projectx.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RefreshScope
@Slf4j
public class ProductController {

    @Value("${page.size}")
    private int size = 0;

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
        log.info("page size is : {}", size);
        Optional<Product> byId = productRepository.findById(id);
        return byId.isPresent()? ResponseEntity.ok(byId.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
    }

    @PostMapping("/")
    public ResponseEntity<?> postProduct(@RequestBody Product product) {
        Product saved = productRepository.save(product);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/params")
    public ResponseEntity<Iterable<Product>> getProductsByName(@RequestParam(value = "name", defaultValue = "World") String name){
        Iterable<Product> byName = productRepository.findByName(name);
        return ResponseEntity.ok(byName);
    }

}
