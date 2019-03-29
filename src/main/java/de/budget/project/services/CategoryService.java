package de.budget.project.services;

import de.budget.project.model.entites.Category;
import de.budget.project.model.types.CategoryType;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    Category getCategoryById(Long id);

    List<Category> getAllByCategoryType(CategoryType categoryType);
}