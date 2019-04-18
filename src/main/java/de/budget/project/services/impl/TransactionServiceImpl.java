package de.budget.project.services.impl;

import de.budget.project.model.dao.TransactionDAO;
import de.budget.project.model.entites.Transaction;
import de.budget.project.model.types.CategoryType;
import de.budget.project.repository.TransactionRepository;
import de.budget.project.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Long createTransaction(Date customDate,
                                  BigDecimal amount,
                                  Long walletId,
                                  Long categoryId,
                                  String description) {
        Date date = new Date();
        transactionRepository.insertTransaction(customDate, amount, walletId, categoryId, description, date, date);
        return transactionRepository.getLastTransaction();
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
    public List<TransactionDAO> getTransactionsByUserId(Long userId) {
        return transactionRepository.getTransactionsByUserId(userId);
    }

    @Override
    public BigDecimal recalculateBalance(Long walletId) {
        List<Transaction> allTransactions = transactionRepository.getTransactionsByWalletId(walletId);
        BigDecimal debitSum = allTransactions
                .stream()
                .filter(p -> p.getCategory().getCategoryType()
                        .equals(CategoryType.DEBIT))
                .map(Transaction::getAmount)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal(0));

        BigDecimal creditSum = allTransactions
                .stream()
                .filter(p -> p.getCategory().getCategoryType()
                        .equals(CategoryType.CREDIT))
                .map(Transaction::getAmount)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal(0));
        return debitSum.add(creditSum);
    }

    @Override
    public List<TransactionDAO> getTransactionsByIdAndDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(date.concat(" 00:00:01"));
            endDate = sdf.parse(date.concat(" 23:59:59"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<TransactionDAO> transactionDAOS = transactionRepository.getTransactionsByIdAndDate(startDate, endDate);
        return transactionDAOS;
    }
}