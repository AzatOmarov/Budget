package de.budget.project.repository;

import de.budget.project.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into transaction (CUSTOM_DATE, AMOUNT, WALLET_ID, CATEGORY_ID, DESCRIPTION, CREATED_DATE, UPDATED_DATE) " +
            "values (:customDate, :amount, :walletId, :categoryId, :description)", nativeQuery = true)
    void insertTransaction(@Param("customDate") Date customDate,
                           @Param("amount") BigDecimal amount,
                           @Param("walletId") Long walletId,
                           @Param("categoryId") Long categoryId,
                           @Param("description") String description,
                           @Param("customDate") Date createdDate,
                           @Param("customDate") Date updatedDate);

    Transaction getTransactionById(Long id);

    List<Transaction> getTransactionsByWalletId(Long walletId);
}