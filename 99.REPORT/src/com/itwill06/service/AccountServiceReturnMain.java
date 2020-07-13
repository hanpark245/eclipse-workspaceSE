package com.itwill06.service;



public class AccountServiceReturnMain {

	public static void main(String[] args) {
		AccountServiceReturn accountServiceReturn = new AccountServiceReturn();
		System.out.println("0.AccountService객체야 은행계좌 추가해줘");
		Account newAccount = new Account(9090, "구공탄",8989, 0.8);
		//accountService.addAccount(newAccount);
		newAccount = new Account(7878, "CHIL",8000, 0.3);
		//accountService.addAccount(newAccount);
		System.out.println("0.AccountService객체야 계좌번호줄께 계좌삭제해줘");
		//accountService.deleteAccount(7878);
		System.out.println("1.AccountService객체야 은행계좌 총계좌수를 반환해줘");
		int accountNo = accountServiceReturn.getAccountNumber();
		System.out.println(">>>> 총계좌수:" + accountNo);
		System.out.println("2.AccountService객체야 은행계좌들 전체출력해줘");
		accountServiceReturn.print();
		System.out.println("3.AccountService객체야 은행계좌들 총잔고를 반환해줘");
		int tot =accountServiceReturn.getAccountTotalBalance();
		System.out.println(">>>> 총잔고:" + tot);
		System.out.println("4.AccountService객체야 계좌번호(3333번)를인자로 넣어줄께 계좌한개참조변수를 반환해줘");
		Account findAccount=accountServiceReturn.findByNo(3333);
		findAccount.print();
		findAccount=accountServiceReturn.findByNo(5555);
		findAccount.print();
		System.out.println("5.AccountService객체야 "
			+ "계좌잔고(50000원)를 인자로줄께 잔고이상인 계좌객체배열 참조변수반환해줘");
		Account[] findAccounts = accountServiceReturn.findByBalance(50000);
		
		System.out.println("6.AccountService객체야  계좌이율(5.0)을 인자로줄께 이율이상인 계좌객체배열 참조변수 반환해줘");
		System.out.println("7.AccountService객체야  계좌주이름(AIM)을 인자로줄께 계좌객체배열 참조변수 반환해줘");
		System.out.println("8.AccountService객체야 "
				+ "계좌번호(6666번)와 입금할돈(4000원)줄께 입금해줘");
		accountServiceReturn.ipGum(6666, 4000);
		//accountServiceReturn.findByNo(6666);
		
		System.out.println("9.AccountService객체야 계좌번호(1111번)와 출금할돈(500원)줄께 출금해줘");
		System.out.println("10.AccountService객체야 계좌를 잔고순으로 오름차순정렬해줘");
		accountServiceReturn.sortByBalance(AccountServiceReturn.ASCENDING);
		accountServiceReturn.print();
		System.out.println("11.AccountService객체야 계좌를 잔고순으로 내림차순정렬해줘");
		accountServiceReturn.sortByBalance(AccountServiceReturn.DESCENDING);
		accountServiceReturn.print();
		System.out.println("13.AccountService객체야 계좌를 예금주이름순(사전순)으로 오름차순정렬");
		System.out.println("14.AccountService야 계좌객체데이타줄께 이름,잔고,이율 수정(update)해줘");
		
	}

}
