package itwill06.service;

public class AccountServiceReturn extends Account
{
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
	
	
	//0.AccountService객체야 은행계좌 추가해줘
	public void addAccount1(Account account) 
	{
		Account[] temp = new Account[accounts.length + 1];
		
		for (int i = 0; i < accounts.length; i++) 
		{
			temp[i] = accounts[i];
		}
		
		temp[temp.length - 1] = account;
		
		accounts = temp;
		for (int i = 0; i < temp.length; i++) 
		{
			System.out.println(accounts[i]);
		}
	}
	
	
	//0.AccountService객체야 계좌번호줄께 계좌삭제해줘
	public void deleteAccount1(int account) 
	{
		Account[] temp = new Account[accounts.length - 1];
		int accountDeleted = 0;
		for (int i = 0; i < accounts.length; i++) 
		{
			if(accounts[i].getNo() == account)
			{
				accountDeleted = i;
			}
		}
		for (int i = accountDeleted; i < accounts.length - 1; i++) 
		{
			accounts[i] = accounts[i + 1];	
 		}
		
		for (int i = 0; i < temp.length; i++) 
		{
			temp[i] = accounts[i];
		}
		accounts = temp;
	}
	
	
	//1.AccountService객체야 은행계좌 총계좌수를 반환해줘
	public int totAccountNumber() 
	{
		int count = 0;
		for (int i = 0; i < accounts.length; i++) 
		{
			count++;
		}
		return count;
	}
	
	
	//2.AccountService객체야 은행계좌들 전체출력해줘
	public void print() 
	{
		Account.headerPrint();
		for (int i = 0; i < accounts.length; i++) 
		{
			accounts[i].print();
		}
	}	
	
	//3.AccountService객체야 은행계좌들 총잔고를 반환해줘
	public int totBalance() 
	{
		int totalBal = 0;
		for (int i = 0; i < accounts.length; i++) 
		{
			totalBal += accounts[i].getBalance();
		}
		return totalBal;
	}
	
	
	//4.AccountService객체야 계좌번호(3333번)를인자로 넣어줄께 계좌한개참조변수를 반환해줘
	public Account findByNoAddress(int no) 
	{
		Account address = null;
		for (int i = 0; i < accounts.length; i++) 
		{
			if(no == accounts[i].getNo())
			{
				address = accounts[i];
				break;
			}
		}
		return address;
	}
	
	
	//5.AccountService객체야 계좌잔고(50000원)를 인자로줄께 잔고이상인 계좌객체배열 참조변수반환해줘
	 public Account[] findByBalanceAddress(int balance) 
	 {
		 Account[] address = new Account[accounts.length];
	
		 int count = 0;
		 for (int i = 0; i < accounts.length; i++) 
		 {
			 if(balance <= accounts[i].getBalance())
			 {
				 address[count] = accounts[i];
				 count++;
			 }
		 }
		 Account[] temp = new Account[count];
		 
		 for (int i = 0; i < count;  i++) 
		 {
			 temp[i] = address[i];
		 }
		 
		 address = temp;
		 
		 return address;
	 }
	
	 //6.AccountService객체야  계좌이율(5.0)을 인자로줄께 이율이상인 계좌객체배열 참조변수 반환해줘
	 public Account[] findByInterestAddress(double iyul) 
	 {
		 Account[] address = new Account[accounts.length];
	
		 int count = 0;
		 for (int i = 0; i < accounts.length; i++) 
		 {
			 if(iyul <= accounts[i].getIyul())
			 {
				 address[count] = accounts[i];
				 count++;
			 }
		 }
		 Account[] temp = new Account[count];
		 
		 for (int i = 0; i < count;  i++) 
		 {
			 temp[i] = address[i];
		 }
		 
		 address = temp;
		 
		 return address;
	 }
	 
	 //7.AccountService객체야  계좌주이름(AIM)을 인자로줄께 계좌객체배열 참조변수 반환해줘
	 public Account[] findByNameAddress(String name) 
	 {
		 Account[] address = new Account[accounts.length];
	
		 int count = 0;
		 for (int i = 0; i < accounts.length; i++) 
		 {
			 if(accounts[i].getOwner().equals(name))
			 {
				 address[count] = accounts[i];
				 count++;
			 }
		 }
		 Account[] temp = new Account[count];
		 
		 for (int i = 0; i < count;  i++) 
		 {
			 temp[i] = address[i];
		 }
		 
		 address = temp;
		 
		 return address;
	 }

	 
	 //8.AccountService객체야 계좌번호(6666번)와 입금할돈(4000원)줄께 입금해줘
	public void ipGum(int no,int money ) 
	{
		for (int i = 0; i < accounts.length; i++) 
		{
			if(no == accounts[i].getNo())
			{
				accounts[i].deposit(money);
				Account.headerPrint();
				accounts[i].print();
				break;
			}
		}
	}
	
	
	//9.AccountService객체야 계좌번호(1111번)와 출금할돈(500원)줄께 출금해줘
	public void chulGum(int no,int money ) 
	{
		for (int i = 0; i < accounts.length; i++) 
		{
			if(no == accounts[i].getNo())
			{
				accounts[i].chulGum(money);
				Account.headerPrint();
				accounts[i].print();
				break;
			}
		}
	}
	
	
	//10.AccountService객체야 계좌를 잔고순으로 오름차순정렬해줘
	public void sortByBalanceAscending() 
	{
		for (int i = 0; i < accounts.length - 1; i++) 
		{
			for (int j = 0; j < accounts.length - 1; j++) 
			{
				if(accounts[j].getBalance() > accounts[j + 1].getBalance())
				{
					Account temp;
					temp = accounts[j];
					accounts[j] = accounts[j + 1];
					accounts[j + 1] = temp;
				}
			}
		}	
	}
	
	
	//11.AccountService객체야 계좌를 잔고순으로 내림차순정렬해줘
	public void sortByBalanceDescending() 
	{
		for (int i = 0; i < accounts.length - 1; i++) 
		{
			for (int j = 0; j < accounts.length - 1; j++) 
			{
				if(accounts[j].getBalance() < accounts[j + 1].getBalance())
				{
					Account temp;
					temp = accounts[j];
					accounts[j] = accounts[j + 1];
					accounts[j + 1] = temp;
				}
			}
		}		
	}
	
	
	//13.AccountService객체야 계좌를 예금주이름순(사전순)으로 오름차순정렬
	public void sortByName()
	{
		for (int i = 0; i < accounts.length - 1; i++) 
		{
			for (int j = 0; j < accounts.length - 1; j++) 
			{
				if(0 < accounts[j].getOwner().compareToIgnoreCase(accounts[j + 1].getOwner()))
				{
					Account temp;
					temp = accounts[j];
					accounts[j] = accounts[j + 1];
					accounts[j + 1] = temp;
				}
			}
		}
	}
	
	
	
	//14.AccountService객체야 6666번계좌의 잔고(500),이름(바보),이율(3.2) 수정
	public void updateAccount(int no,String owner,int balance,double iyul) 
	{
		for (int i = 0; i < accounts.length; i++) 
		{
			if(no == accounts[i].getNo())
			{
				accounts[i].setAccountData(no, owner, balance, iyul);
				Account.headerPrint();
				accounts[i].print();
				break;
			}
		}
	}
	 
}

