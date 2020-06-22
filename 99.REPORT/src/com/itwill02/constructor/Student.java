package com.itwill02.constructor;

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
	
	public Student()
	{
		
	}
	
	public Student(String id, String name, int kor, int eng ,int math)
	{
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	//정보입력 함수
	public void setInfo(String id, String name, int kor, int eng, int math)
	{
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
	//GETTER SETTER-----------------------------
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	//총점 계산함수
	public void setTotal()
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
	public void setAvg()
	{
		this.avg = total / 3.0;
	}
	
	
	//학점 계산함수
	public void setGrade()
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
	
	//헤더 프린터
	public void headerPrint() {
		System.out.printf("---------------학생 성적출력-------------------\n");
		System.out.printf("%s  %s   %s %s %s %s %s %s %s", "학번","이름","국어","영어","수학","총점","평균","평점","석차");
		System.out.println("\n-----------------------------------------------");
	}
	//결과출력
	public void print()
	{
		System.out.printf("%2s  %-4s %3d %4d %4d %4d %5.1f %3c %4d\n", id, name, kor, eng, math, total, avg, grade, rank);
	}
}
