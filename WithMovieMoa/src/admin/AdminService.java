package admin;

import java.util.ArrayList;


public class AdminService {
	
	AdminDao adminDao;
	
	public AdminService() throws Exception {
		adminDao = new AdminDao();
	}
	
	
	
	/*
	 * ȸ������
	 * ���̵��ߺ��˻�
	 * �ߺ��� ���̵� �����ϸ� false
	 * �ߺ��� ���̵� �������������� true
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
	 * �α���
	 * return�� result���� ���� ����
	 * result=1 --> �α��μ���
	 * result=2 --> ��й�ȣ�� Ʋ��
	 * result=3 --> ���̵� �������� ����
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
	 * Ư�� ������ �˻� (ID��)
	 */
	
	public AdminVo findAdminById(String id) throws Exception {
		return adminDao.readOne(id);
	}
	
	/*
	 * ��� ������ �˻�
	 */
	public ArrayList<AdminVo> findAllAdmin() throws Exception {
		return adminDao.readAll();
	}
	
	/*
	 * ������ ������Ʈ
	 */
	public void adminUpdate(AdminVo updateAdmin) throws Exception {
		adminDao.update(updateAdmin);
	}
	
	/*
	 * ������ ����
	 */
	public void adminDelete(String id) throws Exception {
		adminDao.delete(id);
	}
}
