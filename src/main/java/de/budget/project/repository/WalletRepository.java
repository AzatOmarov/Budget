package de.budget.project.repository;

import de.budget.project.model.entites.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into wallet (USER_ID, CURRENCY_TYPE) values (:userId, :currencyId)", nativeQuery = true)
    void insertWallet(@Param("userId") Long userId, @Param("currencyId") Integer currencyId);

    Wallet getWalletById(Long id);

    List<Wallet> getAllByUserId(Long userId);
}