package com.itwill00.member_field;

public class StudentMemberFieldMain 
{
	public static void main(String[] args) 
	{
		/*
		 학생객체생성(2명)
		 */
		Student student1 = new Student();
		Student student2 = new Student();
		
		 
	
		/*
		 학생객체데이타(번호,이름,국어,영어,수학)입력(2명)
		 */
		student1.id = "1";				//1번학번
		student1.name = "박강한";		//1번이름
		student1.kor = 100;				//1번 국어점수
		student1.eng = 100;				//1번 영어점수
		student1.math = 100;			//1번 수학점수
		student1.rank = 0;				//1번 석차
			
		student2.id = "9";				//2번학번
		student2.name = "박약한";		//2번이름
		student2.kor = 50;				//2번 국어점수
		student2.eng = 60;				//2번 국어점수
		student2.math = 40;				//2번 수학점수
		student1.rank = 0;				//2번 석차

		
		//국어,영어,수학점수의 유효성체크
		boolean isValid = testValid(student1.kor, student1.eng, student1.math, student2.kor, student2.eng, student2.math);
		if(!isValid)
		{
			System.out.println("ERROR: INVALID INPUT");
			return;
		}
		
		
		
		//학생총점,평균,평점계산후 멤버변수에 대입

		student1.total = getTotal(student1.kor, student1.eng, student1.math); 	//1번학생 총점	
		student1.avg = student1.total / 3.0;									//1번학생 평균
		student1.grade = getGrade(student1.avg);								//1번학생 학점
		
		student2.total = getTotal(student2.kor, student2.eng, student2.math); 	//2번학생 총점
		student2.avg = student2.total / 3.0;									//2번학생 평균
		student2.grade = getGrade(student2.avg);								//1번학생 학점
		
		//석차 계산
		if(student1.avg > student2.avg)
		{
			student1.rank = 1;
			student2.rank = 2;
		}
		else if(student1.avg < student2.avg)
		{
			student1.rank = 2;
			student2.rank = 1;
		}
		else
		{
			student1.rank = 0;
			student2.rank = 0;
		}
		
		
		/*
		 * 학생데이타 출력
		 */
		System.out.printf("---------------학생 성적출력-------------------\n");
		System.out.printf("%s  %s   %s %s %s %s %s %s %s", "학번","이름","국어","영어","수학","총점","평균","평점","석차");
		System.out.println("\n-----------------------------------------------");
		System.out.printf("%2s  %-5s %3d %4d %4d %4d %5.1f %3c %4d", student1.id, student1.name, student1.kor, student1.eng, student1.math, student1.total, student1.avg, student1.grade, student1.rank);
		System.out.printf("\n%2s  %-5s %3d %4d %4d %4d %5.1f %3c %4d", student2.id, student2.name, student2.kor, student2.eng, student2.math, student2.total, student2.avg, student2.grade, student2.rank);
		System.out.println("\n-----------------------------------------------");
	}
	
	
	//총점 계산함수
	public static int getTotal(int kor, int eng, int math)
	{	
		int total = kor + eng + math;
		return total;
	}
	
	//유효점수 판별 함수
	public static boolean testValid(int kor1, int eng1, int math1, int kor2, int eng2, int math2)
	{
		boolean isValid;
		isValid = (kor1 <= 100 && kor1 >= 0) && (eng1 <= 100 && eng1 >= 0) && (math1 <= 100 && math1 >= 0) && (kor2 <= 100 && kor2 >= 0) && (eng2 <= 100 && eng2 >= 0) && (math2 <= 100 && math2 >= 0);		
		return isValid;
	}
	
	//학점 판별함수
	public static char getGrade(double avg)
	{	
		char grade;
		
		switch((int)avg / 10)	
		{
			case 10:
				grade = 'A';
				break;
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
				break;
		}
		return grade; 
	}
}

