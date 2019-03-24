package de.budget.project.services.impl;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.repository.TransactionRepository;
import de.budget.project.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.getTransactionById(id);
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(Long walletId) {
        return transactionRepository.getTransactionsByWalletId(walletId);
    }
}