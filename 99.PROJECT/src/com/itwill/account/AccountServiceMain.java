package com.itwill.account;


import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AccountServiceMain {

	public static void main(String[] args) {
		
		AccountService accountService=new AccountService();
		System.out.println("0.AccountService야 은행계좌추가해줘");
		
		
		Account addAccount1=new Account(1000, "고소영",89000, 0.5);
		boolean isAdd = accountService.addAccount(addAccount1);
		if(isAdd) {
			JOptionPane.showMessageDialog(null, "계좌추가 성공!!!");
		}else {
			JOptionPane.showMessageDialog(null, "계좌추가 실패!!!");
			
		}
		
		Account addAccount2=new Account(1000, "고소일",67000, 0.1);
		isAdd = accountService.addAccount(addAccount2);
		if(isAdd) {
			JOptionPane.showMessageDialog(null, "계좌추가 성공!!!");
		}else {
			JOptionPane.showMessageDialog(null, "계좌추가 실패!!!");
			
		}
		System.out.println("1.AccountService야 은행계좌들 총계좌수반환해줘");
		int accountCount = accountService.totAccountNumber();
		System.out.println("총계좌수[main]:"+accountCount);
		
		System.out.println("2.AccountService야 은행계좌들 전체반환해줘");
		ArrayList<Account> accountList=accountService.getAccountList();
		System.out.println(accountList);
		/*
		System.out.println("3.AccountService야 은행계좌들 총잔고 반환해줘");
		int totBalance = accountService.totBalance();
		System.out.println("총잔고[main]:"+totBalance);
		System.out.println("4.AccountService야 계좌번호줄께 계좌한개반환해줘");
		Account findAccount = accountService.findByNo(5555);
		System.out.println("계좌한개[main]");
		findAccount.print();
		System.out.println("5.AccountService야 계좌잔고줄께 잔고이상인 계좌들반환해줘[OPTION]");
		ArrayList<Account> findAccounts=
				accountService.findByBalance(50000);
		System.out.println(" 반환계좌수:"+findAccounts.size());
		System.out.println(findAccounts);
		System.out.println("7.AccountService야 은행계좌들 중에 계좌주이름이 AIM인 계좌들반환해줘");
		System.out.println(accountService.findByName("AIM"));
		
		System.out.println("9.AccountService 야 1111번계좌 50000원 출금해줘");
		try {
			accountService.chulGum(1111, 50000);
			
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			//JOptionPane.showMessageDialog(null,e.getMessage() ,"에러", 1);
		}
		*/
		/*
		 8.6666번계좌 4000원 입금해줘
		*/
		/*
		System.out.println(" 8.6666번계좌 4000원 입금해줘");
		System.out.println(accountService.findByNo(6666));
		accountService.ipGum(6666, 4000);
		System.out.println(accountService.findByNo(6666));
		System.out.println("9.VIP계좌(잔고 70000원이상)들 반환해줘");
		System.out.println(accountService.findByBalance(70000));
		System.out.println("10.계좌를 잔고순으로 오름차순정렬해줘");
		accountService.sortByBalanceAsc();
		accountService.print();
		System.out.println("11.계좌를 잔고순으로 내림차순정렬해줘");
		accountService.sortByBalanceDesc();
		accountService.print();

		System.out.println(" 15-1.6666번계좌의 이름,잔고,이율 수정(update)");
		System.out.println(accountService.findByNo(6666));
		accountService.updateAccount(6666,"XXX",30000,10);
		System.out.println(accountService.findByNo(6666));
		System.out.println(" 15-2.6666번계좌의 이름,잔고,이율 수정(update)");
		Account updateAccount = new Account(6666, "YYY", 900000000, 0.4);
		accountService.updateAccount(updateAccount);
		System.out.println(accountService.findByNo(6666));
		*/
		System.out.println("-----------전체계좌 출력-------------");		
		accountService.print();
		
	}

}













