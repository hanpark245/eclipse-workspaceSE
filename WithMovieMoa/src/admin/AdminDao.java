package admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class AdminDao {
	
	private File AdminFile;
	public AdminDao() throws Exception {
		init();
	}
	
	private void init() throws Exception {
		AdminFile = new File("admins.ser");
		if (!AdminFile.exists()) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AdminFile));
			oos.writeObject(new ArrayList<AdminVo>());
			oos.close();
			System.out.println("--------颇老积己[members.ser]---------");
		} else {
			System.out.println("--------颇老粮犁[members.ser]--------");
		}
	}
	
	private ArrayList<AdminVo> readFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(AdminFile));
		ArrayList<AdminVo> AdminList = (ArrayList<AdminVo>) ois.readObject();
		ois.close();
		return AdminList;
	}
	
	private void writeFile(ArrayList<AdminVo> adminList)  throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AdminFile));
		oos.writeObject(adminList);
		oos.close();
	}
	
	/*
	 * Create
	 */
	public void create(AdminVo admin) throws Exception {
		ArrayList<AdminVo> adminList = this.readFile();
		adminList.add(admin);
		this.writeFile(adminList);
	}
	
	/*
	 * Read all
	 */
	public ArrayList<AdminVo> readAll() throws Exception {
		return readFile();
		
	}
	
	/*
	 * Read one
	 */
	public AdminVo readOne(String id) throws Exception {
		for (int i = 0; i < readFile().size(); i++) {
			AdminVo findAdmin = readFile().get(i);
			if (findAdmin.getId().equals(id)) {
				return findAdmin;
			}
		}		
		return null;
	}
	
	/*
	 * Update
	 */
	public void update(AdminVo updateAdmin) throws Exception {
		ArrayList<AdminVo> adminList = this.readFile();		
		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getId().equals(updateAdmin.getId())) {
				adminList.set(i, updateAdmin);
				break;
			}
		}
		this.writeFile(adminList);
	}
	
	/*
	 * Delete
	 */
	public void delete(String id) throws Exception {
		ArrayList<AdminVo> adminList = this.readFile();
		for (int i = 0; i < adminList.size(); i++) {
			if (adminList.get(i).getId().equals(id)) {
				adminList.remove(i);
				break;
			}
		}
		this.writeFile(adminList);
	}
}