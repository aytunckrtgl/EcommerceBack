package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", nullable = true)
    private long id;

    @Column(name = "productName", nullable = true)
    private String Name;

    @Column(name = "shortDescription", nullable = true)
    private String shortDescription;

    @Column(name = "longDescription", nullable = true)
    private String longDescription;

    @Column(name = "price", nullable = true)
    private Double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = true)
    private Category category;

}
