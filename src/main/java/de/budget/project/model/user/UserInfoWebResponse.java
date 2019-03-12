package de.budget.project.model.user;

import de.budget.project.model.transaction.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class UserInfoWebResponse {

    private String name;
    private String email;
    private Double balance;
    private String currency;
    private List<Transaction> transactions;

    public UserInfoWebResponse() {
    }

    public UserInfoWebResponse(String name, String email, Double balance, String currency, List<Transaction> transactions) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.currency = currency;
        this.transactions = transactions;
    }
}