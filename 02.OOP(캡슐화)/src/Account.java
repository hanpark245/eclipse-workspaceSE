
public class Account 
{
	//멤버필드
	private int no;				//계좌번호
	private String owner;		//계좌주
	private int balance;		//잔고
	private double interest;	//이율
	
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
	void setAccountData(int no, String owner, int balance, double interest)
	{
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.interest = interest;		
	}
	
	//계좌정보출력
	public void print()
	{
		System.out.printf("%d %s %d %6.1f\n", this.no, this.owner, this.balance, this.interest);
	}
	
}
