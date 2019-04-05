package de.budget.project.services;

import de.budget.project.model.entites.Wallet;
import de.budget.project.model.web.WalletWebResponse;

import java.util.List;

public interface WalletService {

    Long createWallet(Long userId, Integer currencyId);

    WalletWebResponse getWalletById(Long id);

    List<Wallet> getWalletsByUserId(Long userId);
}