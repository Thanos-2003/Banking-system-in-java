package com.example.bankapp.dao;
import com.example.bankapp.entiy.*;
import com.example.bankapp.exception.AccountException;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
@Repository("accdao") 
public class AccountDaoImpl implements AccountDao {
    private EntityManager em;
    public boolean addAccount(Account account){
        em.persist(account);
        return true;
    }
    public boolean editAccount(Account account){
        em.merge(account);
        return true;
    }
    public Account getAccount(int aid) throws AccountException {
        Account account = em.find(Account.class, aid);
        if(account==null) throw new AccountException("Account Id not exists");
        return account;
    }
    public List<Account> getAccounts(){ 
     TypedQuery<Account> query = em.createQuery("from Account", Account.class);
     return query.getResultList();
    }
}
