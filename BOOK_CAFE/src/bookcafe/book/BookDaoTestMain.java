package bookcafe.book;

import java.util.ArrayList;

public class BookDaoTestMain {

	public static void main(String[] args) throws Exception {
		BookDao bookDao=new BookDao();
		
		System.out.println("-----insert--------");
		
		bookDao.insert(new Book(1,"설민석의 조선왕조실록","설민석", "H1", 5));
		bookDao.insert(new Book(2,"블로노트","타블로", "A1", 2));
		bookDao.insert(new Book(3,"자존감 수업","윤홍균", "M1", 3));
		bookDao.insert(new Book(4,"낭만적 연애와 그 후의 일상","알랭 드 보통", "S1", 1));
		bookDao.insert(new Book(6,"오늘은 이 바람만 느껴줘","청춘유리", "T1", 2));
		
		/*
		System.out.println("-----selectAll--------");
		ArrayList<Book> productList=bookDao.selectAll();
		for (Book Book : productList) {
			System.out.println(Book);
		}
		*/
		
		
		System.out.println("책 제목 정렬=내림차순");
		ArrayList<Book> sorProduct = bookDao.sortByBook_Up();
		System.out.println(sorProduct);
		
		System.out.println("-----selectByNo--------");
		System.out.println("제목 검색");
		ArrayList<Book> findProduct = bookDao.selectByBook("블로");
		System.out.println(findProduct);
		
		
		/*System.out.println("번호 검색");
		ArrayList<Book> findProduct1 = bookDao.selectByNumber(3);
		System.out.println(findProduct1);*/
		
		System.out.println("작가 검색");
		ArrayList<Book> findProduct2 = bookDao.selectByAuthor("타");
		System.out.println(findProduct2);
		
		
		System.out.println("-----delete--------");
		bookDao.deleteByBook(0);
		
		System.out.println("-----update--------");
		Book updateBook = new Book(3,"자존감 수업","윤홍균", "M2", 5);
		bookDao.update(updateBook);		
		
         
		
		
		
		
		System.out.println("도서정렬-오름차순");
		ArrayList<Book> sorProduct3 = bookDao.sortByBook_Down();
		System.out.println(sorProduct3);
		
	
		System.out.println("정렬2");
		ArrayList<Book> sorProduct2 = bookDao.sortByauhor_Down();
		System.out.println(sorProduct2);
	
	
	
	
	
	
	}
	

}
