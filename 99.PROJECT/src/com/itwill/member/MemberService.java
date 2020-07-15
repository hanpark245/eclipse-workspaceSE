package com.itwill.member;

public class MemberService {
	private MemberDao memberDao;
	public MemberService() throws Exception{
		memberDao=new MemberDao();
	}
	
	/*
	 * 회원가입
	 */
	public boolean memberRegister(Member newMember) throws Exception{
		boolean isSuccess =false;
		isSuccess=memberDao.create(newMember);
		return isSuccess;
	}
	/*
	 * 로그인
	 */
	public int login(String id,String password) throws Exception {
		int result =-9999;
		/*
		 * 0:성공
		 * 1:아이디존재안함
		 * 2.패쓰워드불일치
		 */
		//1.아이디존재여부
		if(memberDao.isDuplicateId(id)) {
			//아이디존재
			Member findMember = memberDao.readOne(id);
			//2.패스워드일치여부
			if(findMember.matchPassword(password)) {
				//패쓰워드일치
				result=0;
			}else {
				//패쓰워드불일치
				result=2;
			}
		}else {
			//아이디존재안함
			result=1;
		}
		
		return result;
		
		
	}
	
	
	/*
	 * 로그아웃
	 */
	
	/*
	 * 회원상세보기(회원1명 아이디로찾기)
	 */
	
	/*
	 * 회원리스트(회원여러명 전체)
	 * 회원리스트(회원여러명 이름으로 찾기)
	 * 회원리스트(회원여러명 주소로 찾기)
	 * 회원리스트(회원여러명 나이로 찾기)
	 */
	
	
	
	
	
}








