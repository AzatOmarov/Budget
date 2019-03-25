package de.budget.project.services;

import de.budget.project.model.wallet.Wallet;

import java.util.List;

public interface WalletService {

    Wallet createWallet(Wallet wallet);

    Wallet getWalletById(Long id);

    List<Wallet> getAllByUserId(Long userId);
}