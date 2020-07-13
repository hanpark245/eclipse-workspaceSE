package com.itwill06.service.academy;

public class AcademyMemberServiceMain {

	public static void main(String[] args) {
		AcademyMemberService academyMemberService=new AcademyMemberService();
		
		System.out.println("1.AcademyMember 전체출력");
		academyMemberService.print();
		System.out.println("2-1.번호 1 번 AcademyMember 객체 참조변수반환해줘");
		AcademyMember m1=
				academyMemberService.findAcademyMemberByNo(1);
		m1.print();
		System.out.println("2-1.번호 2 번 AcademyMember 객체 참조변수반환해줘");
		System.out.println("2-2.이름 KIM 인 AcademyMember 배열객체 참조변수반환해줘");
		
		System.out.println("3.AcademyMember 중에서 AcademyStudent객체배열 참조변수반환해줘");
		AcademyMember[] students = academyMemberService.findAcademyStudents();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
		System.out.println("3.AcademyMember 중에서 AcademyStaff객체배열 참조변수반환해줘");
		System.out.println("3.AcademyMember 중에서 AcademyGangsa객체배열 참조변수반환해줘");
		
		System.out.println(
		"4.AcademyMember 중에서 자바반인  AcademyStudent객체들 배열참조변수반환해줘");
		System.out.println(
		"4.AcademyMember 중에서 영업부서인 AcademyStaff  객체들 배열참조변수반환해줘");
		System.out.println(
		"4.AcademyMember 중에서 자바과목인 AcademyGangsa 객체들 배열참조변수반환해줘");
		System.out.println("---------------------------------------------");
		System.out.println(
		"5.AcademyMember 중에서 자바반인  AcademyStudent객체들 배열참조변수반환해줘");
		System.out.println(	
	    "5.AcademyMember 중에서 영업부서인 AcademyStaff  객체들 배열참조변수반환해줘");
		System.out.println(
		"5.AcademyMember 중에서 자바과목인 AcademyGangsa 객체들 배열참조변수반환해줘");
	}

}
