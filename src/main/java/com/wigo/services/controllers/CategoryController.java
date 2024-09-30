package com.wigo.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wigo.services.config.CategoryRepo;
import com.wigo.services.models.Category;

public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/create/category")
    public String createCategory(@RequestBody Category category) {
        Category newCategory = categoryRepo.save(category);
        return newCategory.getId();
    }
}
