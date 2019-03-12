package de.budget.project.repository;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction getTransactionById(Long id);

    List<Transaction> getAllByUserId(User user);
}