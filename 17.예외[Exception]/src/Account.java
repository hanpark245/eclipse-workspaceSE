
public class Account {
	/*
	 * 멤버필드
	 */
	private int no;      	//계좌번호
	private String owner;	//계좌주
	private int balance;	//잔고
	private double iyul;	//이율
	/*
	 * 생성자
	 */
	/**
	 * 빈계좌객체생성
	 */
	public Account() {
	}
	/**
	 * 인자로초기화된 계좌객체생성
	 * @param no  계좌번호
	 * @param owner 계좌주
	 * @param balance 계좌잔고
	 * @param iyul 계좌이율
	 */
	public Account(int no,String owner,int balance,double iyul) {
		/*
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
		*/
		this.setAccountData(no, owner, balance, iyul);
	}
	
	/*
	 * 멤버메쏘드
	 */
	/*
	 * 입금
	 */
	public void deposit(int m) {
		this.balance=this.balance+m;
	}
	/*
	 * 출금
	 */
	public boolean withdraw1(int m) {
		boolean isSuccess = false;
		if(this.balance - m < 0)
		{
			isSuccess = false;
		}else
		{
			isSuccess = true;
			this.balance = this.balance-m;
		}
		return isSuccess;
	}
	public void withdraw(int m) throws InsufficientBalanceException 
	{
		if(this.balance - m <0)
		{
			throw new InsufficientBalanceException(this.owner + " 잔고부족");
		}
		this.balance = this.balance - m;
	}
	/*
	 * 
	 */
	public static void headerPrint() {
		System.out.println("-------------------");
		System.out.printf("%s %s %s %s %n","번호","이름","잔고","이율");
		System.out.println("-------------------");
	}
	/*
	 * 계좌정보출력
	 */
	public void print() {
		System.out.printf("%d %s %d %.1f %n",this.no,this.owner,this.balance,this.iyul);
	}
	
	/*
	 * 계좌데이타를 set
	 */
	public void setAccountData(int no,String owner,int balance,double iyul) {
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
	}
	/******getter,setter메쏘드******/
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public double getIyul() {
		return iyul;
	}
	public void setIyul(double iyul) {
		this.iyul = iyul;
	}
	
	
}












