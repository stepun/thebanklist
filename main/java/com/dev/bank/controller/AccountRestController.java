package com.dev.bank.controller;

import com.dev.bank.model.Account;
import com.dev.bank.service.AccountService;
import com.dev.bank.service.impl.AccountServiceImpl;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class AccountRestController {

    @GetMapping(path = "/getRichestUser", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getRichestUser() {
        List<Account> list;

        String accountJsonString;
        AccountResponseObject responseObject = new AccountResponseObject();

        AccountService as = new AccountServiceImpl();
        try {
            list = as.listAll();
            if (list != null) {
                Account accEntity = list.get(0);
                responseObject.setModel(accEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        accountJsonString = new Gson().toJson(responseObject);

        return new ResponseEntity<Object>(accountJsonString, HttpStatus.OK);
    }

    @GetMapping(path = "/getAccountSum", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAccountSum() {
        List<Account> list;

        String accountJsonString;
        AccountResponseObject responseObject = new AccountResponseObject();

        AccountService as = new AccountServiceImpl();
        try {
            list = as.listAll();
            if (list != null) {
                Double summ = 0.0;
                for (Account acc : list) {
                    summ += acc.getAmount();
                }
                responseObject.setValue(summ.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        accountJsonString = new Gson().toJson(responseObject);
        return new ResponseEntity<Object>(accountJsonString, HttpStatus.OK);
    }
}
