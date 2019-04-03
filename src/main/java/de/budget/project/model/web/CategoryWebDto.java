package de.budget.project.model.web;

import de.budget.project.model.types.CategoryType;
import lombok.Data;

@Data
public class CategoryWebDto {
    private String name;
    private Integer categoryTypeId;

    public CategoryWebDto(String name, CategoryType categoryType) {
        this.name = name;
        this.categoryTypeId = categoryType.getId();
    }
}