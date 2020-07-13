package com.itwill07.collection;


import java.util.ArrayList;

public class StudentServiceArrayListMain {

	public static void main(String[] args) {
		StudentServiceArrayList studentServiceArrayList=new StudentServiceArrayList();
		/*
		 * 1. 전체학생총점,평균,평점계산
		 */
		System.out.println("1. 전체학생총점,평균,평점계산");
		studentServiceArrayList.calculate();
		/*
		 * 2. 전체학생 총점으로 석차계산
		 */
		System.out.println("2. 전체학생 총점으로 석차계산");
		studentServiceArrayList.calculateRank();
		
		/*
		 * 3. 전체학생반환
		 */
		System.out.println("3. 전체학생반환 ");
		ArrayList<Student> studentList=
				studentServiceArrayList.getStudentList();
		
		/*
		 * 4. 번호3번 학생한명 반환  
		 */
		System.out.println("4.번호3번 학생한명 반환  ");
		Student findStudent=studentServiceArrayList.findByStudent(3);
		findStudent.print();
		/*
		 * 5. 학점A인 학생들 반환
		 */
		System.out.println("5. 학점A인 학생들 반환");
		studentList=studentServiceArrayList.findByGrade('A');
		
		/*
		 * 5. 이름KIM 인 학생들 반환
		 */
		System.out.println("5.  이름KIM 인 학생들 반환");
		studentList=studentServiceArrayList.findByName("KIM");
		
		/*
		 * 6. 학생총점으로 오름차순정렬
		 */
		System.out.println("6. 학생총점으로 오름차순정렬");
		studentServiceArrayList.sortByTotAsc();
		studentList=studentServiceArrayList.getStudentList();
		
		
		/*
		 8. 학생이름순으로 오름차순정렬
		 */
		System.out.println("8. 학생이름순으로 오름차순정렬");
		studentServiceArrayList.sortByNameAsc();
		studentList=studentServiceArrayList.getStudentList();
		
		
	
		
	}

}
