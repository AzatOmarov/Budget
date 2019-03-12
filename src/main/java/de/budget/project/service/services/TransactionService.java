package de.budget.project.service.services;

import de.budget.project.model.transaction.TransactionWebDto;

public interface TransactionService {
    void createTransaction(TransactionWebDto transactionWebDto);
}
