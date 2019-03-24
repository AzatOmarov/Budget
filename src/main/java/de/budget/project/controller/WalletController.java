package de.budget.project.controller;

import de.budget.project.model.wallet.Wallet;
import de.budget.project.model.wallet.WalletWebDto;
import de.budget.project.services.WalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class WalletController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    WalletService walletService;

    @PostMapping("/wallets")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public WalletWebDto createWallet(@RequestBody WalletWebDto walletWebDto) {
        Wallet walletSaved = walletService.createWallet(walletWebDto.getUserId(), walletWebDto.getCurrency());
        return convertToDto(walletSaved);
    }

    @GetMapping("/wallets")
    public List<WalletWebDto> getAll() {
        List<Wallet> wallets = walletService.getAll();
        return convertToListDto(wallets);
    }

    @GetMapping("/wallets/{id}")
    public WalletWebDto getWalletById(@PathVariable("id") Long id) {
        return convertToDto(walletService.getWalletById(id));
    }

    @GetMapping("/wallets/byUser/{id}")
    public List<WalletWebDto> getWalletByUserId(@PathVariable("id") Long userId) {
        List<Wallet> wallets = walletService.getAllByUserId(userId);
        return convertToListDto(wallets);
    }

    @GetMapping("/wallets/byUserEmail/{email}")
    public List<WalletWebDto> getWalletByUserEmail(@PathVariable("email") String email) {
        List<Wallet> wallets = walletService.getAllByUserEmail(email);
        return convertToListDto(wallets);
    }

    private WalletWebDto convertToDto(Wallet wallet) {
        return modelMapper.map(wallet, WalletWebDto.class);
    }

    private List<WalletWebDto> convertToListDto(List<Wallet> wallets) {
        return wallets
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}