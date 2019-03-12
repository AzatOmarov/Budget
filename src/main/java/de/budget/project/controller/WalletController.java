package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.user.UserInfoWebResponse;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.service.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    WalletService walletService;

    @GetMapping("/allWallets")
    public List<Wallet> getAllWallets(){
        return walletService.getAllWallets();
    }

    @GetMapping("/findById/{id}")
    public Wallet findWalletById(@PathVariable("id") Long id){
        return walletService.findWalletById(id);
    }

    @GetMapping("/findByUserId/{id}")
    public Wallet findWalletByUserId(@PathVariable ("id") User id){
        return walletService.findWalletByUserId(id);
    }

//    @GetMapping("/getUserInfoByEmail/{email}")
//    public UserInfoWebResponse getUserInfoByEmail(@PathVariable ("email") String email){
//           return walletService.getUserInfoByEmail(email);
//    }

//    @GetMapping("/getUserInfoByEmailThroughEntityManager/{email}")
//    public UserInfoWebResponse getUserInfoByEmailCustom(@PathVariable ("email") String email){
//        return walletService.getUserInfoByEmailCustom(email);
//    }



}
