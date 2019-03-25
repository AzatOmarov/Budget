package de.budget.project.services.impl;

import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.WalletRepository;
import de.budget.project.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet getWalletById(Long id) {
        return walletRepository.getWalletById(id);
    }

    @Override
    public List<Wallet> getAllByUserId(Long userId) {
        return walletRepository.getAllByUserId(userId);
    }
}