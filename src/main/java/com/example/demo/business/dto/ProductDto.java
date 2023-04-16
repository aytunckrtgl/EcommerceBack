package com.example.demo.business.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private long productId;
    private String Name;
    private String shortDescription;
    private String longDescription;
    private Double price;
}
