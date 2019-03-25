package de.budget.project.model.category;

import de.budget.project.model.categoryType.CategoryType;
import lombok.Data;

@Data
public class CategoryWebDto {
    private String name;
    private String categoryTypeName;

    public CategoryWebDto(String name, CategoryType categoryType) {
        this.name = name;
        this.categoryTypeName = categoryType.getName();
    }
}