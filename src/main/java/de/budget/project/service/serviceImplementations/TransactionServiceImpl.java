package de.budget.project.service.serviceImplementations;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.model.user.User;
import de.budget.project.repository.TransactionRepository;
import de.budget.project.service.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void createTransaction(TransactionWebDto transactionWebDto) {
        Transaction transaction = new Transaction();
        transaction.setDate(transactionWebDto.getDate());
        transaction.setAmount(transactionWebDto.getAmount());
        transaction.setDescription(transactionWebDto.getDescription());
        transaction.setCategoryId(transactionWebDto.getCategory());
        transaction.setUserId(transactionWebDto.getUser());
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.getTransactionById(id);
    }

    @Override
    public List<Transaction> getAllByUserId(User user) {
        return transactionRepository.getAllByUserId(user);
    }
}