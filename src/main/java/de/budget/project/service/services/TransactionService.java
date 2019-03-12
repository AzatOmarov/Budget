package de.budget.project.service.services;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.model.user.User;

import java.util.List;

public interface TransactionService {

    void createTransaction(TransactionWebDto transactionWebDto);

    Transaction getTransactionById(Long id);

    List<Transaction> getAllByUserId(User user);
}