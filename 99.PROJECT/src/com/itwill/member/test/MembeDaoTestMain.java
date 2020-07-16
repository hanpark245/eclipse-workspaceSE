package com.itwill.member.test;

import com.itwill.member.Member;
import com.itwill.member.MemberDao;

public class MembeDaoTestMain {

	public static void main(String[] args) throws Exception{
		MemberDao memberDao=new MemberDao();
		System.out.println("-----------------create--------------");
		boolean isAdd=memberDao.create(new  Member("xxx", "xxx", "김경호", "서울시민", 34, true));
		System.out.println(isAdd);
		isAdd=memberDao.create(new  Member("yyy", "yyy", "송경호", "부산시민", 23, false));
		System.out.println(isAdd);
		isAdd=memberDao.create(new  Member("zzz", "zzz", "박경호","CA", 48, true));
		System.out.println(isAdd);
		System.out.println("-----------------readAll--------------");
		System.out.println(memberDao.readAll());
		System.out.println("-----------------readOne--------------");
		System.out.println(memberDao.readOne("xxx"));
		System.out.println("-----------------update--------------");
		Member updateMember = memberDao.readOne("xxx");
		updateMember.setName("김변경");
		updateMember.setAddress("KANGNAM");
		updateMember.setAge(12);
		updateMember.setMarried(true);
		memberDao.update(updateMember);
		System.out.println(memberDao.readOne("xxx"));
		System.out.println("-----------------delete--------------");
		memberDao.delete("xxx");
		System.out.println(memberDao.readAll());
		
	}

}
