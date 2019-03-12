package de.budget.project.service.serviceImplementations;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.repository.TransactionRepository;
import de.budget.project.service.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void createTransaction(TransactionWebDto transactionWebDto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionWebDto.getAmount());
        transaction.setDescription(transactionWebDto.getDescription());
        transaction.setCategoryId(transactionWebDto.getCategoryId());
        transactionRepository.save(transaction);

    }
}
