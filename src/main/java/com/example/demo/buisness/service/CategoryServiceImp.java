package com.example.demo.buisness.service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public List<Category> ListAllCategories(){
        List<Category> categoryList = new ArrayList<>();
        Iterable<Category> iterable = categoryRepository.findAll();
        for(Category category : iterable){
            categoryList.add(category);
        }
        return categoryList;

    }

    @Transactional
    public List<String >ListAllCategoryNames(){
        List<String> categoryNames = new ArrayList<>();
        Iterable<Category> iterable = categoryRepository.findAll();
        for(Category category : iterable){
            categoryNames.add(category.getCategoryName());
        }
        return categoryNames;


    }
}
