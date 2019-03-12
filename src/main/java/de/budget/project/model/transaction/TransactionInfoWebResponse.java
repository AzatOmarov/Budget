package de.budget.project.model.transaction;

import de.budget.project.model.category.Category;
import lombok.Data;

@Data
public class TransactionInfoWebResponse {

    private Category category;
    private Double amount;
    private String description;
}