package com.itwill07.collection;


import java.util.ArrayList;

/*
 * Account객체전체에관련된 업무를 실행할클래스
 */
public class AccountServiceArrayList {
	private ArrayList<Account> accountList;
	public AccountServiceArrayList() {
		accountList=new ArrayList<Account>();
		accountList.add(new Account(1111, "KIM", 89000, 1.3));
		accountList.add(new Account(2222, "AIM", 45000, 2.7));
		accountList.add(new Account(3333, "FIM", 23000, 4.7));
		accountList.add(new Account(4444, "XIM", 34000, 6.7));
		accountList.add(new Account(5555, "HIM", 78000, 3.7));
		accountList.add(new Account(6666, "AIM", 99000, 5.7));
		accountList.add(new Account(7777, "PIM", 89000, 4.7));
		accountList.add(new Account(8888, "QIM", 91000, 1.7));
		accountList.add(new Account(9999, "MIM", 12000, 0.7));
	}
	/*
	private Account[] accounts= {
			new Account(1111, "KIM", 89000, 1.3),
			new Account(2222, "AIM", 45000, 2.7),
			new Account(3333, "FIM", 23000, 4.7),
			new Account(4444, "XIM", 34000, 6.7),
			new Account(5555, "HIM", 78000, 3.7),
			new Account(6666, "AIM", 99000, 5.7),
			new Account(7777, "PIM", 89000, 4.7),
			new Account(8888, "QIM", 91000, 1.7),
			new Account(9999, "MIM", 12000, 0.7),
	};
	*/
	/*
	 * 계좌전체반환
	 */
	public ArrayList<Account>  getAccountList() {
		return accountList;
	}
	/*
	 * 계좌추가
	 */
	public void addAccount(Account account) 
	{
		accountList.add(account);
	}
	/*
	 * 계좌번호로 계좌삭제
	 */
	public void deleteByAccountNo(int no) 
	{
		for (int i = 0; i < accountList.size() - 1; i++)
		{
			if(accountList.get(i).getNo() == no)
			{
				accountList.remove(i);
				break;
			}	
		}
		
	}
	/*
	 1.은행계좌들 총계좌수반환메쏘드정의
	 */

	public int totAccountNumber() 
	{
		return accountList.size();	
	}
	/*
	 * 2.은행계좌들 전체출력메쏘드정의
	 */
	public void print() {
		for (int i = 0; i < accountList.size(); i++) {
			Account tempAccount=accountList.get(i);
			tempAccount.print();
		}
	}
	/*
	 * 3.은행계좌들 총잔고 반환메쏘드 정의
	 */
	public int totBalance(){
		int totBalance=0;
		for(int i = 0; accountList.size() > i; i++)
		{
			totBalance += accountList.get(i).getBalance();
		}
		return totBalance;
	}
	/*
	 4.계좌번호 인자로받아서 인계좌한개반환메쏘드정의
	 */
	public Account findByNo(int no) {
		Account findAccount=null;
		
		for(int i = 0; accountList.size() > i; i++)
		{
			if(accountList.get(i).getNo() == no)
			{
				findAccount = accountList.get(i);
			}
		}
		return findAccount;
	}
	/*
	 *  5.계좌잔고 인자로 받아서 잔고이상인 계좌들반환
	 */
	public ArrayList<Account> findByBalance(int balance) {
		ArrayList<Account> findAccountList=new ArrayList<Account>();
	
		for(int i = 0; accountList.size() > i; i++)
		{
			if(accountList.get(i).getBalance() >= balance)
			{
				findAccountList.add(accountList.get(i));
			}
		}
		return findAccountList;
	}
	
	/*
	 *  8.6666번계좌 4000원 입금
	 */
	public void ipGum(int no,int m) 
	{
		for (int i = 0; i < accountList.size(); i++) 
		{
			if(accountList.get(i).getNo() == no)
			{
				accountList.get(i).deposit(m);
			}
		}
	}
	/*
	 *  9.1111번계좌 5000원 출금
	 */
	public void chulGum(int no,int m) throws InsufficientBalanceException
	{
		for (int i = 0; i < accountList.size(); i++) 
		{
			if(accountList.get(i).getNo() == no)
			{
				accountList.get(i).withdraw(m);
			}
		}
	}
	/*
	 7.은행계좌들 중에 계좌주이름이 AIM인 계좌들반환
	*/
	public ArrayList<Account> findByName(String owner) {
		ArrayList<Account> findAccountList=new ArrayList<Account>();
		for (int i = 0; i < accountList.size(); i++) 
		{
			if (accountList.get(i).getOwner() == owner) 
			{
				findAccountList.add(accountList.get(i));
			}
		}
		return findAccountList;
	}
	/*
	 9.VIP계좌(잔고 70000원이상)들 반환
	 */
	public ArrayList<Account> findByVip(int  balance) {
		ArrayList<Account> findAccountList=new ArrayList<Account>();
		for (int i = 0; i < accountList.size(); i++) 
		{
			if (accountList.get(i).getBalance() >= 70000) 
			{
				findAccountList.add(accountList.get(i));
			}
		}
		return findAccountList;
	}
	/*
	 10.계좌를 잔고순으로 오름차순정렬
	*/
	public void sortByBalanceAsc() 
	{
		
		Account temp = new Account();
		for (int i = 0; i < accountList.size() - 1; i++) 
		{
			for (int j = 0; j < accountList.size() - 1; j++) 
			{
				if (accountList.get(j).getBalance() > accountList.get(j + 1).getBalance()) 
				{
					temp = accountList.get(j + 1);
					accountList.set(j + 1, accountList.get(j));
					accountList.set(j, temp);
				}
			}
		}
	}
	/*
	 11.계좌를 잔고순으로 내림차순정렬
	 */
	public void sortByBalanceDesc() 
	{
		Account temp = new Account();
		for (int i = 0; i < accountList.size() - 1; i++) 
		{
			for (int j = 0; j < accountList.size() - 1; j++) 
			{
				if (accountList.get(j).getBalance() < accountList.get(j + 1).getBalance()) 
				{
					temp = accountList.get(j + 1);
					accountList.set(j + 1, accountList.get(j));
					accountList.set(j, temp);
				}
			}
		}
	}
	
	/*
	 * 
	 15.6666번계좌의 이름,잔고,이율 수정(update)
	 15.6666번계좌의 이름,잔고,이율 수정(update)
	 15.6666번계좌의 이름,잔고,이율 수정(update)
	 */
	public void updateAccount(int no,String owner,int balance,double iyul) 
	{
		for (int i = 0; i < accountList.size(); i++) 
		{
			if(no == accountList.get(i).getNo())
			{
				accountList.set(i, new Account(no,owner,balance,iyul));	
			}
		}
	}
	
	public void updateAccount(Account updateAccount) 
	{
		for (int i = 0; i < accountList.size(); i++) 
		{
			if(updateAccount.getNo() == accountList.get(i).getNo())
			{
				accountList.set(i, updateAccount);	
			}
		}	
	}
	
	
}















