package de.budget.project.repository;

import de.budget.project.model.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Query("SELECT new de.budget.project.model.wallet.Wallet" +
            "(w.user.id, w.currency)" +
            "FROM Wallet w WHERE w.user.id = :userId")
    Wallet createWallet(@RequestParam("userId") Long userId, String currency);

    Wallet getWalletById(Long id);

    List<Wallet> getAllByUserId(Long userId);
}