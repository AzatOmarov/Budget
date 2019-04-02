package de.budget.project.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionWebResponse {
    private BigDecimal amount;
    private String description;
    private String categoryName;
    private BigDecimal balance;
}