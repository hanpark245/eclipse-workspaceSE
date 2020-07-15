package member;

import java.util.ArrayList;
/*
 	회원관리업무를 수행할객체(Service, Manager)
 		- 회원관리업무 수행객체
 		- 회원관리업무 수행시 Data Access에 관련된 작업을
 		  memberoDao를 호출해 CRUD를 
 */
public class MemberService {
	/****************** Dao객체멤버변수선언 ********************/
	MemberDao memberDao;
	/***********************************************************/
	
	
	/****************** Dao객체멤버변수객체생성********************/
	public MemberService() throws Exception {
		memberDao = new MemberDao();
	}
	/**************************************************************/
	
	
	/*
	 *	회원가입 (Create)
	 */
	public boolean memberRegister(MemberVo newMember) throws Exception{
		boolean isSuccess = true;
		/*
		 * 	1. id중복체크
		 * 		1-1. 중복
		 * 		1-2. 중복X
		 */
		
		ArrayList<MemberVo> memberList = memberDao.readAll();
		for (int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).getId().equals(newMember.getId())) {
				isSuccess = false;
				break;
			}
		}
		if(isSuccess) {
			memberDao.create(newMember);
		}
		
		return isSuccess;
	}
	
	
	/*
	 * 	회원로그인
	 * 	return 0 : 성공
	 *         1 : 아이디존재안함
	 *         2 : 패쓰워드 불일치
	 */
	public int login(String id, String password) throws Exception{
		/*
		 * 1  . 회원존재여부
		 * 2-1. 존재하면  --> 2-1-1.패쓰워드비교 --> 일치하면  --> 2 반환
		 * 2-2. 존재안하면--> 0 반환
		 */
		int result = -999; //의미없는 값
		
		/*
		 * 	return 0 : 성공
		 *         1 : 아이디존재안함
		 *         2 : 패쓰워드 불일치
		 */
		MemberVo findMember = memberDao.readOne(id);
		if(findMember != null) {
			if (findMember.getPassword().equals(password)) {
				result = 0;
			} else {
				result = 2;
			}
		}else {
			result = 1;
		}
		
		return result;
	}
	
	
	/*
	 * 	회원로그아웃
	 */
	public void logout() {
		
	}
	
	
	/*
	 * 	회원상세보기(회원 1명 id find)
	 */
	public MemberVo findMemberById(String id) throws Exception{
		MemberVo findMember = null;
		findMember = memberDao.readOne(id);
		return findMember;
	}
	
	/*
	 * 	member search by name - 회원검색 페이지 (new)
	 */
	public MemberVo findMemberByName(String name) throws Exception{
		
		 MemberVo findMember = null;
		 findMember = memberDao.readByName(name);
		return findMember;
		
	}
	
	/*
	 * 	member search by address - 회원검색 페이지 (new)
	 */
	public MemberVo findMemberByAddress(String address) throws Exception{
		 MemberVo findMember = null;
		 findMember = memberDao.readByAddress(address);
		return findMember;
		
	}
	
	/*
	 * 	member search by phone number - 회원검색 페이지 (new)
	 */
	public MemberVo findMemberByPhoneNo(String phoneNumber) throws Exception{
		 MemberVo findMember = null;
		 findMember = memberDao.readByPhoneNumber(phoneNumber);
		return findMember;
		
	}
	
	
	/*
	 * 회원리스트(회원여러명 find) - 회원리스트, 수정, 삭제에 들어가는 table
	 */
	public ArrayList<MemberVo> findMemberByAll() throws Exception{
	   return memberDao.readAll();	
	}
	
	
	/*
	 * 	회원수정 - id를 기준으로 전체 정보 수정 (마케팅 동의 제외하고)
	 */
	public void memberUpdate(MemberVo updateMember) throws Exception {
		memberDao.update(updateMember);
		
	}
	
	
	/*
	 * 	회원탈퇴 (아이디로 회원 검색해서 삭제)
	 */
	public void memberDeRegister(String id) throws Exception {
		memberDao.delete(id);
		
	}
	
	/*
	 * 	회원탈퇴 (이름이랑 핸드폰번호로 회원 검색해서 삭제) (new)
	 */
	public void memberDeRegister(String id, String phoneNumber) throws Exception {
		memberDao.delete(id, phoneNumber);
		
	}
	
}
