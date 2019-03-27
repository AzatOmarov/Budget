package de.budget.project.repository;

import de.budget.project.model.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into wallet (USER_ID, CURRENCY) values (:userId, :currency)", nativeQuery = true)
    void insertWallet(@Param("userId") Long userId, @Param("currency") String currency);

    Wallet getWalletById(Long id);

    List<Wallet> getAllByUserId(Long userId);
}