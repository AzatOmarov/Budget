package de.budget.project.service.services;

import de.budget.project.model.transaction.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);

    Transaction getTransactionById(Long id);

    List<Transaction> getAll();
}