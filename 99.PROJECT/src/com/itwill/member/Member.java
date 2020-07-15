package com.itwill.member;

import java.io.Serializable;

public class Member implements Serializable{
	/*
	 *  중복되지않아야하는필드
	 */
	private String id;//아이디
	private String password;
	private String name;
	private String address;
	private int age;
	private boolean married;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String password, String name, String address, int age, boolean married) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.age = age;
		this.married = married;
	}
	
	public boolean matchPassword(String password) {
		if(this.password.equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + ", age="
				+ age + ", married=" + married + "]";
	}
	
	
	
}
