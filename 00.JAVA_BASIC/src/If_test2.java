
public class If_test2 
{
		public static void main(String[] args)
		{
			//짝수 홀수 판별/////////////////////////////////////////////////
			
			int inputNo = 1;
			if((inputNo % 2 == 0) && inputNo != 0)
			{
				System.out.println(inputNo + "는 짝수입니다.");
			}
			else
			{
				System.out.println(inputNo + "는 홀수입니다.");
			}
		
			
			//4의배수 판별////////////////////////////////////////////////////
			
			if((inputNo % 4 == 0) && inputNo != 0)
			{
				System.out.printf("%d는 4의배수입니다.\n", inputNo);
			}
			else
			{
				System.out.printf("%d는 4의배수가 아닙니다.\n", inputNo);
			}
		
			
			//공배수///////////////////////////////////////////////////////////
			
			if((inputNo % 4 == 0) && (inputNo % 3 == 0))
			{
				System.out.printf("%d는 3과 4의 공배수입니다.\n", inputNo);
			}
			else
			{
				System.out.printf("%d는 3과 4의 공배수가 아닙니다.\n", inputNo);
			}
			
			
			//점수의 유효성체크////////////////////////////////////////////////
			
			int kor = 110;
			if(kor >= 0 && kor <= 100)
			{
				System.out.printf("%d는 유효한 점수입니다", kor);
			}
			else
			{
				System.out.printf("%d는 유효한 점수가 아닙니다", kor);
			}	
			
			
			//윤년여부////////////////////////////////////////////////////////
			System.out.println("\n--------------윤년계산기---------------");
			int year = 2200;
			boolean isLeapYear = ((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0));
			if(isLeapYear)
			{
				System.out.printf("%d년은 윤년입니다", year);
			}
			else
			{
				System.out.printf("%d년은 윤년이 아닙니다", year);
			}
			
	}
}
