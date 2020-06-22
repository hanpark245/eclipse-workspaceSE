
public class AccountConstructorMain 
{
	public static void main(String[] args)
	{
		Account account1 = new Account(1111, "KIM", 56000, 0.8);
		Account account2 = new Account(2222, "LIM", 45000, 1.8);
		Account account3 = new Account(3333, "FIM", 23000, 0.7);
		Account account4 = new Account(4444, "DIM", 11000, 0.2);
		Account account5 = new Account(5555, "SIM", 77000, 3.8);
		Account account6 = new Account();								
		account6.setAccountData(6666, "SIM", 90000, 1.2);
		
		account1.deposit(1000);
		account2.deposit(1000);
		account3.deposit(1000);
		account4.deposit(1000);
		account5.deposit(1000);
		account6.deposit(1000);
		
		account1.headerPrint();
		
		account1.print();
		account2.print();
		account3.print();
		account4.print();
		account5.print();
		account6.print();
	}	
}
