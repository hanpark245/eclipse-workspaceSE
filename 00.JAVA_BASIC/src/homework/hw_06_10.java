package homework;

public class hw_06_10
{
	public static void main(String[] args)
	{
		//-------------------DECLARATIONS-----------------------//
		
		//--------------------김경호-----------------//
		int id1;				//학번
		int kor1;				//국어
		int eng1;				//영어
		int math1;				//수학
		int total1;				//총점
		double avg1;			//평균
		int rank1;				//석차
		char letter_grade1;		//평점
		
		//--------------------김경수-----------------//
		int id2;				//학번
		int kor2;				//국어
		int eng2;				//영어
		int math2;				//수학
		int total2;				//총점
		double avg2;			//평균
		int rank2;				//석차
		char letter_grade2;		//평점
		
		String x = "***************************************************";
		String title = "학번  이름 	국어 영어 수학 총점 평균  평점 석차";
		String name1 = "김경호";
		String name2 = "김경수";
		
		//-----------------------대입----------------------------//
		id1 = 1234;
		kor1 = 89;
		eng1 = 90;
		math1 = 78;
		total1 = kor1 + eng1 + math1;
		avg1 = total1 / 3;
		rank1 = 3;
		letter_grade1 = 'B';
		
		id2 = 1235;
		kor2 = 87;
		eng2 = 94;
		math2 = 56;
		total2 = kor2 + eng2 + math2;
		avg2 = total2 / 3;
		rank2 = 4;
		letter_grade2 = 'C';
		
		
		
		//-----------------------출력----------------------------//
		System.out.println(x);
		System.out.println(title);
		System.out.println(x);
		System.out.println(id1 + "  " + name1 + "	 " + kor1 + "   " + eng1 + "   " + math1 + "   " + total1 + "  " + avg1 + "  " + letter_grade1 + "    " + rank1);
		System.out.println(id2 + "  " + name2 + "	 " + kor2 + "   " + eng2 + "   " + math2 + "   " + total2 + "  " + avg2 + "  " + letter_grade2 + "    " + rank2);
		System.out.println(x);
		
	}
}
