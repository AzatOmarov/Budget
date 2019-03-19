package de.budget.project.controller;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionInfo;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.services.TransactionService;
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
    public TransactionWebDto createTransaction(@RequestBody TransactionWebDto tWeb){
        Transaction transactionSaved = transactionService.createTransaction(tWeb.getAmount(), tWeb.getWalletId(), tWeb.getDescription(), tWeb.getCategory());
        return convertToDto(transactionSaved);
    }

    @GetMapping("/transaction/{id}")
    public TransactionInfo getTransactionById(@PathVariable("id") Long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/transactions/{id}")
    public List <Transaction> transactionsByWalletId(@PathVariable("id") Long walletId){
        return transactionService.getTransactionsByWalletId(walletId);
    }

    public Transaction convertToEntity(TransactionWebDto transactionWebDto){
        Transaction transaction = modelMapper.map(transactionWebDto, Transaction.class);
        //transaction.setAmount(transactionWebDto.getAmount());
        //transaction.setWallet(transactionWebDto.getWallet());
        //transaction.setDescription(transactionWebDto.getDescription());
        return transaction;
    }
    public TransactionWebDto convertToDto(Transaction transaction){
        TransactionWebDto transactionWebDto = modelMapper.map(transaction, TransactionWebDto.class);
        return transactionWebDto;
    }

}