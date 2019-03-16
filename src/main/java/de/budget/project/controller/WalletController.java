package de.budget.project.controller;

import de.budget.project.model.user.User;
import de.budget.project.model.wallet.Wallet;
import de.budget.project.model.wallet.WalletWebDto;
import de.budget.project.service.services.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class WalletController {

    @Autowired
    WalletService walletService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/wallets")
    public List<Wallet> getAll(){
        return walletService.getAll();
    }

    @GetMapping("/wallets/{id}")
    public Wallet getWalletById(@PathVariable("id") Long id) {
        return walletService.getWalletById(id);
    }

    @GetMapping("/wallets/byUser/{id}")
    public Wallet getWalletByUserId(@PathVariable("id") User user) {
        return walletService.getWalletByUserId(user);
    }

    @PostMapping("/wallets")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public WalletWebDto createWallet(@RequestBody WalletWebDto walletWebDto) throws ParseException {
            Wallet wallet = convertToEntity(walletWebDto);
            Wallet walletSaved = walletService.createWallet(wallet);
            return convertToDto(walletSaved);
    }

    public Wallet convertToEntity(WalletWebDto walletWebDto) throws ParseException {
        Wallet wallet = modelMapper.map(walletWebDto, Wallet.class);
        wallet.setUserId(walletWebDto.getUserId());
        wallet.setCurrency(walletWebDto.getCurrency());
        wallet.setBalance(walletWebDto.getBalance());
        return wallet;
    }

    public WalletWebDto convertToDto(Wallet wallet) {
        WalletWebDto walletWebDto= modelMapper.map(wallet, WalletWebDto.class);
        walletWebDto.setBalance(wallet.getBalance());
        walletWebDto.setCurrency(wallet.getCurrency());
        return walletWebDto;
    }

}