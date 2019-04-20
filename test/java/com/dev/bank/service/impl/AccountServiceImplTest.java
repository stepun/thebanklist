package com.dev.bank.service.impl;

import com.dev.bank.dao.AccountDao;
import com.dev.bank.model.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.List;

@ContextConfiguration("classpath:spring-context.xml")
public class AccountServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void listAll() {
        List<Account> list = accountDao.findAll();
        for (Account entity: list) {
            System.out.println(entity.toString());
        }
    }
}