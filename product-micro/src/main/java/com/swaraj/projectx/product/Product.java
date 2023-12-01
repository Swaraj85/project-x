package com.swaraj.projectx.product;

import lombok.Data;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Data // provide getter and setter via lombok
public class Product {
    @Id // primary key
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String category;
}
