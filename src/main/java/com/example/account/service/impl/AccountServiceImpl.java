package com.example.account.service.impl;

import com.example.account.exception.AccountNumberAlreadyExistException;
import com.example.account.model.Account;
import com.example.account.repository.AccountRepository;
import com.example.account.service.AccountService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@EnableCaching
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Cacheable(value = "accounts", key = "#accountNumber")
    @Override
    public Account getAccount(Long accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Account createAccount(Account account) {
        Account accountDB = accountRepository.findByAccountNumber(account.getAccountNumber());

        if(accountDB == null) {
            return accountRepository.save(account);
        } else {
            throw new AccountNumberAlreadyExistException("Account already exists");
        }
    }

    @Override
    public Account updateAccount(Account account) {
        Account accountDB = accountRepository.findByAccountNumber(account.getAccountNumber());
        if(Objects.nonNull(accountDB)) {
           if(account.getAccountName() != null) accountDB.setAccountName(account.getAccountName());
           if(account.getUserEmail() != null) accountDB.setUserEmail(account.getUserEmail());
           if(account.getBalance() != null) accountDB.setBalance(account.getBalance());
        }
        return accountRepository.save(accountDB);
    }

    @Override
    public void delete(Long accountNumber) {
        accountRepository.deleteByAccountNumber(accountNumber);
    }
}
