package bookcafe.menu;

import java.util.ArrayList;

// ** 개발시 주의점 **
// outTime시에 SalesService쪽에 값을 보내주고 Sales data에 누적된 값이 저장되도록 한다.
public class MenuService {
	MenuDao menuDao;
	public MenuService() throws Exception{
		menuDao = new MenuDao();
	}
	/* 
	 * table service 메소드 구현
	 */
	public ArrayList<Menu> getMenuInfo(String order_no) throws Exception{
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		String[] order_split = order_no.split("/");//슬래시제외한 오더넘버객체 가져오기
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
	//퇴장한테이블 메뉴이름 중복제거해서반환
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
	//퇴장학테이블 번호이름 중복제거후 주문수량세서반환
	public ArrayList<Integer> getOrderCounts(ArrayList<Menu> menuList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * 재고추가 / 재고수량받아오기
	 */

	
}
