package com.itwill02.constructor;

public class StudentConstructorMain
{	

	
	public static void main(String[] args) 
	{
		/*
		 학생객체생성(3명)
		  -1명은 기본생성자사용
		      학생객체데이타(번호, 이름, 국어, 영어, 수학)입력메쏘드호출
		  - 2명은 인자5개 생성자사용
		 */
		

		Student stu1 = new Student();
		Student stu2 = new Student("5678", "박약한", 70, 60, 80);
		Student stu3 = new Student("9999", "박최강", 100, 100, 100);

		stu1.setInfo("1234", "박강한", 95, 90, 90);
		
						
		
		// 학생총점계산 메쏘드 호출(3명) 
		   stu1.setTotal();
		   stu2.setTotal();
		   stu3.setTotal();
		//  학생평균계산 메쏘드 호출(3명) 
		   stu1.setAvg();
		   stu2.setAvg();
		   stu3.setAvg();
		// 학생평점계산 메쏘드 호출(3명)
		   stu1.setGrade();
		   stu2.setGrade();
		   stu3.setGrade();
		 
		
		
		/*
		 * 학생데이타3명 출력메쏘드 호출
		 */
		    stu1.headerPrint();
			stu1.print();
			stu2.print();
			stu3.print();
		
		// 학생 student1 의 이름변경
			stu1.setName("박한강");
		// 학생 student1 의 총점데이타 반환받은후 출력
			int total_return = stu1.getTotal();
			System.out.println("\n1번학생 총점: " + total_return);

		// 학생 student2 의 학점데이타 반환받은후 출력
			char grade_return = stu2.getGrade();
			System.out.println("1번학생 학점: " + grade_return);
			
	}
}
