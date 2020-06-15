public class IfNest 
{
	public static void main(String[] args)
	{
		int kor = 120;
		char grade;


		if(kor < 100 && kor > 0)
		{
			if(kor >= 90)
			{
				grade = 'A';
			} 
			else if(kor >= 80)
			{
				grade = 'B';
			}
			else if(kor >= 70)
			{
				grade = 'C';
			}
			else if(kor >= 60)
			{
				grade = 'D';
			}
			else 
			{
				grade = 'F';
			}
			System.out.printf("당신의 학점은 %c입니다\n",  grade);	
		}
		else
		{
			System.out.println("유효하지 않은 점수입니다");	
		}
	}
}
