package member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class MemberDao {
	
	private File memberFile;
	public MemberDao() throws Exception {
		init();
	}
	private void init() throws Exception {
		memberFile = new File("members.ser");
		if (!memberFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(memberFile));
			oos.writeObject(new ArrayList<MemberVo>());
			oos.close();
			System.out.println("--------颇老积己[members.ser]---------");
		} else {
			System.out.println("--------颇老粮犁[members.ser]--------");
		}
	}
	private ArrayList<MemberVo> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(memberFile));
		ArrayList<MemberVo> memberList = (ArrayList<MemberVo>) ois.readObject();
		ois.close();
		return memberList;
	}
	private void writeFile(ArrayList<MemberVo> memberList)  throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(memberFile));
		oos.writeObject(memberList);
		oos.close();
	}
	/*
	 * Create
	 */
	public void create(MemberVo member) throws Exception {
		ArrayList<MemberVo> memberList = this.readFile();
		memberList.add(member);
		this.writeFile(memberList);
	}
	
	/*
	 * Read all
	 */
	public ArrayList<MemberVo> readAll() throws Exception {
		return readFile();
		
	}
	/*
	 * Read one
	 */
	
	public MemberVo readOne(String id) throws Exception {
		for (int i = 0; i < readFile().size(); i++) {
			MemberVo findMember = readFile().get(i);
			if (findMember.getId().equals(id)) {
				return findMember;
			}
		}		
		return null;
	}
	
	/*
	 * member search by name (new)
	 */
	public MemberVo readByName(String name) throws Exception {
		
		 for (int i = 0; i < readFile().size(); i++) {
			MemberVo findMember = readFile().get(i);
			if (findMember.getName().equals(name)) {
				return findMember;
			}
		}
			
		return null;
		 
	}
	/*
	 * member search by address (new)
	 */
	public MemberVo readByAddress(String address) throws Exception {
		
		 for (int i = 0; i < readFile().size(); i++) {
			MemberVo findMember = readFile().get(i);
			if (findMember.getAddress().equals(address)) {
				return findMember;
			}
		}
			
		return null;
		
	}
	/*
	 * member search by phone number (new)
	 */
	public MemberVo readByPhoneNumber(String phoneNumber) throws Exception {
		
		 for (int i = 0; i < readFile().size(); i++) {
			MemberVo findMember = readFile().get(i);
			if (findMember.getPhoneNumber().equals(phoneNumber)) {
				return findMember;
			}
		}
		
		return null;
		
	}
	
	
	/*
	 * Update
	 */
	public void update(MemberVo updateMember) throws Exception {
		ArrayList<MemberVo> memberList = this.readFile();		
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(updateMember.getId())) {
				memberList.set(i, updateMember);
				break;
			}
		}
		
		this.writeFile(memberList);
	}
	
	/*
	 * delete by name, phone number (new)
	 */
	public void delete(String id, String phoneNumber) throws Exception {
		ArrayList<MemberVo> memberList = this.readFile();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id) && memberList.get(i).getPhoneNumber().equals(phoneNumber)) {
				memberList.remove(i);
				break;
			}
		}
		this.writeFile(memberList);
	}
	
	/*
	 * Delete
	 */
	public void delete(String id) throws Exception {
		ArrayList<MemberVo> memberList = this.readFile();
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				memberList.remove(i);
				break;
			}
		}
		this.writeFile(memberList);
	}
	
	
}