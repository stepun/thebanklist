package com.dev.bank.controller;

import com.dev.bank.model.Account;

public class AccountResponseObject extends AbstractResponseObject<Account>  {
    public AccountResponseObject () {
        this.setStatus(this.getStatus());
    }
}
