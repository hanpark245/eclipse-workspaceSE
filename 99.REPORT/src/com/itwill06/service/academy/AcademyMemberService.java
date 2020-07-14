package com.itwill06.service.academy;
/*
 * AcademyMember들의 업무처리클래스
 *  Create
 *  Read
 *  Update
 *  Delete
 */
public class AcademyMemberService {
	
	private AcademyMember[] members={
			new AcademyStudent(1, "KIM", "자바"),
			new AcademyStudent(2, "LEE", "리눅스"),
			new AcademyStudent(3, "KIM", "자바"),
			new AcademyStudent(4, "LEE", "IOT"),
			new AcademyGangsa(5, "CHOI", "프로그래밍"),
			new AcademyGangsa(6, "KIM", "DB"),
			new AcademyGangsa(7, "DIM", "OS"),
			new AcademyStaff(8, "AIM", "영업"),
			new AcademyStaff(9, "QIM", "생산")
	};
	
	public AcademyMember[] getMembers() 
	{
		return members;
	}
	
	public void print() {
		for (int i = 0; i < members.length; i++) {
			AcademyMember academyMember = members[i];
			academyMember.print();
		}
	}
	public AcademyMember findAcademyMemberByNo(int no) {
		AcademyMember findMember=null;
		for (int i = 0; i < members.length; i++) {
			if(members[i].getNo()==no) {
				findMember = members[i];
				break;
			}
		}
		
		return findMember;
	}
	public AcademyMember[] findAcademyMemberByName(String name) 
	{
		int j = 0;
		for (int i = 0; i < members.length; i++) 
		{
			if(members[i].getName() == name)
			{
				j++;
			}
		}
		AcademyMember findMembers[] = new AcademyMember[j];
		j = 0;
		for (int i = 0; i < members.length; i++) 
		{
			if(members[i].getName() == name)
			{
				findMembers[j] = members[i];
				j++;
			}
		}
		return findMembers;
	}
	/*
	 * 강사 or 학생 or Staff들 반환( instanceof연산자)
	 * 	
	 */
	public AcademyMember[] findAcademyStudents()
	{
		AcademyMember[] students=null;
		int count=0;
		for (int i = 0; i < members.length; i++) {
			if(members[i] instanceof AcademyStudent) {
				count++;
			}
		}
		students=new AcademyMember[count];
		int index=0;
		for (int i = 0; i < members.length; i++) {
			if(members[i] instanceof AcademyStudent) {
				students[index]=members[i];
				index++;
			}
		}
		return students;
	}
	public AcademyMember[] findAcademyGangsas(){
		return null;
	}
	public AcademyMember[] findAcademyStaffs(){
		return null;
	}

	
	
	
	public AcademyMember[] findAcademyMembersByType(int type) 
	{
		int index = 0;
		
		if(type == 0)
		{
			for (int i = 0; i < members.length; i++) 
			{
				if(members[i] instanceof AcademyStudent) 
				{ 	
					index++;
				}
			}
			AcademyMember findMembers[] = new AcademyMember[index];
			index = 0;
			for (int i = 0; i < members.length; i++) 
			{
				if (members[i] instanceof AcademyStudent) 
				{
					findMembers[index] = members[i];
					index++;
				}
			}
		}
		else if(type == 1)
		{
			for (int i = 0; i < members.length; i++) 
			{
				if(members[i] instanceof AcademyGangsa) 
				{ 	
					index++;
				}
			}
			AcademyMember findMembers[] = new AcademyMember[index];
			index = 0;
			for (int i = 0; i < members.length; i++) 
			{
				if (members[i] instanceof AcademyGangsa) 
				{
					findMembers[index] = members[i];
					index++;
				}
			}
		}
		else
		{
			for (int i = 0; i < members.length; i++) 
			{
				if(members[i] instanceof AcademyStaff) 
				{ 	
					index++;
				}
			}
			AcademyMember findMembers[] = new AcademyMember[index];
			index = 0;
			for (int i = 0; i < members.length; i++) 
			{
				if (members[i] instanceof AcademyStaff) 
				{
					findMembers[index] = members[i];
					index++;
				}
			}
		}

		return findMembers;
	}
	
	/*
	public AcademyMember[] findAcademyStudentsByBan(String ban) {
		AcademyMember[] findMembers=null;
		return findMembers;
	}
	public AcademyMember[] findAcademyGangsasBySubject(String subject) {
		AcademyMember[] findMembers=null;
		return findMembers;
	}
	public AcademyMember[] findAcademyStaffsByDepart(String depart) {
		AcademyMember[] findMembers=null;
		return findMembers;
	}
	*/
	/*
	 * 자바반     학생들 찾아서 반환해줘 
	 * 리눅스과목 강사들 찾아서 반환해줘 
	 * 영업부서   스텝들 찾아서 반환해줘 
	 */
	public AcademyMember[] findByAcademyMembers(int type,String searchStr) 
	{
		int index = 0;
		for (int i = 0; i < members.length; i++) 
		{
			if(type == members[i].getNo())
			{
				index++;
			}
		}
		AcademyMember[] findMembers = new AcademyMember[index];
		int j = 0;
		for (int i = 0; i < members.length; i++) 
		{
			if(type == members[i].getNo())
			{
				findMembers[j] = members[i];
				j++;
			}
		}
		return findMembers;
	} 
	/*
	public AcademyMember[] findByAcademyMembers(AcademyMember searchMember) {
		AcademyMember[] findMembers=null;
		return findMembers;
	} 
	*/
}
