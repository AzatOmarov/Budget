package de.budget.project.services;

import de.budget.project.model.category.Category;
import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.model.transaction.TransactionWebResponse;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(TransactionWebDto transactionWebDto);

    TransactionWebResponse getTransactionById(Long id);

    List<Transaction> getTransactionsByWalletId(Long walletId);
}