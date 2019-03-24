package de.budget.project.services.impl;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.WalletRepository;
import de.budget.project.services.UserService;
import de.budget.project.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    UserService userService;

    @Override
    public Wallet createWallet(Long userId, String currency) {
        User user = userService.getUserById(userId);
        Wallet wallet = new Wallet(user, currency);
        return walletRepository.save(wallet);
    }

    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet getWalletById(Long id) {
        return walletRepository.getWalletById(id);
    }

    @Override
    public List<Wallet> getAllByUserId(Long userId) {
        return walletRepository.getAllByUserId(userId);
    }

    @Override
    public List<Wallet> getAllByUserEmail(String email) {
        return walletRepository.getAllByUserEmail(email);
    }
}