package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.service.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/wallet/{id}")
    public Wallet getWalletById(@PathVariable("id") Long id) {
        return walletService.getWalletById(id);
    }

    @GetMapping("/wallet/byUser/{id}")
    public Wallet getWalletByUserId(@PathVariable("id") User user) {
        return walletService.getWalletByUserId(user);
    }
}