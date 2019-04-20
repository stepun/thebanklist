package com.dev.bank.service;

import com.dev.bank.model.Account;

import java.util.List;

public interface AccountService {
    public List<Account> listAll();
    public List<Account> getUserAmount(Integer id);
    public Account findById(Integer id);
}
