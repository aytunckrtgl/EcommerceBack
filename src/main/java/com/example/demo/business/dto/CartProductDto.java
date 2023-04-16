package com.example.demo.business.dto;

import com.example.demo.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDto {

    private Product product;
    private int salesQuantity;
}

