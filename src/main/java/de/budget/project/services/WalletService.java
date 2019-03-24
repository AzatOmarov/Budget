package de.budget.project.services;

import de.budget.project.model.wallet.Wallet;

import java.util.List;

public interface WalletService {

    Wallet createWallet(Long userId, String currency);

    List<Wallet> getAll();

    Wallet getWalletById(Long id);

    List<Wallet> getAllByUserId(Long userId);

    List<Wallet> getAllByUserEmail(String email);
}