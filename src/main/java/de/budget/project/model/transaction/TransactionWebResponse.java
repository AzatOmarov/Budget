package de.budget.project.model.transaction;

import lombok.Data;

@Data
public class TransactionWebResponse {
    private Float amount;
    private String description;
    private String categoryName;
    private Float balance;
}