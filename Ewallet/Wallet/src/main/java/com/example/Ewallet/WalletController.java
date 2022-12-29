package com.example.Ewallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("/createWallet")
    public ResponseEntity<String> createWallet(@RequestParam  String userName,@RequestParam String password) throws UserAlreadyExistsException {
        walletService.createWallet(userName,password);
        return new ResponseEntity<>("wallet created successfully...", HttpStatus.CREATED);
    }
    @PutMapping("/addAmount")
    public ResponseEntity<String> addWallet(@RequestBody WalletEntryDto walletEntryDto) throws UserNotFoundException {
        walletService.addAmount(walletEntryDto);
        return new ResponseEntity<>("wallet updated successfully",HttpStatus.CREATED);
    }
}
