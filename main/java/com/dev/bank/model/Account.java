package com.dev.bank.model;

import java.util.HashSet;
import java.util.Set;

public class Account {
	public static final String TABLE_NAME = "account";
	public static final String ID_COLUMN = "accountid";
	public static final String USER_ID_COLUMN = "userid";
	public static final String ACCOUNT_COLUMN = "account";
	public static final String AMOUNT_COLUMN = "amount";

	private Integer accountid;
    private Integer account;
    private Integer userid;
    private Double amount;

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String toString() {
    	return "Account[accountid=" + this.accountid + ", account=" + this.account + ", amount=" + this.amount + ", userid=" + this.userid + "]";
    }
}