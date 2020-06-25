
public class Account 
{
	//멤버필드
	private int no;				//계좌번호
	private String owner;		//계좌주
	private int balance;		//잔고
	private double interest;	//이율
	
	//생성자를 추가합니다
	public Account() 
	{
		
	}
	
	
	/**
	 *  @param no		//계좌번호
	 *  @param owner	//계좌주
	 *  @param balance	//잔고
	 *  @param interest	//이율
	 */
	public Account(int no, String owner, int balance, double interest) 
	{
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.interest = interest;
	}
	//멤버메쏘드
	
	//입금
	public void deposit(int m) 
	{
		this.balance = this.balance + m;
	}
	
	//출금
	public void withdraw(int m)
	{
		this.balance = this.balance - m;
	}
	
	//계좌데이터 set
	public void setAccountData(int no, String owner, int balance, double interest)
	{
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.interest = interest;		
	}
		
	//--------------------GETTER SETTER----------------------
	public int getNo() 
	{
		return no;
	}

	public void setNo(int no) 
	{
		this.no = no;
	}

	public String getOwner() 
	{
		return owner;
	}

	public void setOwner(String owner) 
	{
		this.owner = owner;
	}

	public int getBalance() 
	{
		return balance;
	}

	public void setBalance(int balance) 
	{
		this.balance = balance;
	}

	public double getInterest() 
	{
		return interest;
	}

	public void setInterest(double interest) 
	{
		this.interest = interest;
	}

	/*
	 * 
	 */
	public void headerPrint()
	{
		System.out.println("-------------------------");
		System.out.printf("%s %s %s %s %n", "번호", "이름", "잔고", "이율");
		System.out.println("-------------------------");
	}
	
	//계좌정보출력
	public void print()
	{
		System.out.printf("%d %s %d %6.1f\n", this.no, this.owner, this.balance, this.interest);
	}

	
}
