package bookcafe.book;

import java.util.ArrayList;

public class BookService {

	private BookDao bookDao;
	public BookService() throws Exception{
		bookDao = new BookDao();
	}
	
	
	/*
	 * book service �޼ҵ� ����
	 */

	
	/*
	public void book_add(Book book) {
		booklist.add();
		
	}
	*/
	
	//å ���
	public boolean addBook(Book addbook) throws Exception{
		System.out.println(addbook);
		boolean succes=false;
		Book findbook = bookDao.selectByBook_add(addbook.getBook_name());
		if(findbook==null) {
				bookDao.insert(addbook);
			     succes=true;
				
		}else {
			succes=false;
		}
		  return succes;
	}
	
	//å ����
	public void delBook (int book_no) throws Exception{
		 bookDao.deleteByBook(book_no);
	}
	
	
	
	//å ���� ����
	public void updatBook (Book updateBook) throws Exception{
		bookDao.update(updateBook);
		
	}
	
	//������� ���� ����
	public ArrayList<Book> allViewBook() throws Exception{
		return bookDao.selectAll();
		//ArrayList<Book>temp = bookDao.selectAll();
		//return temp;
	}
	
	
	
	//å�̸� �˻�

	
	public ArrayList<Book> searchBook(String book_name) throws Exception{
                   ArrayList<Book> temp = bookDao.selectByBook(book_name);
		           return temp;
			}
	
	//�۰��̸� �˻� 
    public ArrayList<Book> searchAuhor(String book_auhor) throws Exception{
    	ArrayList<Book> temp = bookDao.selectByAuthor(book_auhor);
    	return temp;
    }
	
    //������ ����(����)
  public ArrayList<Book> sortBook_Up() throws Exception{
	  ArrayList<Book> temp = bookDao.sortByBook_Up();
	  return temp;
  }
	
	//������ ���� (����)
  public ArrayList<Book> sortBook_Down() throws Exception{
	  ArrayList<Book> temp = bookDao.sortByBook_Down();
	  return temp;
  }
  
  //�۰��� ����(����)
  public ArrayList<Book> sortAuhor_Up() throws Exception{
	  ArrayList<Book> temp = bookDao.sortByauhor_Up();
	  return temp;
  }
  
  //�۰��� ����(����)
  public ArrayList<Book> sortAuhor_Down() throws Exception{
	  ArrayList<Book> temp = bookDao.sortByauhor_Down();
	  return temp;
  }
  
  public Book searchBook(int no) throws Exception{
	  Book tempBook = bookDao.selectByNumber(no);
	  return tempBook;
  }
  
  //
  
  
  
  
}
