/*-----------------------------------------------------------------
흐름제어문

   1. if 문
       -형식 : 
	      stmt0;
		  if(조건문 ){
		      //조건문 -->   논리형데이타가 반환되는 연산 
			  //                   혹은 논리형상수
			  stmt1;
		   }else{
		      stmt2;
		   }
		   stmt3;

		   조건데이타가 true인경우  stmt0-->stmt1-->stmt3;
		   조건데이타가 false인경우  stmt0-->stmt2-->stmt3;  
-------------------------------------------------------------------*/
public class if_test 
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		/*////////////////////////////////////////////////////////////
		int a = 0;
	
		if(a == 1)
		{
			a = 2;
		}
		else if(a == 3) 
		{
			a = 2;
		}
		else
		{
			a = 5;
		}
		System.out.println(a);
		/////////////////////////////////////////////////////////////*/
		
		System.out.println("stmt0");
		if(true)
		{
			System.out.println("stmt1-1");
		} 
		else
		{
			System.out.println("stmt1-2");
		}
		//////////////////////////////////////////////////////////////
		System.out.println("stmt0");
		
		boolean condition = false;
		if(condition)
		{
			System.out.println("stmt2-1");
		} 
		else
		{
			System.out.println("stmt2-2");
	
		}
		//////////////////////////////////////////////////////////////
		int x = 21;
		int y = 30;
		
		if(x > y) 
		{
			System.out.println("stmt3-1: x > y");
		}
		else
		{
			System.out.println("stmt3-2: x <= y");
		}
		/////////////////////////////////////////////////////////////
		if(x < y)
		{
			System.out.println("stmt4: x < y");
		}
		if(x == y)
		{
			System.out.println("stmt5: x = y");
		}
		else
		{
			System.out.println("stmt99");
		}
		System.out.println("--------------지역변수의 범위-------------");
		int a = 90;
		int b2;
		
		if(true)
		{
			int b = 80;
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			b2 = b;
		}
		System.out.println("a = " + a);
		System.out.println("b2 = " + b2); 
		
		return;			//실행흐름(쓰레드)을 호출한곳으로 되돌려준다.
	}
}
