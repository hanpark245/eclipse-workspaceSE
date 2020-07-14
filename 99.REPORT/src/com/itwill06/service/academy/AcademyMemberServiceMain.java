package com.itwill06.service.academy;

public class AcademyMemberServiceMain {

	public static void main(String[] args) {
		AcademyMemberService academyMemberService=new AcademyMemberService();
		
		System.out.println("1.AcademyMember 전체출력");
		//academyMemberSerivce 에 있는 print 메소드 호출.
		academyMemberService.print();
		System.out.println();

		System.out.println("2-1.번호 1 번 AcademyMember 객체 참조변수반환해줘");
		//academyMebmerService 에 있는 findAcademyMemberByNo() 메쏘드 호출
		AcademyMember m1 = academyMemberService.findAcademyMemberByNo(1);
		m1.print();
		System.out.println();

		System.out.println("2-1.번호 2 번 AcademyMember 객체 참조변수반환해줘");
		AcademyMember m2 = academyMemberService.findAcademyMemberByNo(2);
		m2.print();
		System.out.println();

		
		System.out.println("2-2.이름 KIM 인 AcademyMember 배열객체 참조변수반환해줘");
		AcademyMember Kim[] = academyMemberService.findAcademyMemberByName("KIM");		
		for (int i = 0; i < Kim.length; i++) 
		{
			Kim[i].print();
		}
		System.out.println();
		
		System.out.println("3.AcademyMember 중에서 AcademyStudent객체배열 참조변수반환해줘");
		AcademyMember[] students = academyMemberService.findAcademyStudents();
		for (int i = 0; i < students.length; i++) 
		{
			students[i].print();
		}
		System.out.println();

		System.out.println("3.AcademyMember 중에서 AcademyStaff객체배열 참조변수반환해줘");
		AcademyMember[] academyStaff = academyMemberService.findAcademyMembersByType(AcademyMember.STAFF_TYPE); 
		for (int i = 0; i < academyStaff.length; i++) 
		{
			academyStaff[i].print();
		}
		
		System.out.println("3.AcademyMember 중에서 AcademyGangsa객체배열 참조변수반환해줘");
		AcademyMember AcademyGangsa[] = academyMemberService.findAcademyGangsas();
		System.out.println("4.AcademyMember 중에서 자바반인  AcademyStudent객체들 배열참조변수반환해줘");
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
