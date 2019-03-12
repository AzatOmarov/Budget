package de.budget.project.service.serviceImplementations;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.WalletRepository;
import de.budget.project.service.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet getWalletById(Long id) {
        return walletRepository.getWalletById(id);
    }

    @Override
    public Wallet getWalletByUserId(User user) {
        return walletRepository.getWalletByUserId(user);
    }
}