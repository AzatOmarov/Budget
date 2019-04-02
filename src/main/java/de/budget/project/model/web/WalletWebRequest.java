package de.budget.project.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletWebRequest {
    private Long userId;
    private String currencyName;
}