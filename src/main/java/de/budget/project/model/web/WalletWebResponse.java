package de.budget.project.model.web;

import de.budget.project.model.types.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletWebResponse {
    private Long walletId;
    private CurrencyType currency;
}