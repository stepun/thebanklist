package com.dev.bank.service.impl;

import com.dev.bank.dao.AccountDao;
import com.dev.bank.model.Account;
import com.dev.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Qualifier("accountDaoImpl")
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> listAll() {
        return accountDao.findAll();
    }

    @Override
    public List<Account> getUserAmount(Integer id) {
        return null;
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }
}
