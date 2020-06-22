package com.itwill01.member_method;

public class Student 
{

	String id;		//학생 번호
	String name; 	//학생 이름
	int kor;		//국어점수
	int eng;		//영어점수
	int math;		//수학점수
	double avg;		//평균
	int rank;		//석차
	int total;		//총점
	char grade; 	//학점
	
	
	public void setInfo(String id, String name, int kor, int eng, int math)
	{
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//총점 계산함수
	public void getTotal()
	{	
		this.total = kor + eng + math;
	}
	
	//유효점수 판별 함수
	boolean testValid(int kor1, int eng1, int math1, int kor2, int eng2, int math2)
	{
		boolean isValid;
		isValid = (kor1 <= 100 && kor1 >= 0) && (eng1 <= 100 && eng1 >= 0) && (math1 <= 100 && math1 >= 0) && (kor2 <= 100 && kor2 >= 0) && (eng2 <= 100 && eng2 >= 0) && (math2 <= 100 && math2 >= 0);		
		if(!isValid)
		{
			System.out.println("ERROR: INVALID INPUT");
		}
		return isValid;
	}
	
	//평균 계산함수
	public void getAvg()
	{
		this.avg = total / 3.0;
	}
	
	
	//학점 계산함수
	public void getGrade()
	{	
		switch((int)avg / 10)	
		{
			case 10:
				this.grade = 'A';
				break;
			case 9:
				this.grade = 'A';
				break;
			case 8:
				this.grade = 'B';
				break;
			case 7:
				this.grade = 'C';
				break;
			case 6:
				this.grade = 'D';
				break;
			default:
				this.grade = 'F';
				break;
		}
	}
	
	//결과출력
	public void print()
	{
		System.out.printf("%2s  %-4s %3d %4d %4d %4d %5.1f %3c %4d\n", id, name, kor, eng, math, total, avg, grade, rank);
	}
}
