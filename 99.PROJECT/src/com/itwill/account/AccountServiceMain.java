package com.itwill.account;


import java.util.ArrayList;

import javax.swing.JOptionPane;
/*
 * 	은행업무를 실행할 클래스
 * 		-계좌관리 업무를 수행하는 클래스
 * 		-Account객체를 사용(의존성관계)
 * 		-AccountServiceMain 에서 사용
 * 		-업무를 처리시 데이터 접근이 필요하면 
 * 			Account Dao 객체를 잉요하여 업무를 실행
 * 		-AccountDao 객체를 [멤버변수로] 포함하고있다
 * 	
 */
public class AccountServiceMain {

	public static void main(String[] args) 
	{
		
		AccountService accountService=new AccountService();
		accountService.a();
		
		
	}
	public void a()
	{
		System.out.println("AccountService.a()");
	}
}













