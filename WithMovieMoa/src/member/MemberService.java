package member;

import java.util.ArrayList;
/*
 	ȸ������������ �����Ұ�ü(Service, Manager)
 		- ȸ���������� ���ఴü
 		- ȸ���������� ����� Data Access�� ���õ� �۾���
 		  memberoDao�� ȣ���� CRUD�� 
 */
public class MemberService {
	/****************** Dao��ü����������� ********************/
	MemberDao memberDao;
	/***********************************************************/
	
	
	/****************** Dao��ü���������ü����********************/
	public MemberService() throws Exception {
		memberDao = new MemberDao();
	}
	/**************************************************************/
	
	
	/*
	 *	ȸ������ (Create)
	 */
	public boolean memberRegister(MemberVo newMember) throws Exception{
		boolean isSuccess = true;
		/*
		 * 	1. id�ߺ�üũ
		 * 		1-1. �ߺ�
		 * 		1-2. �ߺ�X
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
	 * 	ȸ���α���
	 * 	return 0 : ����
	 *         1 : ���̵��������
	 *         2 : �о����� ����ġ
	 */
	public int login(String id, String password) throws Exception{
		/*
		 * 1  . ȸ�����翩��
		 * 2-1. �����ϸ�  --> 2-1-1.�о������ --> ��ġ�ϸ�  --> 2 ��ȯ
		 * 2-2. ������ϸ�--> 0 ��ȯ
		 */
		int result = -999; //�ǹ̾��� ��
		
		/*
		 * 	return 0 : ����
		 *         1 : ���̵��������
		 *         2 : �о����� ����ġ
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
	 * 	ȸ���α׾ƿ�
	 */
	public void logout() {
		
	}
	
	
	/*
	 * 	ȸ���󼼺���(ȸ�� 1�� id find)
	 */
	public MemberVo findMemberById(String id) throws Exception{
		MemberVo findMember = null;
		findMember = memberDao.readOne(id);
		return findMember;
	}
	
	/*
	 * 	member search by name - ȸ���˻� ������ (new)
	 */
	public MemberVo findMemberByName(String name) throws Exception{
		
		 MemberVo findMember = null;
		 findMember = memberDao.readByName(name);
		return findMember;
		
	}
	
	/*
	 * 	member search by address - ȸ���˻� ������ (new)
	 */
	public MemberVo findMemberByAddress(String address) throws Exception{
		 MemberVo findMember = null;
		 findMember = memberDao.readByAddress(address);
		return findMember;
		
	}
	
	/*
	 * 	member search by phone number - ȸ���˻� ������ (new)
	 */
	public MemberVo findMemberByPhoneNo(String phoneNumber) throws Exception{
		 MemberVo findMember = null;
		 findMember = memberDao.readByPhoneNumber(phoneNumber);
		return findMember;
		
	}
	
	
	/*
	 * ȸ������Ʈ(ȸ�������� find) - ȸ������Ʈ, ����, ������ ���� table
	 */
	public ArrayList<MemberVo> findMemberByAll() throws Exception{
	   return memberDao.readAll();	
	}
	
	
	/*
	 * 	ȸ������ - id�� �������� ��ü ���� ���� (������ ���� �����ϰ�)
	 */
	public void memberUpdate(MemberVo updateMember) throws Exception {
		memberDao.update(updateMember);
		
	}
	
	
	/*
	 * 	ȸ��Ż�� (���̵�� ȸ�� �˻��ؼ� ����)
	 */
	public void memberDeRegister(String id) throws Exception {
		memberDao.delete(id);
		
	}
	
	/*
	 * 	ȸ��Ż�� (�̸��̶� �ڵ�����ȣ�� ȸ�� �˻��ؼ� ����) (new)
	 */
	public void memberDeRegister(String id, String phoneNumber) throws Exception {
		memberDao.delete(id, phoneNumber);
		
	}
	
}
