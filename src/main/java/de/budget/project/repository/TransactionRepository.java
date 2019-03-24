package de.budget.project.repository;

import de.budget.project.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction getTransactionById(Long id);

    List<Transaction> getTransactionsByWalletId(Long walletId);
}