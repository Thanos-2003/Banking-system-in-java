package com.example.bankapp.service;
import com.example.bankapp.entiy.*;
import com.example.bankapp.exception.*;

import java.util.*;

public interface AccountService {

    boolean addAccount(Account account);
    boolean transferFund(int from, int to ,  double amt) throws AccountException;
    List<Account> viewAccount();
} 