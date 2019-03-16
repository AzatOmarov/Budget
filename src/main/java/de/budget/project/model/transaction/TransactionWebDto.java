package de.budget.project.model.transaction;

import de.budget.project.model.category.Category;
import de.budget.project.model.category.CategoryType;
import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionWebDto {

//    private Date date;
//    private CategoryType categoryType;
//    private Category category;

    private BigDecimal amount;
    private Wallet walletId;
    private String description;
}
