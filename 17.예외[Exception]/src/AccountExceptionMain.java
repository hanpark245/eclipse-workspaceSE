
public class AccountExceptionMain 
{
	public static void main(String[] args) 
	{
		Account account = new Account(1, "KIM", 5000, 3.2);
		boolean isSuccess = account.withdraw1(10000);
		if(isSuccess)
		{
			System.out.println("출금성공");
		}
		else
		{
			System.out.println("출금실패");
		}
		account.print();
		try 
		{
			account.withdraw(50000);
		}	
		catch(InsufficientBalanceException e)
		{
			System.out.println(e.getMessage());
		}
		account.print();
	
	}
}
