package de.budget.project.controller;

import de.budget.project.model.entites.Wallet;
import de.budget.project.model.types.CurrencyType;
import de.budget.project.model.web.WalletWebRequest;
import de.budget.project.model.web.WalletWebResponse;
import de.budget.project.services.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class WalletController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    WalletService walletService;

    @PostMapping("/wallets")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void createWallet(@RequestBody WalletWebRequest walletWebRequest) {
        walletService.insertWallet(walletWebRequest.getUserId(),
                CurrencyType.findCurrencyByName(walletWebRequest.getCurrencyName()).getId());
    }

    @GetMapping("/wallets/{id}")
    @ResponseBody
    public WalletWebResponse getWalletById(@PathVariable("id") Long id) {
        return convertToWebResponse(walletService.getWalletById(id));
    }

    @GetMapping("/wallets/user/{id}")
    @ResponseBody
    public List<WalletWebResponse> getWalletByUserId(@PathVariable("id") Long userId) {
        List<Wallet> wallets = walletService.getAllByUserId(userId);
        return convertToListWebResponse(wallets);
    }

    private WalletWebResponse convertToWebResponse(Wallet wallet) {
        return modelMapper.map(wallet, WalletWebResponse.class);
    }

    private List<WalletWebResponse> convertToListWebResponse(List<Wallet> wallets) {
        return wallets
                .stream()
                .map(this::convertToWebResponse)
                .collect(Collectors.toList());
    }
}