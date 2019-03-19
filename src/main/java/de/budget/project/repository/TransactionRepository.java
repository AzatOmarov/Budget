package de.budget.project.repository;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    @Query("select w from Wallet w where w.id = :id")
    List<Transaction> findAllByWalletId(@Param("id") Long id);
}