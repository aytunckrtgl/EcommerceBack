package com.example.demo.buisness.dto;

import com.example.demo.model.entity.Product;

public class CartProductDto {

    private Product product;
    private int salesQuantity;



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}

