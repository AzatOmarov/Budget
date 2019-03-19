package de.budget.project.model.transaction;

import lombok.Data;

@Data
public class TransactionInfo {

    private Float amount;
    private String description;
    private String categoryName;
    private String createdDate;
}
