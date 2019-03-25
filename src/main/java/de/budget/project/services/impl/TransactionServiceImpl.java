package de.budget.project.services.impl;

import de.budget.project.model.categoryType.CategoryType;
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

    @Override
    public Float recalculateBalance(Long walletId) {
        List<Transaction> allTransactions = transactionRepository.getTransactionsByWalletId(walletId);
        Double creditSum = allTransactions
                .stream()
                .filter(p -> p.getCategory()
                        .getCategoryType()
                        .equals(CategoryType.CREDIT))
                .mapToDouble(Transaction::getAmount)
                .sum();
        Float credit = new Float(creditSum);
        Double debitSum = allTransactions
                .stream()
                .filter(p -> p.getCategory()
                        .getCategoryType()
                        .equals(CategoryType.DEBIT))
                .mapToDouble(Transaction::getAmount)
                .sum();
        Float debit = new Float(debitSum);
        return debit - credit;
    }
}