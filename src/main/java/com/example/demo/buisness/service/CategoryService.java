package com.example.demo.buisness.service;

import com.example.demo.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> ListAllCategories();
    List<String> ListAllCategoryNames();


}
