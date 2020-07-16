package bookcafe.menu;
/*
 * DAO(Data(File,DB,....) Access Object)
 *   - �������Ÿ�� �����ϰ��ִ� ����(���̺�)��
 *     CRUD(Create,Read,Update,Delete) �����۾��� �ϴ� �޼ҵ�
 *     �����޽�带 �������ִ� Ŭ����
 *   - MemberService�� ��û���޾Ƽ� Data Accessing��
 *     ���õ� �������(Insert,select,update,delete �޽��)�� �����ϴ� ��ü
 */
// Food ��ü�� read, update(���)�� ������ ��.


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;



public class MenuDao {
	
	
	public MenuDao() throws Exception {
		init();
	}
	
	/*************copy & paste*************/	
	private File file;
	/*
	 * �ʱ�ȭ�޽��
	 */
	private void init() throws Exception{
		file = new File("menu.dat");
		if (!file.exists()) {
			file.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(new ArrayList<Menu>());
			oos.close();
		}
	}
	/*
	 * �����б�(����)
	 */
	private ArrayList<Menu> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Menu> menuList = (ArrayList<Menu>) ois.readObject();
		return  menuList;
	}

	/*
	 * ���Ͼ���(��������)
	 */
	private void saveData(ArrayList<Menu> menuList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(menuList);
		oos.flush();
		oos.close();
	}
	
	public void addMenu(Menu addMenu) throws Exception{//�޴��߰�
		
	}
	public void insert(Menu product)throws Exception{
		ArrayList<Menu> menuList = this.readData();
		menuList.add(product);
		this.saveData(menuList);
	}
	public Menu selectByNo(int no) throws Exception{
		Menu findMenu=null;
		ArrayList<Menu> menuList=this.readData();
		for (Menu menu : menuList) {
			if(menu.getMenu_no()==no){
				findMenu=menu;
				break;
			}
		}
		return findMenu;
	}
	public Menu selectByStock(int stock) throws Exception{
		Menu findMenu=null;
		ArrayList<Menu> menuList=this.readData();
		for (Menu menu : menuList) {
			if(menu.getMenu_stock()==stock){
				findMenu=menu;
				break;
			}
		}
		
		return findMenu;
		
	}
	public void update(Menu updateFood) throws Exception{
		ArrayList<Menu> menuList = this.readData();
		for (Menu menu : menuList) {
			if(menu.getMenu_no()==updateFood.getMenu_no()){
				menu.setMenu_name(updateFood.getMenu_name());
				menu.setMenu_price(updateFood.getMenu_price());
				menu.setMenu_stock(updateFood.getMenu_stock());
				
				break;
				
			}
		}
	}
	
	public void delete(int no) throws Exception{
		ArrayList<Menu> menuList=this.readData();
		for (Menu menu : menuList) {
			if(menu.getMenu_no()==no){
				menuList.remove(menu);
				break;
			}
		}
		this.saveData(menuList);
		
		
	}
	
	public ArrayList<Menu> selectAll() throws Exception{
		ArrayList<Menu> menuList = this.readData();
		
		return menuList ;
	}
	
	
	
}
