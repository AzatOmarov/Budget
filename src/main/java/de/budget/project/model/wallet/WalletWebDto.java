package de.budget.project.model.wallet;

import lombok.Data;

@Data
public class WalletWebDto {
    private Long userId;
    private String currency;
}