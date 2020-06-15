
public class While_use {

	public static void main(String[] args) 
	{
		
		//1~10 사이의 정수출력
		int i = 0;
		while(i < 10)
		{
			int su = i + 1;
			System.out.print(su + ",");
			i++;
		}
		
		System.out.println();
		
		//1~10 사이의 홀수출력
		int j = 0;
		while(j <10)
		{
			int su = j + 1;
			if((su % 2) == 1)
			{
				System.out.print(su + ",");
		
			}
			j++;
		}
		
		System.out.println();
		
		//1~10사이의 정수중 4의배수만출력
		int k = 0;
		while(k < 10) 
		{
			int su = k + 1;
			if((su % 4) == 0)
			{
				System.out.print(su + ",");
			}
			k++;
		}
		
		System.out.println();
		
		//1~10사이의 정수중 3과 4의배수만출력
		int l = 0;
		while(l < 100) 
		{
			if( ((l % 4) ==0) && ((l % 3) == 0) )
			{
				System.out.print(l + ",");
			}
			l++;
		}
		
		System.out.println();

		//QUIZ: 1~2020년 사이의 년도중 윤년만 출력
		int year = 1;
		while(year <= 2020) 
		{
			if(((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0)))
			{
				System.out.print(year + ",");
			}
			year++;
		}
		
		System.out.println();
		
		//QUIZ: 1~100 사이의 정수의합
		int ct = 0;
		int sum = 0;
		while(ct <= 100)
		{
			ct++;
			sum += ct;
			if(ct == 100)
			{
				System.out.println("sum = " + sum);
			}
		}
		
	
		//1~100 홀수합
		ct = 0;
		sum = 0;
		while(ct <= 100)
		{
			ct++;
			if(ct % 2 == 1)
			{
				sum += ct;
			}
			if(ct == 100)
			{
				System.out.println("sum = " + sum);
			}
		}
		
		//1~100 짝수합
		ct = 0;
		sum = 0;
		while(ct <= 100)
		{
			ct++;
			if(ct % 2 == 0)
			{
				sum += ct;
			}
			if(ct == 100)
			{
				System.out.println("sum = " + sum);
			}
		}
		
		
		//문자출력--------------------------------------------------
		char c1 = 'A';
		int count1 = 0;
		while(c1 <= 'Z')
		{
			System.out.print(c1 + "  ");
			c1++;
			count1++;
			if(count1 == 5)
			{
				count1 = 0;
				System.out.println();
			}
		}
		
		System.out.println();
		
		//숫자형문자
		char c2 = '0';
		while(c2 <= '9')
		{
			System.out.print(c2 + "  ");
			c2++;
		}
		
		//한글출력
		
		char c3 = '가';
		int count3 = 0;
		while(c3 <= '힣')
		{
			System.out.print(c3);
			c3++;
			count3++;
			if(count3 == 30)
			{
				count3 = 0;
				System.out.println();
			}
		}
	}
}
