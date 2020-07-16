package bookcafe.book;

import java.util.ArrayList;

public class BookDaoTestMain {

	public static void main(String[] args) throws Exception {
		BookDao bookDao=new BookDao();
		
		System.out.println("-----insert--------");
		
		bookDao.insert(new Book(1,"���μ��� ���������Ƿ�","���μ�", "H1", 5));
		bookDao.insert(new Book(2,"��γ�Ʈ","Ÿ���", "A1", 2));
		bookDao.insert(new Book(3,"������ ����","��ȫ��", "M1", 3));
		bookDao.insert(new Book(4,"������ ���ֿ� �� ���� �ϻ�","�˷� �� ����", "S1", 1));
		bookDao.insert(new Book(6,"������ �� �ٶ��� ������","û������", "T1", 2));
		
		/*
		System.out.println("-----selectAll--------");
		ArrayList<Book> productList=bookDao.selectAll();
		for (Book Book : productList) {
			System.out.println(Book);
		}
		*/
		
		
		System.out.println("å ���� ����=��������");
		ArrayList<Book> sorProduct = bookDao.sortByBook_Up();
		System.out.println(sorProduct);
		
		System.out.println("-----selectByNo--------");
		System.out.println("���� �˻�");
		ArrayList<Book> findProduct = bookDao.selectByBook("���");
		System.out.println(findProduct);
		
		
		/*System.out.println("��ȣ �˻�");
		ArrayList<Book> findProduct1 = bookDao.selectByNumber(3);
		System.out.println(findProduct1);*/
		
		System.out.println("�۰� �˻�");
		ArrayList<Book> findProduct2 = bookDao.selectByAuthor("Ÿ");
		System.out.println(findProduct2);
		
		
		System.out.println("-----delete--------");
		bookDao.deleteByBook(0);
		
		System.out.println("-----update--------");
		Book updateBook = new Book(3,"������ ����","��ȫ��", "M2", 5);
		bookDao.update(updateBook);		
		
         
		
		
		
		
		System.out.println("��������-��������");
		ArrayList<Book> sorProduct3 = bookDao.sortByBook_Down();
		System.out.println(sorProduct3);
		
	
		System.out.println("����2");
		ArrayList<Book> sorProduct2 = bookDao.sortByauhor_Down();
		System.out.println(sorProduct2);
	
	
	
	
	
	
	}
	

}
