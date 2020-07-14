package com.itwill.account.test;

import com.itwill.account.Account;
import com.itwill.account.AccountDao;

public class AccountDaoTestMain {

	public static void main(String[] args)throws Exception {
		
		AccountDao accountDao=new AccountDao();
		System.out.println("-----create------");
		/*
		System.out.println(accountDao.create(new Account(11, "ONEONE", 34563478, 0.321)));
		System.out.println(accountDao.create(new Account(2, "TWO", 43534, 0.98)));
		System.out.println(accountDao.create(new Account(3, "THREE", 131, 0.51)));
		System.out.println(accountDao.create(new Account(4, "김소미", 7687, 0.12)));
		System.out.println(accountDao.create(new Account(5, "장하나", 8888, 0.32434)));
		*/
		
		System.out.println("-----readAll------");
		System.out.println(accountDao.readAll());
		System.out.println("-----readOne------");
		System.out.println(accountDao.readOne(5));
		System.out.println("-----update------");
		Account updateAccount = accountDao.readOne(5);
		updateAccount.setOwner("장두나");
		updateAccount.setBalance(1111);
		accountDao.update(updateAccount);
		System.out.println("------delete-----");
		accountDao.delete(11);
		
		System.out.println(accountDao.readAll());
		

	}

}
