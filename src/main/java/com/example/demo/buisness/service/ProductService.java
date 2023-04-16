package com.example.demo.buisness.service;

import com.example.demo.buisness.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> listAll();
    List<ProductDto> listCategory(long categoryId);
    ProductDto listProduct(long productId);
}
