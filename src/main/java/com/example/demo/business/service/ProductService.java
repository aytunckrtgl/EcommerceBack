package com.example.demo.business.service;

import com.example.demo.business.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> listAll();

    List<ProductDto> listCategory(long categoryId);

    ProductDto listProduct(long productId);
}
