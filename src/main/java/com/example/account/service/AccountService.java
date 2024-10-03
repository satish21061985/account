package com.example.account.service;

import com.example.account.model.Account;

import java.util.List;

public interface AccountService {

    public List<Account> getAccounts();

    public Account getAccount(Long accountNumber);

    public Account createAccount(Account account);

    public Account updateAccount(Account account);

    public void delete(Long accountNumber);
}
