package de.budget.project.repository;

import de.budget.project.model.entites.Category;
import de.budget.project.model.types.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getCategoryById(Long id);

    List<Category> getAllByCategoryType(CategoryType categoryType);
}