package de.budget.project.controller;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.model.user.User;
import de.budget.project.service.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public void createTransaction(@RequestBody TransactionWebDto transactionWebDto){
        transactionService.createTransaction(transactionWebDto);
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransactionById(@PathVariable("id") Long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/transaction/byUser/{id}")
    public List<Transaction> getAllByUserId(@PathVariable("id") User user) {
        return transactionService.getAllByUserId(user);
    }
}