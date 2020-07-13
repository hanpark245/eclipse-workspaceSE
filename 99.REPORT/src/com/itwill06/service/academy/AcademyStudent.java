package com.itwill06.service.academy;
public class AcademyStudent extends AcademyMember {
	private String ban;
	public AcademyStudent() {
		// TODO Auto-generated constructor stub
	}
	public AcademyStudent(int no,String name,String ban) {
		/*
		this.setNo(no);
		this.setName(name);
		*/
		super(no,name);
		this.ban=ban;
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	public void print() {
		super.print();
		System.out.println(this.ban);
	}
	
}
