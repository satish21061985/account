package com.example.account.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountNumberAlreadyExistException extends RuntimeException {

    private String message;

    public AccountNumberAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
