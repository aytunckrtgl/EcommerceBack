package com.example.demo.buisness.controller;

import com.example.demo.buisness.dto.ProductDto;
import com.example.demo.buisness.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductsController{
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<ProductDto> listAllProducts(){
        return productService.listAll();

    }


    @GetMapping("/{categoryId}")
    public List<ProductDto> listAllProductsOfOneCategory(@PathVariable("categoryId") long categoryId){
        return productService.listCategory(categoryId);

    }

}
