/*------------------------------------------------논리연산자-------------------------------------------------------------
 *
 * 	-형태: ||(Logical OR), &&(Logical AND) (|,&)
 * 	-좌우측의항이 논리형데이타, 변수, 연산식이다.
 * 	-결과도 논리형데이타이다.
 * 	ex> true || false, false && false 
 * 
 *----------------------------------------------------------------------------------------------------------------------*/


public class Logical_operator 
{
	public static void main(String[] args)
	{
		
		//-------------------------------------------------VARIABLE DECLARATIONS--------------------------------------------//
		boolean a1 = false;
		boolean a2 = false;
		boolean a3 = true;
		boolean a4 = true;
		boolean result;
		
		//------------------------------------------------ TEST --------------------------------------------//
		result = a1 || a2;
		System.out.println("false || false = " + result);
		result = a3 || a4;
		System.out.println("true || true = " + result);
		result = a1 || a3;
		System.out.println("false || true = " + result);	
		
		result = a3 && a4;
		System.out.println("true && true =" + result);
		
		
		
		System.out.println("\n---------점수의 유효성체크-----------");
		int kor = 150;
		int math = 78;
		boolean isValidKor;
		boolean isValidMath;
		boolean isValidAll;
		isValidKor = (kor >= 0) && (kor <= 100);
		System.out.println("Korean score valid? = " + isValidKor);
		isValidMath = (math >= 0) && (math <= 100);
		System.out.println("Math score valid? = " + isValidMath);	
		isValidAll = isValidKor && isValidMath;
		System.out.println("점수유효: " + isValidAll);
		
		System.out.println("\n---------합격여부-----------");		
		int eng = 89;
		int spanish = 56;
		int chi = 90;
		
		boolean qualify;
		qualify = (eng >= 90) || (spanish >= 90) || (chi >= 90);
		System.out.println("Candidate qualified? " + qualify);
		
		
		/*---------------------------  QUIZ_leap year  ---------------------------
		 *  4의배수는 윤년
		 * 	100의배수는 윤년아님
		 * 	400의배수는 윤년
		 * 
		 -----------------------------------------------------------------------*/
		System.out.println("\n--------------윤년계산기---------------");
		boolean isLeapYear = false;
		int year = 4;
		isLeapYear = ((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0));
		System.out.println(year + "년은 윤년입니까? " + isLeapYear);

	}
}
