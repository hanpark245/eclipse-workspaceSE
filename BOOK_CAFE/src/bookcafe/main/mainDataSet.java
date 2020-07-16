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
		menuInit();		// �޴� �ʱ�ȭ
		bookInit();		// ���� �ʱ�ȭ
		selesInit();	// ���� �ʱ�ȭ
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
				
				bookDao.insert(new Book(1,"���μ��� ���������Ƿ�","���μ�", "H1", 5));
				bookDao.insert(new Book(2,"��γ�Ʈ","Ÿ���", "A1", 2));
				bookDao.insert(new Book(3,"������ ����","��ȫ��", "M1", 3));
				bookDao.insert(new Book(4,"����� �ϰڴٴµ�","����", "H1", 5));
				bookDao.insert(new Book(5,"������ ���� �ٺ��ΰ� ����","����Ű��ī��", "A1", 2));
				bookDao.insert(new Book(6,"��ü�� ����","��ȫ��", "M1", 3));
				bookDao.insert(new Book(7,"���� ���ƿ��� �Ƴ��� �� �׾���?","ī�ؽ�Ű", "S1", 1));
				bookDao.insert(new Book(8,"���°������Դϴ�","��ö", "T1", 2));
				bookDao.insert(new Book(9,"�ֳ������� �̻��ѻ���� ������","���ī ��Ʈ���", "B5", 2));
				bookDao.insert(new Book(10,"������������ư� �ڵ��ϴ¹�","�ο���׸�", "U3", 2));
				bookDao.insert(new Book(11,"��Ȧ���� ��Ƴ��¹�","���Ľ���", "E1", 2));
				bookDao.insert(new Book(12,"�������ϰ��ƶ�","�߸��پ�Ű��", "W1", 2));
				bookDao.insert(new Book(13,"�����������ϸ� �ȵǳ���","�������", "Q1", 2));
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
