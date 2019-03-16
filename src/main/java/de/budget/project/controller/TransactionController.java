package de.budget.project.controller;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.model.user.User;
import de.budget.project.service.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/transactions")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public TransactionWebDto createTransaction(@RequestBody TransactionWebDto transactionWebDto){
        Transaction transaction = convertToEntity(transactionWebDto);
        Transaction transactionSaved = transactionService.createTransaction(transaction);
        return convertToDto(transactionSaved);
    }

    @GetMapping("/transactions/{id}")
    public Transaction getTransactionById(@PathVariable("id") Long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/transactions")
    public List<Transaction> transactions (){
        return transactionService.getAll();
    }

    public Transaction convertToEntity(TransactionWebDto transactionWebDto){
        Transaction transaction = modelMapper.map(transactionWebDto, Transaction.class);
        transaction.setAmount(transactionWebDto.getAmount());
        transaction.setWalletId(transactionWebDto.getWalletId());
        transaction.setDescription(transactionWebDto.getDescription());
        return transaction;
    }
    public TransactionWebDto convertToDto(Transaction transaction){
        TransactionWebDto transactionWebDto = modelMapper.map(transaction, TransactionWebDto.class);
        return transactionWebDto;
    }

}