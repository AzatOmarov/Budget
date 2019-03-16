package de.budget.project.service.serviceImplementations;

import de.budget.project.model.transaction.Transaction;
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
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }


    @Override
    public Transaction createTransaction(Transaction transaction) {
        Transaction transactionSaved = new Transaction(transaction.getId(),
                                    transaction.getAmount(),
                                    transaction.getWalletId(),
                                    transaction.getDescription(),
                                    transaction.getCreatedDate(),
                                    transaction.getUpdatedDate());
        transactionRepository.save(transactionSaved);
        return transactionSaved;
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.getTransactionById(id);
    }

}