package com.example.demo.business.controller;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.business.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ProductDto listOneProduct(@PathVariable("productId") long productId) {
        return productService.listProduct(productId);
    }
}
