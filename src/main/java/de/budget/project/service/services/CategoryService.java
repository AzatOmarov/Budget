package de.budget.project.service.services;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryType;
import de.budget.project.model.category.CategoryWebDto;

import java.util.List;

public interface CategoryService {

    void createCategory(CategoryWebDto categoryWebDto);

    Category getCategoryById(Long id);

    List<Category> getAllByCategoryTypeId(CategoryType categoryType);
}