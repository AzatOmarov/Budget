package de.budget.project.controller;

import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebRequest;
import de.budget.project.model.transaction.TransactionWebDto;
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
    public TransactionWebDto getTransactionById(@PathVariable("id") Long id) {
        return convertToWebDto(transactionService.getTransactionById(id));
    }

    @GetMapping("/transactions?wallet={id}")
    public List<TransactionWebDto> getTransactionsByWalletId(@PathVariable("id") Long walletId) {
        List<Transaction> transactions = transactionService.getTransactionsByWalletId(walletId);
        return convertToListWebDto(transactions);
    }

    private TransactionWebDto convertToWebDto(Transaction transaction) {
        TransactionWebDto transactionWebDto = new TransactionWebDto();
        transactionWebDto.setAmount(transaction.getAmount());
        transactionWebDto.setCategoryName(transaction.getCategory().getName());
        transactionWebDto.setDescription(transaction.getDescription());
        transactionWebDto.setBalance(transactionService.recalculateBalance(transaction.getWallet().getId()));
        return transactionWebDto;
    }

    private List<TransactionWebDto> convertToListWebDto(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(this::convertToWebDto)
                .collect(Collectors.toList());
    }
}