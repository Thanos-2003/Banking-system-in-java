package com.example.bankapp.service;
import com.example.bankapp.dao.AccountDao;
import com.example.bankapp.entiy.*;
import com.example.bankapp.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import jakarta.transaction.Transactional;
@Service("accountser")
@Transactional
public class AccountserviceImpl implements AccountService {
    @Autowired
    private AccountDao dao;
    @Override
    public boolean addAccount(Account account){
        return dao.addAccount(account);
    }
    @Override
    public boolean transferFund(int from, int to, double amt) throws AccountException{ 
        Account fromAccount, toAccount;
        fromAccount = dao.getAccount(from);
        toAccount = dao.getAccount(to);
        if(fromAccount.getBalance()< amt){
            throw new AccountException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance()-amt);
        toAccount.setBalance(toAccount.getBalance() +amt);

        dao.editAccount(fromAccount);
        dao.editAccount(toAccount);
        return true;
    }
    @Override
 //   @Transactional(readOnly =true)
    public List<Account> viewAccount(){
        return dao.getAccounts();
    }
}
