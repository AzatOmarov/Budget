package de.budget.project.services;

import de.budget.project.model.category.Category;
import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionInfo;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Float amount, Long walletId, String description, Category category);

    TransactionInfo getTransactionById(Long id);

    List<Transaction> getTransactionsByWalletId(Long walletId);
}