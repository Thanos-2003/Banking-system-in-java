package com.example.bankapp.dao;
import com.example.bankapp.entiy.*;
import com.example.bankapp.exception.AccountException;

import java.util.List;
public interface AccountDao {
    boolean addAccount(Account account);
    boolean editAccount(Account account);
    Account getAccount(int aid) throws AccountException;
    public List<Account> getAccounts();
}

