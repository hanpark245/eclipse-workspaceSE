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
	
	
	public void getInfo(String id, String name, int kor, int eng, int math)
	{
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//총점 계산함수
	public int getTotal(int kor, int eng, int math)
	{	
		int total = kor + eng + math;
		return total;
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
	double getAvg(int total)
	{
		return avg = total / 3.0;
	}
	
	
	//학점 계산함수
	public char getGrade(double avg)
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
	
	//결과출력
	public void print(String id1, String id2, String name1, String name2, int kor1, int kor2, int eng1, int eng2, int math1, int math2, int total1, int total2, double avg1, double avg2, char grade1, char grade2, int rank1, int rank2)
	{
		System.out.printf("---------------학생 성적출력-------------------\n");
		System.out.printf("%s  %s   %s %s %s %s %s %s %s", "학번","이름","국어","영어","수학","총점","평균","평점","석차");
		System.out.println("\n-----------------------------------------------");
		System.out.printf("%2s  %-4s %3d %4d %4d %4d %5.1f %3c %4d", id1, name1, kor1, eng1, math1, total1, avg1, grade1, rank1);
		System.out.printf("\n%2s  %-4s %3d %4d %4d %4d %5.1f %3c %4d", id2, name2, kor2, eng2, math2, total2, avg2, grade2, rank2);
		System.out.println("\n-----------------------------------------------");
	}
}
