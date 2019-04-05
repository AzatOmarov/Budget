package de.budget.project.repository;

import de.budget.project.model.entites.Wallet;
import de.budget.project.model.web.WalletWebResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into WALLET (USER_ID, CURRENCY_TYPE) values (:userId, :currencyId)", nativeQuery = true)
    void insertWallet(@Param("userId") Long userId, @Param("currencyId") Integer currencyId);

    @Query("SELECT new de.budget.project.model.web.WalletWebResponse" +
            " (w.user.id, w.currencyType)" +
            " FROM Wallet w WHERE w.id = :id")
    WalletWebResponse getWalletById(@Param("id") Long id);

    List<Wallet> getWalletsByUserId(Long userId);

    @Query(value = "SELECT * FROM WALLET WHERE ID = (SELECT COUNT(ID) FROM WALLET)", nativeQuery = true)
    Long getLastWallet();
}