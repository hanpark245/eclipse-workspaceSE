package notes;

public class MemberMethodReturn
{
	
	int method1() 
	{
		System.out.println("MemberMethodReturn.method1() 실행");
		int result = 2 + 9;
		/*
		 *  return의 의미
		 *   	1. 실행흐름을 호출한 곳으로 반환
		 *   	2. 실행흐름을 호출한 곳으로 데이터 반환
		 *	return(반환)할 데이타가 있는경우에는 return문 생략 불가능 
		 */
		return result;
	}
	
	boolean isMarried()
	{
		System.out.println("MemberMethodReturn.isMarried() 실행");
		return false;
	}
	
	int add(int a, int b)
	{
		System.out.println("MemberMethodReturn.add() 실행");
		int r = a+b;
		return r;
	}
}
