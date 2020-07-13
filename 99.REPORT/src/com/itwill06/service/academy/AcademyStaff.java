package com.itwill06.service.academy;
public class AcademyStaff extends AcademyMember {
	private String depart;
	public AcademyStaff() {
		// TODO Auto-generated constructor stub
	}
	public AcademyStaff(int no,String name,String depart) {
		super(no, name);
		this.depart = depart;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public void print() {
		super.print();
		System.out.println(this.depart);
	}
}
