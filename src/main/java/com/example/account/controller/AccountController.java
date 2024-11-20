package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("accounts")
    ResponseEntity<List<Account>> getAccounts(){
        return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
    }

    @GetMapping("account/{accountNumber}")
    ResponseEntity<Account> getAccount(@PathVariable Long accountNumber){
        return new ResponseEntity<>(accountService.getAccount(accountNumber), HttpStatus.OK);
    }

    @PostMapping("account")
    ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("account")
    ResponseEntity<Account> updateAccount(@RequestBody Account account){
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }

    @DeleteMapping("account/{accountNumber}")
    void deleteAccount(@PathVariable Long accountNumber) {
        accountService.delete(accountNumber);
    }

}
