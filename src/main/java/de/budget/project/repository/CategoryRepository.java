package de.budget.project.repository;

import de.budget.project.model.dao.CategoryDAO;
import de.budget.project.model.entites.Category;
import de.budget.project.model.types.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getCategoryById(Long id);

    List<Category> getAllByCategoryType(CategoryType categoryType);

    @Query("SELECT new de.budget.project.model.dao.CategoryDAO" +
            "(c.id, c.name, c.categoryType)" +
            "FROM Category c WHERE c.categoryType = 1 OR c.categoryType = 2")
    List<CategoryDAO> getAllCategories();
}