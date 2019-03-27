package de.budget.project.controller;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebRequest;
import de.budget.project.model.transaction.TransactionWebResponse;
import de.budget.project.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
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
    public TransactionWebResponse getTransactionById(@PathVariable("id") Long id) {
        return convertToWebResponse(transactionService.getTransactionById(id));
    }

    @GetMapping("/transactions/wallet/{id}")
    public List<TransactionWebResponse> getTransactionsByWalletId(@PathVariable("id") Long walletId) {
        List<Transaction> transactions = transactionService.getTransactionsByWalletId(walletId);
        return convertToListWebResponse(transactions);
    }

    private TransactionWebResponse convertToWebResponse(Transaction transaction) {
        TransactionWebResponse transactionWebResponse = new TransactionWebResponse();
        transactionWebResponse.setAmount(transaction.getAmount());
        transactionWebResponse.setCategoryName(transaction.getCategory().getName());
        transactionWebResponse.setDescription(transaction.getDescription());
        transactionWebResponse.setBalance(transactionService.recalculateBalance(transaction.getWallet().getId()));
        return transactionWebResponse;
    }

    private List<TransactionWebResponse> convertToListWebResponse(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(this::convertToWebResponse)
                .collect(Collectors.toList());
    }
}