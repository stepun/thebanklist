package com.dev.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.dev.bank.dao.UserDao;
import com.dev.bank.dao.AccountDao;
import com.dev.bank.model.User;
import com.dev.bank.model.Account;

@ContextConfiguration("classpath:spring-context.xml")
public class TestSimpleJdbc extends AbstractJUnit4SpringContextTests {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testAccountCRUD() {
		Integer testDataAccount = 123;
		Double testDataAmount = 123.0;
		Integer userid = 999999999;
		// Создать тестовый объект
		Account testAccount = new Account();
		testAccount.setAccount(testDataAccount);
		testAccount.setAmount(testDataAmount);
		testAccount.setUserid(userid);
		// Сохранить тестовый объект в бд
		accountDao.insert(testAccount);
		// Вытащить тестовый объект из бд
		Account warehouseFromDb = accountDao.findById(testAccount.getAccountid());
		// Сравнить объект из бд с тестовым объектом
		assertEquals(testAccount.getAccountid(), warehouseFromDb.getAccountid());
		// Удалить тестовый объект в базе данных
		accountDao.delete(warehouseFromDb);
		// Найти удаленный объект в бд
		Account removedWarehouse = accountDao.findById(warehouseFromDb.getAccountid());
		// Сравнить объект после удаления из бд на null
		assertNull(removedWarehouse);
	}
	
	@Test
	public void testUserCRUD() {
		String testDataName = "test name";
		String testDataSureName = "test sureName";
		// Создать тестовый объект
		User testUser = new User();
		testUser.setName(testDataName);
		testUser.setSureName(testDataSureName);
		// Сохранить тестовый объект в бд
		userDao.insert(testUser);
		// Вытащить тестовый объект
		User itemFromDb = userDao.findById(testUser.getUserid());
		// Сравнить вытащенный объект с тестовым объектом
		assertEquals(testUser.getName(), itemFromDb.getName());
		assertEquals(testUser.getSureName(), itemFromDb.getSureName());
		// Удалить тестовый объект
		userDao.delete(itemFromDb);
		// Найти удаленный объект
		User removedItem = userDao.findById(itemFromDb.getUserid());
		// Сравнить объект после удаления на null
		assertNull(removedItem);
	}
}