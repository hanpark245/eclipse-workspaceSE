package bookcafe.menu;

import java.util.ArrayList;

// ** ���߽� ������ **
// outTime�ÿ� SalesService�ʿ� ���� �����ְ� Sales data�� ������ ���� ����ǵ��� �Ѵ�.
public class MenuService {
	MenuDao menuDao;
	public MenuService() throws Exception{
		menuDao = new MenuDao();
	}
	/* 
	 * table service �޼ҵ� ����
	 */
	public ArrayList<Menu> getMenuInfo(String order_no) throws Exception{
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		String[] order_split = order_no.split("/");//������������ �����ѹ���ü ��������
		int[] order_number = new int[order_split.length];//
		for (int i = 0; i < order_split.length; i++) {
			order_number[i] = Integer.parseInt(order_split[i]);
			Menu addMenu = menuDao.selectByNo(order_number[i]);
			menuList.add(addMenu);
		}	
		return menuList;
	}
	
	public int foodSales(ArrayList<Menu> menuList){
		int tot = 0;
		if(menuList != null){
			for (Menu menu : menuList) {
				tot += menu.getMenu_price();
			}
		}
		return tot;
	}
	//���������̺� �޴��̸� �ߺ������ؼ���ȯ
	public ArrayList<String> getOrderNames(ArrayList<Menu> menuList) {
		ArrayList<String> orderNames = new ArrayList<String>();
		for (Menu menu : menuList) {
			for (String orderName : orderNames) {
				if(!orderName.equals(menu.getMenu_name())){
					orderNames.add(menu.getMenu_name());
					System.out.println(orderNames);
				}
			}
		}
		return null;
	}
	//���������̺� ��ȣ�̸� �ߺ������� �ֹ�����������ȯ
	public ArrayList<Integer> getOrderCounts(ArrayList<Menu> menuList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * ����߰� / �������޾ƿ���
	 */

	
}
