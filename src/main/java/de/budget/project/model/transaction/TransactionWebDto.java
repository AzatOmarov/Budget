package de.budget.project.model.transaction;

import de.budget.project.model.category.Category;
import lombok.Data;

@Data
public class TransactionWebDto {

    private Float amount;
    private Long walletId;
    private String description;
//    private Long categoryId;
    private Long categoryId;
}
