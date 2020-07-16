package bookcafe.menu;

import java.util.ArrayList;

public class MenuDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		MenuDao menuDao=new MenuDao();
		
		System.out.println("-----insert--------");
		
		menuDao.insert(new Menu(Menu.AMERICANO,"아메리카노",4000, 52));
		menuDao.insert(new Menu(Menu.ESPRESSO,"에스프레소",4000, 23));
		menuDao.insert(new Menu(Menu.CARAMELMACCHIATO,"캬라멜마끼아또",6000, 3));
		menuDao.insert(new Menu(Menu.CAFEMOCHA,"카페모카",6000, 15));
		menuDao.insert(new Menu(Menu.CAFELATTE,"카페라떼",6000, 24));
		menuDao.insert(new Menu(Menu.VANILLALATTE,"바닐라라떼",5500, 18));
		menuDao.insert(new Menu(Menu.GREENTEALATTE,"녹차라떼",5500, 42));
		menuDao.insert(new Menu(Menu.FRAPPUCCINO,"프라푸치노",6000, 27));
		menuDao.insert(new Menu(Menu.COKE,"콜라",2000, 4));
		menuDao.insert(new Menu(Menu.MOCHABUN,"모카번",4000, 41));
		menuDao.insert(new Menu(Menu.CHEESECAKE,"치즈케이크",5000, 9));
		menuDao.insert(new Menu(Menu.TIRAMISU,"티라미슈",5000, 14));
		menuDao.insert(new Menu(Menu.SANDWICH,"샌드위치",4000, 5));
		menuDao.insert(new Menu(Menu.HONEYBREAD,"허니브레드",6000, 22));
		menuDao.insert(new Menu(Menu.RAMEN,"라면",3000, 30));
		menuDao.insert(new Menu(Menu.SPAGHETTI,"스파게티",7000, 45));
		menuDao.insert(new Menu(Menu.DONKATSU,"돈까스",7000, 12));
		menuDao.insert(new Menu(Menu.CURRY,"카레",7000, 20));
		/*
		System.out.println("-----selectByNo--------");
		System.out.println("번호 3번인 메뉴");//메뉴번호로호출기능
		Menu findProduct = menuDao.selectByNo(3);
		System.out.println(findProduct);
		
		
		System.out.println("-----selectAll--------");//메뉴전체보여주기
		
		ArrayList<Menu> menuList=menuDao.selectAll();
		for (Menu menu : menuList) {
			System.out.println(menu);
		}
		
		System.out.println("-----delete--------");
		
		menuDao.delete(1);
		menuList=menuDao.selectAll();
		for (Menu menu : menuList) {
			System.out.println(menu);
		}
		
		System.out.println("-----update--------");
		
		Menu updatemenu = new Menu(18,"카레",8000, 25);//카레 재고&가격변경
		
		menuDao.update(updatemenu);
		System.out.println(menuDao.selectByNo(18));
		*/
		/*
		 * 음식검색
		 * 음식전체보여주기
		 * 주문갯수비교 재고변경
		 */
		
	}

}
