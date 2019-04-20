package com.dev.bank.dao;

import java.util.List;
import com.dev.bank.model.User;

public interface UserDao {
	public static final String SQL_FIND_ALL = "select * from " + User.TABLE_NAME;
	public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + User.ID_COLUMN + " = ?";
	public static final String SQL_INSERT = "insert into " + User.TABLE_NAME + " (" + User.NAME_COLUMN + ", " + User.SURENAME_COLUMN + ") values (?, ?)";
	public static final String SQL_UPDATE = "update " + User.TABLE_NAME + " set " + User.NAME_COLUMN + " = ?, " +  User.SURENAME_COLUMN + " = ? where " + User.ID_COLUMN + " = ?";
	public static final String SQL_DELETE = "delete from " + User.TABLE_NAME + " where " + User.ID_COLUMN + " = ?";

	public List<User> findAll();
	public User findById(Integer id);
	public void insert(User item);
	public void update(User item);
	public void delete(User item);
}