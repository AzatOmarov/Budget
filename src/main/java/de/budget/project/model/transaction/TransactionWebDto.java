package de.budget.project.model.transaction;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryType;
import de.budget.project.model.user.User;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionWebDto {

    private Date date;
    private CategoryType categoryType;
    private Category category;
    private User user;
    private Double amount;
    private String description;
}
