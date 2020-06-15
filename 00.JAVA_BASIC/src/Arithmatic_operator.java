public class Arithmatic_operator {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		char ca = 'A';
		char cb = 'B';
		int result;
		
		
		//REFACTORING => ALT + SHIFT + T


		result = a+b;
		System.out.println("a + b =" + result);
		result = a-b;
		System.out.println("a - b =" + result);
		result = a*b;
		System.out.println("a * b =" + result);
		result = a/b;//???
		System.out.println("a / b =" + result);
		double dResult = a / b;
		System.out.println("double a / b = " + dResult);
		result= a%b;
		System.out.println("a % b =" + result);
		int year=2020;
		result = year%4;
		System.out.println("year % 4 =" + result);
		result = year%100;
		System.out.println("year % 100 =" + result);
		result = year%400;
		System.out.println("year % 400 =" + result);
		
		System.out.println("------문자연산------");
		result= ca + 1;
		System.out.println("ca + 1 --> " + result);
		cb = (char)result;
		System.out.println("cb --> "+ cb);
		
		
		//-------------한글의 글자수----------//
		System.out.println("\n-------------한글의 글자수-------------");
		char hanFirst = '가';
		char hanLast = '힣';
		int letterCount = hanLast - hanFirst + 1;
		System.out.println("한글의 글자수: " + letterCount);
		
		
		//----------------비트 연산자----------------------
		System.out.println("\n-------------비트연산자-------------");
		int c = 1;
		System.out.println("c = " + c);
		c = (int) Math.pow(2,2);
		
		result = c << 1;
		System.out.println("c << 1 = " + result);
		result = c << 2;
		System.out.println("c << 2 = " + result);	
		result = c << 4;
		System.out.println("c << 4 = " + result);
		result = c << 8;
		System.out.println("c << 8 = " + result);
		
		int d = 128;
		System.out.println("d = " + d);
		result = d >> 1;
		System.out.println("d >> 1 = " + result);
		result = d >> 2;
		System.out.println("d >> 2 = " + result);
		result = d >> 3;
		System.out.println("d >> 3 = " + result);
		result = d >> 4;
		System.out.println("d >> 4 = " + result);
		
		
		/*-----------------------------------비트연산자--------------------------------
		*
		*  -형태: | , & ,~
		*Bit or 연산( | )-->양쪽비트가 모두 0인경우에
		*
		------------------------------------------------------------------------------*/

		int intmax1 = 2147483647;
		int intmax2 = 0B01111111111111111111111111111111;
		System.out.println(intmax1);
		System.out.println(intmax2);
		int result1 = ~intmax1;
		result1 = result1 + 1;
		int result2 = ~intmax2;
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(Integer.toBinaryString(result1));
		
		
		//----------------------------------------------ERROR MESSAGE---------------------------------------------------------//
		//	1. name cannot be resolved to a variable//
		//	name = "김경호";
		// 	
		//	2. Duplicate local variable number
		//	int number;
		//	int number = 90;
		//
		//	3. string cannot be resolved to a type
		//	string message = "오늘은 날씨가 좋다";		//String의 S는 항상 대문자
		//
		//	4.syntax error, insert ";" to complete LocalVariableDeclarationStatement
		//	int score
		//	System.out.println(score);
		//
		//
		//
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
}
