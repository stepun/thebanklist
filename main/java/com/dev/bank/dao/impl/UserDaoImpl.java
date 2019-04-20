package com.dev.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dev.bank.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dev.bank.DataSource;
import com.dev.bank.model.User;
import java.sql.Statement;

@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	private DataSource dataSource;

	public List<User> findAll() {
		List<User> result = new ArrayList<User>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				User item = new User();
				item.setUserid(rs.getInt(User.ID_COLUMN));
				item.setName(rs.getString(User.NAME_COLUMN));
				item.setSureName(rs.getString(User.SURENAME_COLUMN));
				result.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataSource.closeConnection(connection);
		}
		return result;
	}

	public User findById(Integer id) {
		User item = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				item = new User();
				item.setUserid(rs.getInt(User.ID_COLUMN));
				item.setName(rs.getString(User.NAME_COLUMN));
				item.setSureName(rs.getString(User.SURENAME_COLUMN));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataSource.closeConnection(connection);
		}
		return item;
	}

	public void insert(User item) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, item.getName());
			statement.setString(2, item.getSureName());
			statement.execute();

			ResultSet generatedkeys = statement.getGeneratedKeys();
			if (generatedkeys.next()) {
				item.setUserid(generatedkeys.getInt(1));
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

	public void update(User item) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_UPDATE);
			statement.setString(1, item.getName());
			statement.setString(2, item.getSureName());
			statement.setInt(3, item.getUserid());
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

	public void delete(User item) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(SQL_DELETE);
			statement.setLong(1, item.getUserid());
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