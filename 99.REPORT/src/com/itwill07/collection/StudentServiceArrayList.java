package com.itwill07.collection;


import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class StudentServiceArrayList {
	
	private ArrayList<Student> studentList;
	
	
	public StudentServiceArrayList() {
		studentList=new ArrayList<Student>();
		studentList.add(new Student(1,"KIM",89,93,94));
		studentList.add(new Student(2,"HIM",88,77,98));
		studentList.add(new Student(3,"AIM",65,87,99));
		studentList.add(new Student(4,"KIM",75,97,60));
		studentList.add(new Student(5,"XIM",85,98,90));
		studentList.add(new Student(6,"TIM",95,88,77));
		studentList.add(new Student(7,"KIM",99,93,95));
		studentList.add(new Student(8,"LIM",83,80,99));
		studentList.add(new Student(9,"QIM",73,90,80));
	}
	/*
	 * 0.학생객체받아서 추가
	 */
	public void addStudent(Student student) {
		studentList.add(student);
	}
	/*
	 * 1. 전체학생총점,평균,평점계산
	 */
	public void calculate() {
		for (Student student : studentList) {
			student.calculateTot();
			student.calculateAvg();
			student.calculateGrade();
		}
		
	}
	/*
	 * 2. 전체학생 총점으로 석차계산
	 */
	public void calculateRank() {
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = 0; j < studentList.size(); j++) {
				if(studentList.get(i).getTot()<studentList.get(j).getTot()) {
					studentList.get(i).setRank(studentList.get(i).getRank()+1);
				}
			}
		}
		
		
	}
	
	/*
	 * 3. 전체학생반환
	 */
	public ArrayList<Student> getStudentList()
	{
		return studentList;
	}
	/*
	 * 4. 번호3번 학생한명 반환  
	 */
	public Student findByStudent(int no) 
	{
		Student findStudent=null;
		
		for (int i = 0; i < studentList.size(); i++) 
		{
			Student temp = (Student)studentList.get(i);
			if(temp.getNo() == 3)
			{
				findStudent = temp;
				break;
			}
		}
		return findStudent;
	}
	/*
	 * 5. 학점A인 학생들 반환
	 */
	public ArrayList<Student> findByGrade(char grade) 
	{
		ArrayList<Student> findStudents=new ArrayList<Student>();
		
		for (int i = 0; i < studentList.size(); i++) 
		{
			Student temp = (Student)studentList.get(i);
			if(temp.getGrade() == 'A')
			{
				findStudents.add(temp);
				
			}
		}
		return findStudents;
	}
	/*
	 * 5. 이름KIM 학생들 반환
	 */
	public ArrayList<Student> findByName(String name) {
		ArrayList<Student> findStudents = new ArrayList<Student>();
		
		
		for (int i = 0; i < studentList.size(); i++) 
		{
			Student temp = (Student) studentList.get(i);
			if(temp.getName() == "KIM")
			{
				findStudents.add(temp);
			}
		}
		return findStudents;
	}
	
	/*
	 * 6. 학생총점으로 오름차순정렬
	 */
	public void sortByTotAsc() 
	{
		Student temp = new Student();
		
		for (int i = 0; i < studentList.size() - 1; i++) 
		{
			for (int j = 0; j < studentList.size() - 1; j++) 
			{
				if(studentList.get(j).getTot() > studentList.get(j + 1).getTot())
				{
					temp = studentList.get(j);
					studentList.set(j, studentList.get(j+1));
					studentList.set(j + 1, temp);
				}
			}
		}
	}
	
	
	
	/*
	 8. 학생이름순으로 오름차순정렬
	 */
	public void sortByNameAsc() 
	{
		Student temp = new Student();
		
		for (int i = 0; i < studentList.size() - 1; i++) 
		{
			for (int j = 0; j < studentList.size() - 1; j++) 
			{
				if(studentList.get(j).getTot() > studentList.get(j + 1).getTot())
				{
					temp = studentList.get(j);
					studentList.set(j, studentList.get(j+1));
					studentList.set(j + 1, temp);
				}
			}
		}
	}
		
		
	
	
}
