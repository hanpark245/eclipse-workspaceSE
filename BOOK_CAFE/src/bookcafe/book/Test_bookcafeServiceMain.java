package bookcafe.book;

import java.util.ArrayList;

public class Test_bookcafeServiceMain {

	public static void main(String[] args) throws Exception {

	BookService bookSevice = new BookService();
	
	
	bookSevice.addBook(new Book(9, "�޷��� ââ", "��â��", "AA", 3));	
		
	//bookSevice.delBook(6);
	
	
	ArrayList<Book>temp1 = bookSevice.searchAuhor("���");
	System.out.println(temp1);
	
	
	ArrayList<Book>temp = bookSevice.allViewBook();
	System.out.println(temp);
	
		
		
		
	}

}
