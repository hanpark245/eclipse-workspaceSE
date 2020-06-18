package com.itwill01.member_method;

public class StudentMemberMethodMain 
{

	public static void main(String[] args) 
	{
		//객체 선언
		Student student1 = new Student();
		Student student2 = new Student();
		Student voidFunction = new Student();
		//정보 대입매소드 호출
		student1.getInfo("박강한", "1234", 97, 98, 100);
		student2.getInfo("박약한", "5678", 78, 60, 88);

		
		//점수유효 메소드 호출
		boolean isValid = student1.testValid(student1.kor, student1.eng, student1.math, student2.kor, student2.eng, student2.math);
		
		//유효점수 아닐경우 프로그램 종료
		if(!isValid)
		{
			return;
		}
		
		//총점 매소드 호출
		student1.total = student1.getTotal(student1.kor, student1.eng, student1.math);
		student2.total = student2.getTotal(student2.kor, student2.eng, student2.math);
		
		//평균 매소드 호출
		student1.avg = student1.getAvg(student1.total);
		student2.avg = student2.getAvg(student2.total);
		
		//학점 매소드 호출
		student1.grade = student1.getGrade(student1.avg);
		student2.grade = student2.getGrade(student2.avg);
		
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
		voidFunction.print(student1.id, student2.id, student1.name, student2.name, student1.kor, student2.kor, student1.eng, student2.eng, student1.math, student2.math, student1.total, student2.total, student1.avg, student2.avg, student1.grade, student2.grade, student1.rank, student2.rank);
		
		//프로그램 종료
		return;
	}
}
