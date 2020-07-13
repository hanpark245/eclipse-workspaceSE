package com.itwill.account.test;

import com.itwill.account.Account;
import com.itwill.account.AccountDao;

public class AccountDaoTestMain 
{
	public static void main(String[] args) throws Exception 
	{
		AccountDao accountDao = new AccountDao();
		accountDao.create(new Account(1, "ONE", 123, 1.2));
		accountDao.create(new Account(2, "TWO", 2423, 2.2));
		accountDao.create(new Account(3, "THREE", 25235, 4.2));
		accountDao.create(new Account(4, "FOUR", 124124, 0.2));
		accountDao.create(new Account(5, "FIVE", 2342352, 0.4));
		System.out.println("-----readAll()--------");
		System.out.println(accountDao.readAll());
		System.out.println("-----readOne()--------");
		System.out.println(accountDao.readOne(4));
		
		
	}
}
