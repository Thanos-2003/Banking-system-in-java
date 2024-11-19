package com.example.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import com.example.bankapp.service.AccountService;
import javax.security.auth.login.AccountException;
import jakarta.validation.Valid;

import com.example.bankapp.dto.TransferBean;
import com.example.bankapp.entiy.*;

public class TranferController {
    @Autowired
    private AccountService ser;
    @CrossOrigin
    @GetMapping
    public List<Account> getAccounts(){
        return ser.viewAccount();
    }
    @CrossOrigin
    @PostMapping("/add")
    public String addAccount(@Valid @RequestBody Account account, BindingResult br) throws AccountException{
        String err="";
        if(br.hasErrors()){
            List<FieldError> errors = br.getFieldErrors();
            for(FieldError error:errors)
                err += error.getDefaultMessage()+"<br/>";
            throw new AccountException(err);
        }
        try{
            ser.addAccount(account);
            return "Account Added";
        }catch(DataIntegrityViolationException ex){
            throw new AccountException("ID already exists");
        }
    }
    @CrossOrigin
    @PostMapping("/transfer")
    public String transferAccount(@Valid @RequestBody TransferBean tBean, BindingResult br) throws AccountException, com.example.bankapp.exception.AccountException{
        String err ="";
        if(br.hasErrors()){
            List<FieldError> errors = br.getFieldErrors();
            for(FieldError error: errors)
            err += error.getDefaultMessage()+"<br/>";
            throw new AccountException(err);
        }
        ser.transferFund(tBean.getFromAccountId(), tBean.getToAccountId(), tBean.getAmt());
        return "Amount Transferred";
    }
}

