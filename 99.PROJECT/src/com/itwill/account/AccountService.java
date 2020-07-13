package com.itwill.account;
import java.util.ArrayList;
/*
 * 은행업무를 실행할 클래스
 * 	- 계좌관리 비즈니스로직(업무)을 수행하는 클래스
 * 	- Account 객체를 사용(의존성 관계)
 * 	- GUI객체(AccountServiceMainFrame)에서 직접접근(메쏘드호출)하는 클래스
 * 	- AccountDao 객체를 이용하여 업무를 실행
 * 	- AccountDao 객체를 포함하고있다.[멤버변수]
 */

public class AccountService 
{
	
	private AccountDao accountDao;

	public AccountService() 
	{
		accountDao=new AccountDao();
	}
	public void a() 
	{
		System.out.println("AccountService.a()");
		accountDao.a();
	}
	public boolean addAccount(Account newAccount) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<Account> getAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

}

















