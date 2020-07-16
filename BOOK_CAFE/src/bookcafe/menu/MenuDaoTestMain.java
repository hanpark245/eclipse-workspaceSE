package bookcafe.menu;

import java.util.ArrayList;

public class MenuDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		MenuDao menuDao=new MenuDao();
		
		System.out.println("-----insert--------");
		
		menuDao.insert(new Menu(Menu.AMERICANO,"�Ƹ޸�ī��",4000, 52));
		menuDao.insert(new Menu(Menu.ESPRESSO,"����������",4000, 23));
		menuDao.insert(new Menu(Menu.CARAMELMACCHIATO,"ļ��Ḷ���ƶ�",6000, 3));
		menuDao.insert(new Menu(Menu.CAFEMOCHA,"ī���ī",6000, 15));
		menuDao.insert(new Menu(Menu.CAFELATTE,"ī���",6000, 24));
		menuDao.insert(new Menu(Menu.VANILLALATTE,"�ٴҶ��",5500, 18));
		menuDao.insert(new Menu(Menu.GREENTEALATTE,"������",5500, 42));
		menuDao.insert(new Menu(Menu.FRAPPUCCINO,"����Ǫġ��",6000, 27));
		menuDao.insert(new Menu(Menu.COKE,"�ݶ�",2000, 4));
		menuDao.insert(new Menu(Menu.MOCHABUN,"��ī��",4000, 41));
		menuDao.insert(new Menu(Menu.CHEESECAKE,"ġ������ũ",5000, 9));
		menuDao.insert(new Menu(Menu.TIRAMISU,"Ƽ��̽�",5000, 14));
		menuDao.insert(new Menu(Menu.SANDWICH,"������ġ",4000, 5));
		menuDao.insert(new Menu(Menu.HONEYBREAD,"��Ϻ극��",6000, 22));
		menuDao.insert(new Menu(Menu.RAMEN,"���",3000, 30));
		menuDao.insert(new Menu(Menu.SPAGHETTI,"���İ�Ƽ",7000, 45));
		menuDao.insert(new Menu(Menu.DONKATSU,"���",7000, 12));
		menuDao.insert(new Menu(Menu.CURRY,"ī��",7000, 20));
		/*
		System.out.println("-----selectByNo--------");
		System.out.println("��ȣ 3���� �޴�");//�޴���ȣ��ȣ����
		Menu findProduct = menuDao.selectByNo(3);
		System.out.println(findProduct);
		
		
		System.out.println("-----selectAll--------");//�޴���ü�����ֱ�
		
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
		
		Menu updatemenu = new Menu(18,"ī��",8000, 25);//ī�� ���&���ݺ���
		
		menuDao.update(updatemenu);
		System.out.println(menuDao.selectByNo(18));
		*/
		/*
		 * ���İ˻�
		 * ������ü�����ֱ�
		 * �ֹ������� �����
		 */
		
	}

}
