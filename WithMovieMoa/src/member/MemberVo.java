package member;

import java.io.Serializable;

public class MemberVo implements Serializable{

	private String id;
	private String password;
	private String name;
	private int age;
	private String address;
	private String phoneNumber;
	private String email;
	private boolean adAgree;
		
	public String toString() {
		return "\n- " + id + " - �� ȸ������\n" +id+"\n"+password+"\n"+name+"\n"+age+"\n"+address+"\n"+phoneNumber+"\n"+email+"\n"+adAgree + "\n";
	}
	public MemberVo(String id, String password, String name, int age, String address, String phoneNumber, String email, boolean adAgree) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.adAgree = adAgree;
	}
	public MemberVo(String id, String password, String name, int age, String address, String phoneNumber, String email) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdAgree() {
		return adAgree;
	}
	public void setAdAgree(boolean adAgree) {
		this.adAgree = adAgree;
	}
}