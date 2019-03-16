package de.budget.project.model.wallet;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class WalletWebDto {

    private User userId;
    private String currency;
    private BigDecimal balance;
}