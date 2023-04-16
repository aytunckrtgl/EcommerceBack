package com.example.demo.buisness.controller;

import com.example.demo.buisness.dto.ProductDto;
import com.example.demo.buisness.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductService productService;

    //TODO PRODUCT ID YOKSA
    @GetMapping("/{productId}")
    public ProductDto listOneProduct(@PathVariable("productId") long productId){
        return productService.listProduct(productId);
    }
}
