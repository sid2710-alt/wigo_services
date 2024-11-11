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
        List<Category> allCategories = categoryRepo.findAll();
        // Shuffle the list to randomize
        Collections.shuffle(allCategories);

        // Return a subset of categories, for example, the first 3 categories
       List<Category> randomCategories = allCategories.stream().filter(category -> !"More".equals(category.getTitle())).limit(4).collect(Collectors.toList());

       Category moreCategory = allCategories.stream().filter(category -> "More".equals(category.getTitle())).findFirst().orElse(null);
       if (moreCategory != null) {
        randomCategories.add(moreCategory);
       }
       return randomCategories;
    }

}
