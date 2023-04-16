package com.example.demo.business.controller;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.business.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProductsController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> listAllProducts() {
        return productService.listAll();
    }

    @GetMapping("/{categoryId}")
    public List<ProductDto> listAllProductsOfOneCategory(@PathVariable("categoryId") long categoryId) {
        return productService.listCategory(categoryId);
    }
}
