package de.budget.project.model.web;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionWebRequest {
    private Date customDate;
    private BigDecimal amount;
    private Long walletId;
    private Long categoryId;
    private String description;
}