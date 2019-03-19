package de.budget.project.controller;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebResponse;
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
    public TransactionWebDto createTransaction(@RequestBody TransactionWebDto tWebDto){
        Transaction transactionSaved = transactionService.createTransaction(tWebDto);
        return convertToDto(transactionSaved);
    }

    @GetMapping("/transaction/{id}")
    public TransactionWebResponse getTransactionById(@PathVariable("id") Long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/transactions/wallet/{id}")
    public List <Transaction> transactionsByWalletId(@PathVariable("id") Long walletId){
        return transactionService.getTransactionsByWalletId(walletId);
    }

    private TransactionWebDto convertToDto(Transaction transaction){
        TransactionWebDto transactionWebDto = modelMapper.map(transaction, TransactionWebDto.class);
        return transactionWebDto;
    }

}