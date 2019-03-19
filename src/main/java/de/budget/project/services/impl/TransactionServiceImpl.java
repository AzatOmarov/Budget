package de.budget.project.services.impl;

import de.budget.project.exceptions.TransactionNotFoundException;
import de.budget.project.model.category.Category;
import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.model.transaction.TransactionWebResponse;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.repository.CategoryRepository;
import de.budget.project.repository.TransactionRepository;
import de.budget.project.repository.WalletRepository;
import de.budget.project.services.CategoryService;
import de.budget.project.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Transaction createTransaction(TransactionWebDto transactionWebDto) {
//        Category category1 = categoryService.createCategory(CategoryType.getCategoryTypeByName(transactionWebDto.getCategoryId()));
        Wallet wallet = walletRepository.getWalletById(transactionWebDto.getWalletId());
        Category category1 = categoryRepository.getOne(transactionWebDto.getCategoryId());
        Transaction transaction = new Transaction(transactionWebDto.getAmount(),
                                  wallet,
                                  transactionWebDto.getDescription(),
                                  category1);
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public TransactionWebResponse getTransactionById(Long id) {
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

    private TransactionWebResponse convertToTransactionInfo(Transaction transaction){
        TransactionWebResponse transactionWebResponse = modelMapper.map(transaction, TransactionWebResponse.class);
        return transactionWebResponse;
    }
}