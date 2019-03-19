package de.budget.project.controller;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryWebDto;
import de.budget.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/categories")
    public void createCategory(@RequestBody CategoryWebDto categoryWebDto){
        categoryService.createCategory(categoryWebDto);
    }

    @GetMapping("/categories")
    public List<Category> getAll(){
        return null;
    }
}