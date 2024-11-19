package com.example.bankapp.controller;

import javax.security.auth.login.AccountException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.bankapp.dto.ErrorInfo;
@RestControllerAdvice
public class AccountAdvice {
    @ExceptionHandler(value= {AccountException.class})
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ErrorInfo handleException3(Exception ex){
        return new ErrorInfo(ex.getMessage());
    }
}
