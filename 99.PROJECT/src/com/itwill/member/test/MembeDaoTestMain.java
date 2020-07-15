package com.itwill.member.test;

import com.itwill.member.Member;
import com.itwill.member.MemberDao;

public class MembeDaoTestMain 
{
	public static void main(String[] args) throws Exception
	{
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
	}
}
