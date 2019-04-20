package com.dev.bank.dao;

import java.util.List;
import com.dev.bank.model.Account;

public interface AccountDao {
	public static final String SQL_FIND_ALL = "select * from " + Account.TABLE_NAME;
	public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Account.ID_COLUMN + " = ?";
	public static final String SQL_INSERT = "insert into " + Account.TABLE_NAME + " (" + Account.ACCOUNT_COLUMN + ", " + Account.AMOUNT_COLUMN + ", " + Account.USER_ID_COLUMN + ") values (?, ?, ?)";
	public static final String SQL_UPDATE = "update " + Account.TABLE_NAME + " set " + Account.ACCOUNT_COLUMN + " = ?, " + Account.AMOUNT_COLUMN + " = ? where " + Account.ID_COLUMN + " = ?";
	public static final String SQL_DELETE = "delete from " + Account.TABLE_NAME + " where " + Account.ID_COLUMN + " = ?";

	public List<Account> findAll();
	public Account findById(Integer id);
	public void insert(Account account);
	public void update(Account account);
	public void delete(Account account);
}