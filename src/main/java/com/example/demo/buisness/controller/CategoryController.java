package com.example.demo.buisness.controller;

import com.example.demo.buisness.service.CategoryService;
import com.example.demo.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public List<Category> ListAllCategories(){
        return categoryService.ListAllCategories();

    }
    //BURA KULLANILMIYO OLABİLİR
    @GetMapping("/deneme")
    public List<String> ListAllCategoryNames(){
        return categoryService.ListAllCategoryNames();
    }

}
