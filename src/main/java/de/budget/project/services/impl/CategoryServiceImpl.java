package de.budget.project.services.impl;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryWebDto;
import de.budget.project.model.categoryType.CategoryType;
import de.budget.project.repository.CategoryRepository;
import de.budget.project.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ModelMapper modelMapper;


    @Override
    public void createCategory(CategoryWebDto categoryWebDto) {
        Category category = new Category();
        if(categoryWebDto.getName() == null){
            categoryWebDto.setName("");
        }
        category.setName(categoryWebDto.getName());
        category.setCategoryTypeId(CategoryType.getCategoryTypeByName(categoryWebDto.getCategoryType()));
        categoryRepository.save(category);
    }
}