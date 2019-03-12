package de.budget.project.service.services;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;

public interface WalletService {

    Wallet findWalletById(Long walletId);

    Wallet findWalletByUserId(User user);
}