package de.budget.project.controller;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryType;
import de.budget.project.model.category.CategoryWebDto;
import de.budget.project.service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/category")
    public void createCategory(@RequestBody CategoryWebDto categoryWebDto) {
        categoryService.createCategory(categoryWebDto);
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/category/byType/{id}")
    public List<Category> getAllByCategoryTypeId(@PathVariable("id") CategoryType categoryType) {
        return categoryService.getAllByCategoryTypeId(categoryType);
    }
}