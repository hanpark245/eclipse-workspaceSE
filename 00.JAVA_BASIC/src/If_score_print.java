public class If_score_print
{
	public static void main(String[] args) 
	{
		//성적관리에서 학생2명 데이타를 담을 변수선언
		//	-번호, 이름, 국어, 영어, 수학, 총점, 평균, 평점(A,B,C), 석차

		
		// 	학생 2명의 기본데이타(번호, 이름, 국어, 영어, 수학) 입력		
		//int no1 = 1;
		int kor1 = 45;
		int eng1 = 56;
		int math1 = 78;
		int rank1 = 1;
		int total1;
		double avg1;
		char grade1 = 'A';
		//String name1 = "김경호";

		// 	학생 2명의 기본데이타(번호, 이름, 국어, 영어, 수학)를 이용해서 총점, 평균, 평점 계산후 대입
		total1 = kor1 + eng1 + math1;
		avg1 = total1 / 3.0;
		
		
		if(avg1 <= 100 && avg1 >= 0)
		{
			if(avg1 >= 90)
			{
				grade1 = 'A';
			} 
			else if(avg1 >= 80)
			{
				grade1 = 'B';
			}
			else if(avg1 >= 70)
			{
				grade1 = 'C';
			}
			else if(avg1 >= 60)
			{
				grade1 = 'D';
			}
			else 
			{
				grade1 = 'F';
			}
		}		else
		{
			System.out.println("ERROR: 유효하지 않은 점수입니다");	
		}
		

		// 	학생 2명 성적출력
		/*
		---------------학생 성적출력-------------------
		학번  이름   국어 영어 수학 총점 평균 평점 석차
		-----------------------------------------------
		 2   김경수   45   56   78   334  34.8  A   2  
		 2   김경수   45   56   78   334  34.8  A   2  
		-----------------------------------------------
		*/
		
		System.out.printf("---------------학생 성적출력-------------------\n");
		System.out.printf("%s  %s   %s %s %s %s %s %s %s", "학번","이름","국어","영어","수학","총점","평균","평점","석차");
		System.out.println("\n-----------------------------------------------");
		System.out.printf("%3d %-5s %3d %4d %4d %4d %5.1f %3c %4d", 1, "김경호", kor1, eng1, math1, total1, avg1, grade1, rank1);
		System.out.printf("\n%3d %-5s %3d %4d %4d %4d %5.1f %3c %4d", 1, "김경호수", kor1, eng1, math1, total1, avg1, grade1, rank1);
			
	}

}
