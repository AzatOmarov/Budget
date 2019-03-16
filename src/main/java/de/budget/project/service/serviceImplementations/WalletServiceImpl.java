package de.budget.project.service.serviceImplementations;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.WalletRepository;
import de.budget.project.service.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet getWalletById(Long id) {
        return walletRepository.getWalletById(id);
    }

    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet getWalletByUserId(User user) {
        return walletRepository.getWalletByUserId(user);
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        Wallet walletCreated = new Wallet(wallet.getId(),
                wallet.getUserId(),
                wallet.getBalance(),
                wallet.getCurrency(),
                wallet.getUpdatedDate(),
                wallet.getTransactions()
                );
        walletRepository.save(walletCreated);
        return walletCreated;
    }
}