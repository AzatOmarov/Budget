package de.budget.project.repository;

import de.budget.project.model.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet getWalletById(Long id);

    List<Wallet> getAllByUserId(Long userId);

    @Query("SELECT w FROM Wallet w WHERE w.user.email = :email")
    List<Wallet> getAllByUserEmail(@Param("email") String email);
}