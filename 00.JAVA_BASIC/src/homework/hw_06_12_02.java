package homework;

public class hw_06_12_02 
{
	public static void main(String[] args)
	{
		
		// 학생2명 데이타를 담을변수선언--------------------------------------------------
		 		
		//1번학생
		String name1 = "김경호";			//이름
		int no1;							//번호
		int kor1;							//국어점수
		int eng1;							//영어점수
		int math1;							//수학점수
		int total1 = 0;						//총점
		double avg1 = 0;					//평균
		char grade1 = 0;					//평점
		//2번학생
		String name2 = "김경수";			//이름
		int no2;							//번호
		int kor2;							//국어점수
		int eng2;							//영어점수
		int math2;							//수학점수
		int total2 = 0;						//총점
		double avg2 = 0;					//평균
		char grade2 = 0;					//평점
		//--------------------------------------------------------------------------------
		
		// 학생2명 기본데이타대입  (학번,이름,국어,영어,수학)
		no1 = 1;
		kor1 = 49;
		eng1 = 56;
		math1 = 78;
		
		no2 = 2;
		kor2 = 67;
		eng2 = 58;
		math2 = 70;
		//-------------------------------------------------------------------------------
		
		
		//국어,영어,수학점수의 유효성체크
		boolean isValid;			
		isValid = (kor1 <= 100 && kor1 >= 0) && (eng1 <= 100 && eng1 >= 0) && (math1 <= 100 && math1 >= 0) && (kor2 <= 100 && kor2 >= 0) && (eng2 <= 100 && eng2 >= 0) && (math2 <= 100 && math2 >= 0);		
		
		if(!isValid)
		{
			System.out.println("ERROR: INVALID INPUT");		//100점이 넘는 수나 음수가 입력되면 메세지를 출력.
			return;											//input 유효하지 않을시 프로그램 종료.
		}

		//----------------------------------------------------------------------------------//
		//총점 평균 평점계산후 대입
		total1 = kor1 + eng1 + math1;			//1번학생 총점	
		avg1 = total1 / 3.0;					//1번학생 평균
		
		total2 = kor2 + eng2 + math2;			//2번학생 총점
		avg2 = total2 / 3.0;					//2번학생 평균
		
		// 평점계산시 switch 문을사용하세요
		switch((int)avg1 / 10)
		{
			case 10:
				grade1 = 'A';
				break;
			case 9:
				grade1 = 'A';
				break;
			case 8:
				grade1 = 'B';
				break;
			case 7:
				grade1 = 'C';
				break;
			case 6:
				grade1 = 'D';
				break;
			default:
				grade1 = 'F';
				break;
		}
		
		switch((int)avg2 / 10)
		{
			case 10:
				grade2 = 'A';
				break;
			case 9:
				grade2 = 'A';
				break;
			case 8:
				grade2 = 'B';
				break;
			case 7:
				grade2 = 'C';
				break;
			case 6:
				grade2 = 'D';
				break;
			default:
				grade2 = 'F';
				break;
		}
		
		//////////////////////////////////////////////////////////
		//	---------------학생 성적출력-------------------		//
		//	학번  이름   국어 영어 수학 총점 평균 평점 석차		//
		//	-----------------------------------------------		//
		//	 1   김경호   49   56   78   334  34.8  A   0  		//	
		//	 2   김경수   67   58   70   324  32.8  B   0  		//
		//	-----------------------------------------------		//
		//////////////////////////////////////////////////////////
			
		System.out.printf("---------------학생 성적출력-------------------\n");
		System.out.printf("%s  %s   %s %s %s %s %s %s %s", "학번","이름","국어","영어","수학","총점","평균","평점","석차");
		System.out.println("\n-----------------------------------------------");
		System.out.printf("%2d  %-5s %3d %4d %4d %4d %5.1f %3c %4d", no1, name1, kor1, eng1, math1, total1, avg1, grade1, 1);
		System.out.printf("\n%2d  %-5s %3d %4d %4d %4d %5.1f %3c %4d", no2, name2, kor2, eng2, math2, total2, avg2, grade2, 2);
		System.out.println("\n-----------------------------------------------");
		

	}
}
