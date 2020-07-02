package itwill06.service.copy;


public class AccountServiceMain {

	public static void main(String[] args) {
		AccountService accountService=new AccountService();
		
		Account account = new Account(1234,"김남준",124124, 23);
		
		System.out.println("0.Account추가(번호중복체크,배열사이즈증가)");
		accountService.addAccount1(account);
		
		System.out.println("1.AccountService야 은행계좌들 총계좌수출력해줘");
		accountService.totAccountNumberPrint();
		
		System.out.println("2.AccountService야 은행계좌들 전체출력해줘");
		accountService.print();
		
		System.out.println("3.AccountService야은행계좌들 총잔고 출력해줘");
		accountService.totBalancePrint();
		
		System.out.println("4.AccountService야 계좌번호줄께 계좌한개출력해줘");
		accountService.findByNoPrint(6666);
		
		System.out.println("5.AccountService야 계좌잔고줄께 잔고이상인 계좌들출력해줘");
		accountService.findByBalancePrint(54000);
		
		System.out.println("6.AccountService야 계좌이율 인자로줄께 이율이상인 계좌들출력해줘");
		accountService.findByIyulPrint(2);
		
		System.out.println("7.AccountService야 계좌주이름 인자로줄께 계좌주이름과일치하는 계좌들출력해줘");
		accountService.findByNamePrint("KIM");
		
		System.out.println("8.AccountService야 계좌번호,입금할돈 인자로줄께 입금해줘");
		accountService.ipGum(1111, 5000);
		
		System.out.println("9.AccountService야 계좌번호,출금할돈 인자로줄께 출금해줘");
		accountService.chulGum(1111, 5000);
		
		System.out.println("10.AccountService야 계좌를 잔고순으로 오름차순정렬");
		accountService.sortByBalanceAscending();
		accountService.print();
		
		System.out.println("11.AccountService야 계좌를 잔고순으로 내림차순정렬");
		accountService.sortByBalanceDescending();
		accountService.print();
		
		System.out.println("15.AccountService야 계좌객체데이타줄께 이름,잔고,이율 수정(update)해줘");
		accountService.updateAccount(1234, "TEST", 0, 0);
	}

}
