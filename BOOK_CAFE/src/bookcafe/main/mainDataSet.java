package bookcafe.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bookcafe.book.Book;
import bookcafe.book.BookDao;
import bookcafe.menu.Menu;
import bookcafe.menu.MenuDao;
import bookcafe.sales.Sales;
import bookcafe.sales.SalesDao;

public class mainDataSet {
	public mainDataSet() throws Exception {
		menuInit();		// 메뉴 초기화
		bookInit();		// 도서 초기화
		selesInit();	// 매출 초기화
	}

	private void selesInit() throws IOException {
		File salesFile;
		
		salesFile = new File("sales.dat");
		if(!salesFile.exists()){
			salesFile.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(salesFile));
			oos.writeObject(new ArrayList<Sales>());
			oos.close();		
		
			try {
				SalesDao salesDao = new SalesDao();			
				
				salesDao.insert(new Sales("2016/10/01", 160000, 80000, 80000));
				salesDao.insert(new Sales("2016/09/30", 270000, 190000, 80000));
				salesDao.insert(new Sales("2016/09/29", 160000, 80000, 80000));
				salesDao.insert(new Sales("2016/09/28", 330000, 270000, 60000));
				salesDao.insert(new Sales("2016/08/16", 570000, 270000, 300000));
				salesDao.insert(new Sales("2016/07/03", 740000, 240000, 500000));
				salesDao.insert(new Sales("2016/06/30", 260000, 160000, 100000));
				salesDao.insert(new Sales("2016/05/04", 1532000, 532000, 1000000));
				salesDao.insert(new Sales("2016/04/12", 224000, 110000, 114000));
				salesDao.insert(new Sales("2016/03/21", 753000, 245000, 508000));
				salesDao.insert(new Sales("2016/02/15", 4752000, 2452000, 2300000));
				salesDao.insert(new Sales("2016/01/08", 640000, 255000, 385000));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	private void bookInit() throws IOException {
		File bookfile;

		bookfile=new File("book.dat");
		if(!bookfile.exists()) {bookfile.createNewFile();
			ObjectOutputStream oos = 
					new ObjectOutputStream(
							new FileOutputStream(bookfile));
			oos.writeObject(new ArrayList<Book>());
			oos.close();		
		
			try {
				BookDao bookDao=new BookDao();
				
				bookDao.insert(new Book(1,"설민석의 조선왕조실록","설민석", "H1", 5));
				bookDao.insert(new Book(2,"블로노트","타블로", "A1", 2));
				bookDao.insert(new Book(3,"자존감 수업","윤홍균", "M1", 3));
				bookDao.insert(new Book(4,"배신좀 하겠다는데","위리", "H1", 5));
				bookDao.insert(new Book(5,"사장은 차라리 바보인게 낫다","스즈키다카시", "A1", 2));
				bookDao.insert(new Book(6,"우체부 슈발","윤홍균", "M1", 3));
				bookDao.insert(new Book(7,"집에 돌아오니 아내가 또 죽었네?","카준스키", "S1", 1));
				bookDao.insert(new Book(8,"나는개새끼입니다","정철", "T1", 2));
				bookDao.insert(new Book(9,"왜내옆에는 이상한사람이 많을까","모니카 비트블룸", "B5", 2));
				bookDao.insert(new Book(10,"유지보수가어렵게 코딩하는법","로에디그린", "U3", 2));
				bookDao.insert(new Book(11,"블랙홀에서 살아남는법","폴파슨스", "E1", 2));
				bookDao.insert(new Book(12,"생각좀하고살아라","야마다아키오", "W1", 2));
				bookDao.insert(new Book(13,"바지벗고일하면 안되나요","스콧버쿤", "Q1", 2));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void menuInit() throws Exception {
		File file;
		
		file = new File("menu.dat");
		if (!file.exists()) {
			file.createNewFile();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(new ArrayList<Menu>());
			oos.close();
		
			MenuDao menuDao;
			
			try {
				menuDao = new MenuDao();	
			
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
