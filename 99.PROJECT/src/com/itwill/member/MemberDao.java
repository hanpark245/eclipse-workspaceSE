package com.itwill.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.account.Account;

public class MemberDao {
	private File membersFile;
	public MemberDao() throws Exception{
		membersFile=new File("members.ser");
		if(!membersFile.exists()) {
			System.out.println("파일생성[members.ser]");
			ObjectOutputStream oos
				=new ObjectOutputStream(new FileOutputStream(membersFile));
			oos.writeObject(new ArrayList<Account>());
		}
	}
	/**********************************************/
	private ArrayList<Member> readFile() throws Exception{
		ObjectInputStream ois=
				new ObjectInputStream(
						new FileInputStream(membersFile));
		ArrayList<Member> memberList=(ArrayList<Member>)ois.readObject();
		ois.close();
		return memberList;
	}
	private void writeFile(ArrayList<Member> memberList) throws Exception{
		ObjectOutputStream oos=
				new ObjectOutputStream(
						new FileOutputStream(membersFile));
		oos.writeObject(memberList);
		oos.close();
	}
	/**********************************************/
	/*
	 * create
	 */
	public boolean create(Member addMember) throws Exception{
		boolean isSuccess=false;
		ArrayList<Member> memberList=this.readFile();
		if(isDuplicateId(addMember.getId())) {
			isSuccess=false;
			return isSuccess;
		}
		isSuccess=true;
		memberList.add(addMember);
		this.writeFile(memberList);
		return isSuccess;
	}
	public boolean isDuplicateId(String id) throws Exception{
		boolean isDuplicate=false;
		ArrayList<Member> memberList=this.readFile();
		for (Member member : memberList) {
			if(member.getId().equals(id)) {
				isDuplicate=true;
				break;
			}
		}
		return isDuplicate;
		
	}
	/*
	 * readAll
	 */
	public ArrayList<Member> readAll()throws Exception {
		return this.readFile();
	}
	/*
	 * readOne
	 */
	public Member readOne(String id) throws Exception{
		Member findMember=null;
		ArrayList<Member> memberList=this.readFile();
		for (Member member : memberList) {
			if(member.getId().equals(id)) {
				findMember=member;
				break;
			}
		}
		return findMember;
	}
	public void update(Member updateMember) {
		
	}
	public void delete(String id) {
		
	}
}







