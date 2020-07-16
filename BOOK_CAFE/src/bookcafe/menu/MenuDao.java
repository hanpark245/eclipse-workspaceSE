package bookcafe.menu;
/*
 * DAO(Data(File,DB,....) Access Object)
 *   - 멤버데이타를 저장하고있는 파일(테이블)에
 *     CRUD(Create,Read,Update,Delete) 단위작업을 하는 메소드
 *     단위메쏘드를 가지고있는 클래스
 *   - MemberService의 요청을받아서 Data Accessing에
 *     관련된 단위기능(Insert,select,update,delete 메쏘드)을 수행하는 객체
 */
// Food 객체는 read, update(재고)만 있으면 됨.


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
	 * 초기화메쏘드
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
	 * 파일읽기(연결)
	 */
	private ArrayList<Menu> readData() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		ArrayList<Menu> menuList = (ArrayList<Menu>) ois.readObject();
		return  menuList;
	}

	/*
	 * 파일쓰기(연결해제)
	 */
	private void saveData(ArrayList<Menu> menuList) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(menuList);
		oos.flush();
		oos.close();
	}
	
	public void addMenu(Menu addMenu) throws Exception{//메뉴추가
		
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
