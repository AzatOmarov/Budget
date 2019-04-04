package de.budget.project.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionDAO {
    private Long id;
    private Date date;
    private BigDecimal amount;
    private Long walletId;
    private Long categoryId;
    private String description;
    private Date createdDate;
    private Date updatedDate;
}