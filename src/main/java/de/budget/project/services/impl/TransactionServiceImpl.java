package de.budget.project.services.impl;

import de.budget.project.exceptions.TransactionNotFoundException;
import de.budget.project.model.category.Category;
import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionInfo;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.TransactionRepository;
import de.budget.project.repository.WalletRepository;
import de.budget.project.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {

    private List<Transaction> transactions = new ArrayList<>();

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Transaction createTransaction(Float amount, Long walletId, String description, Category category) {
        Wallet wallet = walletRepository.getWalletById(walletId);
        Transaction transaction = new Transaction(amount, wallet, description, category);
        transaction.setAmount(amount);
        transaction.setWallet(wallet);
        transaction.setDescription(description);
        transaction.setCategory(category);
        return transactionRepository.save(transaction);
    }

    @Override
    public TransactionInfo getTransactionById(Long id) {
        Optional<Transaction> byId = transactionRepository.findById(id);
        if(!byId.isPresent()){
            throw new TransactionNotFoundException("Transaction not found " + id );
        }
        Transaction transaction = byId.get();
        return convertToTransactionInfo(transaction);

    }

    @Override
    public List<Transaction> getTransactionsByWalletId(Long walletId) {
        List<Transaction> allByWalletId = transactionRepository.findAllByWalletId(walletId);
        return allByWalletId;
    }

    public TransactionInfo convertToTransactionInfo(Transaction transaction){
        TransactionInfo  transactionInfo = modelMapper.map(transaction, TransactionInfo.class);
        return transactionInfo;
    }
}