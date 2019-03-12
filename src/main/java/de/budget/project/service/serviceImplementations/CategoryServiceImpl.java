package de.budget.project.service.serviceImplementations;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryType;
import de.budget.project.model.category.CategoryWebDto;
import de.budget.project.repository.CategoryRepository;
import de.budget.project.service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void createCategory(CategoryWebDto categoryWebDto) {
        Category category = new Category();
        category.setName(categoryWebDto.getName());
        category.setCategoryTypeId(categoryWebDto.getCategoryType());
        categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    @Override
    public List<Category> getAllByCategoryTypeId(CategoryType categoryType) {
        return categoryRepository.getAllByCategoryTypeId(categoryType);
    }
}