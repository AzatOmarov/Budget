package de.budget.project.model.web;

import lombok.Data;

@Data
public class WalletWebRequest {
    private Long userId;
    private String currencyName;
}