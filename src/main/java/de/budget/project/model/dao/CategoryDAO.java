package de.budget.project.model.dao;

import de.budget.project.model.types.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDAO {
    private Long id;
    private String name;
    private CategoryType categoryTypeId;
}
