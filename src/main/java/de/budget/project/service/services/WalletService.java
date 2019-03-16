package de.budget.project.service.services;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;

import java.util.List;

public interface WalletService {

    Wallet getWalletById(Long id);

    List<Wallet> getAll();

    Wallet getWalletByUserId(User user);

    Wallet createWallet(Wallet wallet);
}