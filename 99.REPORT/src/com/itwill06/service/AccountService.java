package com.itwill06.service;


/*
 * Account객체전체에관련된 업무를 실행할클래스
 * 		1.계좌객체들(Account[]) 을멤버변수로가진다.
 * 		2.계좌객체들을 사용해서 업무실행
 */
 
public class AccountService {
	
	
	
	private Account[] accounts= {
			new Account(1111, "KIM", 89000, 1.3),
			new Account(2222, "AIMDDF", 45000, 2.7),
			new Account(3333, "FIMSD", 89000, 4.7),
			new Account(4444, "XIMSD", 34000, 6.7),
			new Account(5555, "hIM", 78000, 3.7),
			new Account(6666, "KIM", 89000, 5.7),
			new Account(7777, "KIM", 89000, 4.7),
			new Account(8888, "qIMGG", 91000, 1.7),
			new Account(9999, "mIMFF", 12000, 0.7),
	};
	
	/*
	  1.계좌데이타들  인자로받아서 Account[]에추가
	  2.계좌객체를    인자로받아서 Account[]에추가
	*/
	public void addAccount(int no, String owner, int balance, double iyul) {
		Account newAccount = new Account(no, owner, balance, iyul);
		/*
		 * 배열에추가
		 */
		Account[] tempAccounts=new Account[accounts.length+1];
		for (int i = 0; i < accounts.length; i++) {
			tempAccounts[i]=accounts[i];
		}
		tempAccounts[tempAccounts.length-1] =newAccount;
		this.accounts=tempAccounts;
	}
	public void addAccount(Account newAccount) {
		/*
		 * 배열에추가
		 */
		Account[] tempAccounts=new Account[accounts.length+1];
		for (int i = 0; i < accounts.length; i++) {
			tempAccounts[i]=accounts[i];
		}
		tempAccounts[tempAccounts.length-1] =newAccount;
		this.accounts=tempAccounts;
	}
	
	/*
	 1.은행계좌들 총계좌수출력메쏘드정의
	 */
	public void totAccountNumberPrint() {
		System.out.println("은행총계좌수:"+accounts.length);
	}
	/*
	 * 2.은행계좌들 전체출력메쏘드 정의
	 */
	public void print() {
		Account.headerPrint();
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
	}	
	/*
	 1.첫글자 대문자
	 2.5자리로출력
	 3.첫글자이외에는****(4개)
	---------------------------------------
	번호	이름	 잔고	 이율
	---------------------------------------
	1111	K****	 89000	 1.3
	2222	A****	 45000	 2.7
	3333	F****	 23000	 4.7
	4444	X****	 34000	 6.7
	5555	H****	 78000	 3.7
	6666	K****	 99000	 5.7
	7777	K****	 89000	 4.7
	8888	Q****    91000	 1.7
	9999	M****    12000	 0.7
	*/
	/*
	 * 3.은행계좌들 총잔고 출력메쏘드 정의
	 */
	public void totBalancePrint() {
		int totBalance=0;
		for (int i = 0; i < accounts.length; i++) {
			totBalance+=accounts[i].getBalance();
		}
		System.out.println(">>은행계좌총잔고:"+ totBalance);
	}
	/*
	 4.계좌번호 인자로받아서 계좌한개출력
	 */
	public void findByNoPrint(int no) {
		
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo()==no) {
				accounts[i].print();
				break;
			}
		}
		
	}
	
	/*
	 *  5.계좌잔고 인자로 받아서 잔고이상인 계좌들출력
	 */
	 public void findByBalancePrint(int balance) {
		
	 }
	/*
	6.계좌이율 인자로 받아서 이율이상인 계좌들출력
	*/ 
	public void findByIyulPrint(double iyul) {
		
	}
	
	/*
	7.계좌주이름 인자로 받아서 인자이름과동일한 계좌들출력
	 */ 
	public void findByNamePrint(String  name) {
		
	}
	/*
	8.계좌번호,입금할돈 인자로 받아서 입금
	 */ 
	public void ipGum(int no,int money ) {
		
	}
	/*
	9.계좌번호,출금할돈 인자로 받아서 출금
	 */ 
	public void chulGum(int no,int money ) {
		
	}
	/*
	 10.계좌를 잔고순으로 오름차순정렬
	 */
	public void sortByBalanceAscending() {
		
	}
	/*
	 11.계좌를 잔고순으로 내림차순정렬
	 */
	public void sortByBalanceDescending() {
		
	}
	/*
	15.번호,이름,잔고,이율 인자로받아서 계좌객체수정(update)
	*/
	public void updateAccount(int no,String owner,int balance,double iyul) {
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo()==no) {
				accounts[i].setAccountData(no, owner, balance, iyul);
				break;
			}
		}
		
	}
	/*
	15.6666번계좌객체 인자로 받아서 이름,잔고,이율 수정(update)
	*/
	public void updateAccount(Account updateAccount) {
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo()==updateAccount.getNo()) {
				accounts[i]=updateAccount;
				break;
			}
		}
	}
	
	
	
	 
	
	
}
