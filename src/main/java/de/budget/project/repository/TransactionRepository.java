package de.budget.project.repository;

import de.budget.project.model.dao.TransactionDAO;
import de.budget.project.model.entites.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, TransactionRepositoryCustom {

    @Transactional
    @Modifying
    @Query(value = "insert into TRANSACTION (CUSTOM_DATE, AMOUNT, WALLET_ID, CATEGORY_ID, DESCRIPTION, CREATED_DATE, UPDATED_DATE) " +
            "values (:customDate, :amount, :walletId, :categoryId, :description, :createdDate, :updatedDate)", nativeQuery = true)
    void insertTransaction(@Param("customDat" +
            "e") Date customDate,
                           @Param("amount") BigDecimal amount,
                           @Param("walletId") Long walletId,
                           @Param("categoryId") Long categoryId,
                           @Param("description") String description,
                           @Param("createdDate") Date createdDate,
                           @Param("updatedDate") Date updatedDate);

    @Query(value = "SELECT * FROM TRANSACTION WHERE ID = (SELECT COUNT(ID) FROM TRANSACTION)", nativeQuery = true)
    Long getLastTransaction();

    Transaction getTransactionById(Long id);

    List<Transaction> getTransactionsByWalletId(Long walletId);

    @Query("SELECT new de.budget.project.model.dao.TransactionDAO" +
            "(t.id, t.customDate, t.amount, w.id, t.category.id, t.description, t.createdDate, t.updatedDate )" +
           "FROM Transaction t JOIN t.wallet w WHERE t.wallet.id = w.id AND t.wallet.user.id = :id")
     List<TransactionDAO> getTransactionsByUserId(@Param("id") Long id);
}