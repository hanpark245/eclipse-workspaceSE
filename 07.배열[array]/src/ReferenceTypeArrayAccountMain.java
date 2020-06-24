
public class ReferenceTypeArrayAccountMain 
{

	public static void main(String[] args) 
	{
		Account acc1 = new Account(1111, "KIM", 56800, 0.3);
		Account[] accounts = 
			{
					acc1,
					new Account(2222, "LEE", 56000, 0.9),
					new Account(3333, "PARK", 57000, 1.9),
					new Account(4444, "CHOI", 23000, 2.9),
					new Account(5555, "SUNG", 54000, 4.9),
					new Account(6666, "PYO", 16000, 2.9),
					new Account(7777, "KWON", 53000, 4.1),
					new Account(8888, "HAN", 24000, 3.9),
					new Account(9999, "KANG", 54300, 4.1)
			};
		System.out.println("1.은행총계좌수:" + accounts.length);
		System.out.println("2.은행 전체계좌 출력");
		Account.headerPrint();
		
		for (int i = 0; i < accounts.length; i++) 
		{
			accounts[i].print();
		}
		System.out.println("3.은행계좌들 총잔고");
		int totalBal = 0;
		for (int i = 0; i < accounts.length; i++) 
		{
			totalBal= totalBal + accounts[i].getBalance();
		}
		System.out.println(">>" + totalBal);
		System.out.println("4.은행계좌들중에서 계좌번호 3333번 계좌 한개찾아서 출력");
		for (int i = 0; i < accounts.length; i++) 
		{
			if(accounts[i].getNo() == 3333)
			{
				accounts[i].print();
				break;
			}
		}
		System.out.println("5.은행계좌들중에서 계좌잔고 5만원 이상 찾아서 출력");
		for (int i = 0; i < accounts.length; i++) 
		{
			if(accounts[i].getBalance() >= 50000)
			{
				accounts[i].print();
			}
		}
		System.out.println("6.은행계좌들중에서 계좌이율 이율 2.0이상 계좌들 찾아서 출력");
		for (int i = 0; i < accounts.length; i++) 
		{
			if(accounts[i].getIyul() >= 2.0)
			{
				accounts[i].print();
			}
		}
		System.out.println("7.6666번계좌 3000원 입금");
		for (int i = 0; i < accounts.length; i++) 
		{
			if(accounts[i].getNo()==6666)
			{
				accounts[i].print();
				accounts[i].deposit(3000);
				accounts[i].print();
				break;
			}
		}
		System.out.println("8.9999번계좌 3000원출금");
		for (int i = 0; i < accounts.length; i++) 
		{
			if(accounts[i].getNo()==9999)
			{
				accounts[i].print();
				accounts[i].withdraw(3000);
				accounts[i].print();
				break;
			}
		}
		System.out.println("9.계좌를 잔고순으로 (내림)차순으로 정렬");
		for (int i = 0; i < accounts.length - 1; i++) 
		{
			
			for (int j = 0; j < accounts.length - 1; j++) 
			{
				if(accounts[j].getBalance() > accounts[j + 1].getBalance())
				{
					Account hold = accounts[j+1];
					accounts[j + 1] = accounts[j];
					accounts[j] = hold;
				}
			}
		}
		for (int i = 0; i < accounts.length; i++) 
		{
			accounts[i].print();
		}
		
		System.out.println("10.계좌를 잔고순으로 오름(내림)차순으로 정렬");
		for (int i = 0; i < accounts.length - 1; i++) 
		{
			
			for (int j = 0; j < accounts.length - 1; j++) 
			{
				if(accounts[j].getNo() > accounts[j + 1].getNo())
				{
					Account hold = accounts[j+1];
					accounts[j + 1] = accounts[j];
					accounts[j] = hold;
				}
			}
		}
		
		for (int i = 0; i < accounts.length; i++) 
		{
			accounts[i].print();
		}
		
		
		System.out.println("11.5555계좌의 이율을 3.5로 수정");
		for (int i = 0; i < accounts.length; i++) 
		{
			if (accounts[i].getNo() == 5555)
			{
				accounts[i].setIyul(3.5);
				accounts[i].print();
				break;
			}
		}
		
		System.out.println("12.모든계좌의 잔고 500 증가");
		for (int i = 0; i < accounts.length; i++) 
		{
			accounts[i].setBalance(accounts[i].getBalance() + 500);
			accounts[i].print();
		}

		
		
		
	}

}
