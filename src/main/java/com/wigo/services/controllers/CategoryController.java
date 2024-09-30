package com.wigo.services.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wigo.services.config.CategoryRepo;
import com.wigo.services.models.Category;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        Category newCategory = categoryRepo.save(category);
        return newCategory.getId();
    }

    @GetMapping("/categories/all")
    public List<Category> getAllCategories() {
        List<Category> allCategories = categoryRepo.findAll();
        allCategories.removeIf(category -> category.getTitle().equals("More"));
        return allCategories;
    }

    @GetMapping("/categories/random")
    public List<Category> getRandomCategories() {
        /// Implement later
      return getAllCategories();
    }

}
