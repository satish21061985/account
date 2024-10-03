package com.example.account.exception;

import com.example.account.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AccountNumberAlreadyExistException.class)
    //@ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleException(AccountNumberAlreadyExistException ex) {
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
