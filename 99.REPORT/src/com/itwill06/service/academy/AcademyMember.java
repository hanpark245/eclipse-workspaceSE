package com.itwill06.service.academy;
public abstract class AcademyMember {
	public static final int STUDENT_TYPE=0; 
	public static final int GANGSA_TYPE=1; 
	public static final int STAFF_TYPE=2; 
	
	private int no;
	private String name;
	public AcademyMember() {
	}
	public AcademyMember(int no, String name) {
		
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void print() {
		System.out.print(no+"\t"+name+"\t");
	}
	
	
	
	
	
	
	
	
	
	
	
}
