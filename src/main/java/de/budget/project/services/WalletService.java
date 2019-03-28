package de.budget.project.services;

import de.budget.project.model.wallet.Wallet;

import java.util.List;

public interface WalletService {

    void insertWallet(Long userId, Integer currencyId);

    Wallet getWalletById(Long id);

    List<Wallet> getAllByUserId(Long userId);
}