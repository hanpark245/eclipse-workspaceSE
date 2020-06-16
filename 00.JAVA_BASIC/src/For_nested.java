
public class For_nested 
{
	public static void main(String[] args)
	{
		/*
		★★★★★\n
		★★★★★\n
		★★★★★\n
		★★★★★\n
		★★★★★\n
		*/
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				System.out.printf("★ [i = %d, j = %d] ", i , j);
			}
			System.out.print("\n");
		}
		/*
		★★★★★
		★★★★★
		★★★★★
		★★★★★
		★★★★★
		*/
		System.out.println();
		for (int i = 0; i < 5; i++) 
		{
			for(int j = 0; j < 5; j++)
			{
				System.out.print("★");
			}
			System.out.println();
		}
	}
}