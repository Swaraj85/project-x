package com.swaraj.projectx.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository userRepository;

    @GetMapping("/products")
    List<Product> all()
    {
        return userRepository.findAll();
    }

}