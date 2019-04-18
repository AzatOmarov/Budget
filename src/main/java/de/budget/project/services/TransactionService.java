package de.budget.project.services;

import de.budget.project.model.dao.TransactionDAO;
import de.budget.project.model.entites.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface TransactionService {

    Long createTransaction(Date customDate,
                           BigDecimal amount,
                           Long walletId,
                           Long categoryId,
                           String description);

    Transaction getTransactionById(Long id);

    List<Transaction> getTransactionsByWalletId(Long walletId);

    List<TransactionDAO> getTransactionsByUserId(Long userId);

    BigDecimal recalculateBalance(Long walletId);
    List<TransactionDAO> getTransactionsByIdAndDate(String date);
}