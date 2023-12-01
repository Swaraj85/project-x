package com.swaraj.projectx.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    Iterable<Product> all()
    {
        return productRepository.findAll();
    }

    @GetMapping("/{start}/{end}")
    List<Product> getPagedResponse(@PathVariable int start, @PathVariable int end) {

        Page<Product> all = productRepository.findAll(PageRequest.of(start, end));
        return all.get().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    Product findById(@PathVariable long id)
    {
        return productRepository.findById(id).get();
    }

}
