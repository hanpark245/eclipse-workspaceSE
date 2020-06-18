
public class AccountEncasulationMain 
{
	public static void main(String[] args)
	{
		Account account1 = new Account();
		account1.setAccountData(1111, "Kim", 56000, 0.5);
		account1.deposit(3000);
		//account1.no = 1111;
		//account1.owner = "Kim";
		//account1.balance = 59000;
		//account1.interest = 0.5;
		account1.print();
		
		
		Account account2 = new Account();
		account2.setAccountData(2222, "Lee", 89000, 1);
		account2.withdraw(5600);
		account2.print();
	}	
}
