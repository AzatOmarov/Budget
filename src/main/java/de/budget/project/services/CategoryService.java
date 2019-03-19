package de.budget.project.services;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryType;
import de.budget.project.model.category.CategoryWebDto;

import java.util.List;

public interface CategoryService {

    void createCategory(CategoryWebDto categoryWebDto);
}