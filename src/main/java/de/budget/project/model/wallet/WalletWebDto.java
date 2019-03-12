package de.budget.project.model.wallet;

import lombok.Data;

@Data
public class WalletWebDto {

    private String currency;
    private Double balance;
}