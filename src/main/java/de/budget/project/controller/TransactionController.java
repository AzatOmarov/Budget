package de.budget.project.controller;

import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.service.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/create")
    public void createTransaction(@RequestBody TransactionWebDto transactionWebDto){
        transactionService.createTransaction(transactionWebDto);
    }
}
