package com.itwill01.member_method;

public class StudentMemberMethodMain 
{

	public static void main(String[] args) 
	{
		//객체 선언
		Student student1 = new Student();
		Student student2 = new Student();
	
		//정보 대입매소드 호출
		student1.setInfo("박강한", "1234", 97, 98, 100);
		student2.setInfo("박약한", "5678", 78, 60, 88);

		
		//점수유효 메소드 호출
		boolean isValid = student1.testValid(student1.kor, student1.eng, student1.math, student2.kor, student2.eng, student2.math);
		
		//유효점수 아닐경우 프로그램 종료
		if(!isValid)
		{
			return;
		}
		
		//총점 매소드 호출
		student1.getTotal();
		student2.getTotal();
		
		//평균 매소드 호출
		student1.getAvg();
		student2.getAvg();
		
		//학점 매소드 호출
		student1.getGrade();
		student2.getGrade();
		
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
			student1.rank = 1;
			student2.rank = 1;
		}
		
		
		//결과 출력 매소드 호출
		System.out.printf("---------------학생 성적출력-------------------\n");
		System.out.printf("%s  %s   %s %s %s %s %s %s %s", "학번","이름","국어","영어","수학","총점","평균","평점","석차");
		System.out.println("\n-----------------------------------------------");
		student1.print();
		student2.print();
		
		//프로그램 종료
		return;
	}
}
