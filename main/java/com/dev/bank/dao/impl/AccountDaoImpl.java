package com.dev.bank.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dev.bank.DataSource;
import com.dev.bank.dao.AccountDao;
import com.dev.bank.model.Account;

@Component
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private DataSource dataSource;
	
	public List<Account> findAll() {
		List<Account> result = new ArrayList<Account>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				setEntity(rs, account);
				result.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataSource.closeConnection(connection);
		}
		return result;
	}

	private void setEntity(ResultSet rs, Account account) throws SQLException {
		account.setAccountid(rs.getInt(Account.ID_COLUMN));
		account.setAccount(rs.getInt(Account.ACCOUNT_COLUMN));
		account.setAmount(rs.getDouble(Account.AMOUNT_COLUMN));
		account.setUserid(rs.getInt(Account.USER_ID_COLUMN));
	}

	public Account findById(Integer id) {
		Account account = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				account = new Account();
				setEntity(rs, account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataSource.closeConnection(connection);
		}
		return account;
	}

	public void insert(Account account) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, account.getAccount());
			statement.setDouble(2, account.getAmount());
			statement.setInt(3, account.getUserid());
			statement.execute();

			ResultSet generatedkeys = statement.getGeneratedKeys();
			if (generatedkeys.next()) {
				account.setAccountid(generatedkeys.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dataSource.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Account account) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
			statement.setInt(1, account.getAccount());
			statement.setDouble(2, account.getAmount());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dataSource.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(Account account) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
			statement.setLong(1, account.getAccountid());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dataSource.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}