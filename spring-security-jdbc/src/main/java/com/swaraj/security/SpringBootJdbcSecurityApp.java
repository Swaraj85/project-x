package com.swaraj.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringBootJdbcSecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcSecurityApp.class, args);
    }
}