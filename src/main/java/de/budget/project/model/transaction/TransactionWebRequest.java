package de.budget.project.model.transaction;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionWebRequest {
    private Date customDate;
    private Float amount;
    private Long walletId;
    private Long categoryId;
    private String description;
}