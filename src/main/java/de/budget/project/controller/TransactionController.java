package de.budget.project.controller;

import de.budget.project.model.category.Category;
import de.budget.project.model.categoryType.CategoryType;
import de.budget.project.model.transaction.Transaction;
import de.budget.project.model.transaction.TransactionWebDto;
import de.budget.project.model.transaction.TransactionWebResponse;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.services.CategoryService;
import de.budget.project.services.TransactionService;
import de.budget.project.services.WalletService;
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

    @Autowired
    WalletService walletService;

    @Autowired
    CategoryService categoryService;

    @PostMapping("/transactions")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionWebDto createTransaction(@RequestBody TransactionWebDto transactionWebDto) {
        Transaction transaction = convertToEntity(transactionWebDto);
        Transaction transactionCreated = transactionService.createTransaction(transaction);
        return convertToDto(transactionCreated);
    }

    @GetMapping("/transactions/{id}")
    public TransactionWebResponse getTransactionById(@PathVariable("id") Long id) {
        return convertToWebResponse(transactionService.getTransactionById(id));
    }

    @GetMapping("/transactions/byWallet/{id}")
    public List<TransactionWebResponse> getTransactionsByWalletId(@PathVariable("id") Long walletId) {
        List<Transaction> transactions = transactionService.getTransactionsByWalletId(walletId);
        return convertToListWebResponse(transactions);
    }

    private Transaction convertToEntity(TransactionWebDto transactionWebDto) {
        Wallet wallet = walletService.getWalletById(transactionWebDto.getWalletId());
        Category category = categoryService.getCategoryById(transactionWebDto.getCategoryId());
        return new Transaction(transactionWebDto.getCustomDate(),
                transactionWebDto.getAmount(),
                wallet,
                category,
                transactionWebDto.getDescription());
    }

    private TransactionWebDto convertToDto(Transaction transaction) {
        return modelMapper.map(transaction, TransactionWebDto.class);
    }

    private TransactionWebResponse convertToWebResponse(Transaction transaction) {
        return new TransactionWebResponse(transaction.getAmount(),
                transaction.getDescription(),
                transaction.getCategory().getName(),
                recalculateBalance(transaction.getWallet().getId()));
    }

    private List<TransactionWebResponse> convertToListWebResponse(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(this::convertToWebResponse)
                .collect(Collectors.toList());
    }

    private Float recalculateBalance(Long walletId) {
        List<Transaction> allTransactions = transactionService.getTransactionsByWalletId(walletId);
        Double creditSum = allTransactions
                .stream()
                .filter(p -> p.getCategory()
                        .getCategoryType()
                        .equals(CategoryType.CREDIT))
                .mapToDouble(Transaction::getAmount)
                .sum();
        Float credit = new Float(creditSum);
        Double debitSum = allTransactions
                .stream()
                .filter(p -> p.getCategory()
                        .getCategoryType()
                        .equals(CategoryType.DEBIT))
                .mapToDouble(Transaction::getAmount)
                .sum();
        Float debit = new Float(debitSum);
        return debit - credit;
    }
}