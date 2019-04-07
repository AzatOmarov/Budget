package de.budget.project.controller;

import de.budget.project.model.entites.Transaction;
import de.budget.project.model.web.TransactionWebRequest;
import de.budget.project.model.web.TransactionWebResponse;
import de.budget.project.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(@RequestBody TransactionWebRequest transactionWebRequest) {
        transactionService.insertTransaction(transactionWebRequest.getCustomDate(),
                transactionWebRequest.getAmount(),
                transactionWebRequest.getWalletId(),
                transactionWebRequest.getCategoryId(),
                transactionWebRequest.getDescription());
    }

    @GetMapping("/transactions/{id}")
    @ResponseBody
    public TransactionWebResponse getTransactionById(@PathVariable("id") Long id) {
        return convertToWebResponse(transactionService.getTransactionById(id));
    }

    @GetMapping("/transactions/wallet/{id}")
    @ResponseBody
    public List<TransactionWebResponse> getTransactionsByWalletId(@PathVariable("id") Long walletId) {
        List<Transaction> transactions = transactionService.getTransactionsByWalletId(walletId);
        return convertToListWebResponse(transactions);
    }

    private TransactionWebResponse convertToWebResponse(Transaction transaction) {
        TransactionWebResponse transactionWeBResponse = new TransactionWebResponse();
        transactionWeBResponse.setAmount(transaction.getAmount());
        transactionWeBResponse.setCategoryName(transaction.getCategory().getName());
        transactionWeBResponse.setDescription(transaction.getDescription());
        transactionWeBResponse.setBalance(transactionService.recalculateBalance(transaction.getWallet().getId()));
        return transactionWeBResponse;
    }

    private List<TransactionWebResponse> convertToListWebResponse(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(this::convertToWebResponse)
                .collect(Collectors.toList());
    }
}