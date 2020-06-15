//----------------------------------관계(비교)연산--------------------------------//
//
//	-형태: >, <, =, >=, <=, ==, !=
//	-관계연산의 결과값은 논리형 데이타이다(true, false)
//
//================================================================================//
	
public class Relational_operator 
{
	public static void main(String[] args)
	{
		//TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		boolean result;
		
		result = a > b;
		System.out.println("a > b => " + result);
		result = a < b;
		System.out.println("a < b => " + result);
		result = a >= b;
		System.out.println("a >= b => " + result);
		result = a <= b;
		System.out.println("a <= b => " + result);
		result = a == b;
		System.out.println("a == b => " + result);
		result = a != b;
		System.out.println("a != b => " + result);
		char c1 = '가';
		char c2 = 'R';
		char c3 = 'A';
		char c4 = 'B';
		result = c1 < c2;
		System.out.println("가 < R => " + result);
		System.out.println("가 숫자 => " + (int)c1);
		System.out.println("R 숫자 => " + (int)c2);
		
		result = c3 < c4;
		System.out.println("A < B => " + result);
	}
}
