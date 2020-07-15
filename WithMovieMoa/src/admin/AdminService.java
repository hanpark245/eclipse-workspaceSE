package admin;

import java.util.ArrayList;


public class AdminService {
	
	AdminDao adminDao;
	
	public AdminService() throws Exception {
		adminDao = new AdminDao();
	}
	
	
	
	/*
	 * 회원가입
	 * 아이디중복검사
	 * 중복된 아이디가 존재하면 false
	 * 중복된 아이디가 존재하지않으면 true
	 */
	
	public boolean memberRegister(AdminVo newAdmin) throws Exception {
		boolean isSuccess = false;
		ArrayList<AdminVo> adminList = adminDao.readAll();
		for (AdminVo adminVo : adminList) {
			if(adminVo.getId().equals(newAdmin.getId())) {
				return isSuccess;
			}
		}
		isSuccess = true;
		adminDao.create(newAdmin);
		return isSuccess;
	}
	
	/*
	 * 로그인
	 * return된 result값에 따라 결정
	 * result=1 --> 로그인성공
	 * result=2 --> 비밀번호가 틀림
	 * result=3 --> 아이디가 존재하지 않음
	 * 
	 */
	public int login(String id, String password) throws Exception {
		int result = 1;
		AdminVo findAdmin = null;
		findAdmin = adminDao.readOne(id);
		if(findAdmin!=null) {
			if(findAdmin.getPassword().equals(password))
				return result;
			else {
				result = 2;
				return result;
			}
		}
		else {
			result = 3;
			return result;
		}
	}
	
	/*
	 * 특정 관리자 검색 (ID로)
	 */
	
	public AdminVo findAdminById(String id) throws Exception {
		return adminDao.readOne(id);
	}
	
	/*
	 * 모든 관리자 검색
	 */
	public ArrayList<AdminVo> findAllAdmin() throws Exception {
		return adminDao.readAll();
	}
	
	/*
	 * 관리자 업데이트
	 */
	public void adminUpdate(AdminVo updateAdmin) throws Exception {
		adminDao.update(updateAdmin);
	}
	
	/*
	 * 관리자 삭제
	 */
	public void adminDelete(String id) throws Exception {
		adminDao.delete(id);
	}
}
