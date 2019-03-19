package de.budget.project.services.impl;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.UserRepository;
import de.budget.project.repository.WalletRepository;
import de.budget.project.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    UserRepository userRepository;



    @Override
    public Wallet getWalletById(Long id) {
        return walletRepository.getWalletById(id);
    }

    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet getWalletByUserId(User user) {
        return walletRepository.getWalletByUserId(user.getId());
    }

    @Override
    public Wallet createWallet(Long userId, String currency) {
        Wallet wallet = new Wallet();
        wallet.setUser(userRepository.getOne(userId));
        wallet.setCurrency(currency);
        return walletRepository.save(wallet);
    }
}