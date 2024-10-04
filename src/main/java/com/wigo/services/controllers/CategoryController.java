package com.wigo.services.controllers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wigo.services.config.CategoryRepo;
import com.wigo.services.models.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        Category newCategory = categoryRepo.save(category);
        return newCategory.getId();
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        List<Category> allCategories = categoryRepo.findAll();
        allCategories.removeIf(category -> category.getTitle().equals("More"));
        return allCategories;
    }

    @GetMapping("/random")
    public List<Category> getRandomCategories() {
        List<Category> allCategories = getAllCategories();
        // Shuffle the list to randomize
        Collections.shuffle(allCategories);

        // Return a subset of categories, for example, the first 3 categories
        return allCategories.stream().limit(3).collect(Collectors.toList());
    }

}
