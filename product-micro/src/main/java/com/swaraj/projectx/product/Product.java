package com.swaraj.projectx.product;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Data // provide getter and setter via lombok
public class Product {
    @Id // primary key
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;
    private String category;
}
