package homework;

public class hw_06_15_WhileGugudan 
{
	public static void main(String[] args)
	{
		int i;			//곱해지는 수
		int j = 1;		//곱하는 수
		int result;		//곱
		
		
		//---------------------------------------------------------------//
		
		while(j <= 9)
		{
			i = 2;
			while(i <= 9)
			{
				result = i * j;
				System.out.print(i + "*" + j + "=" + result + "\t");
				i++;
			}
			System.out.println();
			j++;
		}
	}
}
