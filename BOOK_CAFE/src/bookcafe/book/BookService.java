package bookcafe.book;

import java.util.ArrayList;

public class BookService {

	private BookDao bookDao;
	public BookService() throws Exception{
		bookDao = new BookDao();
	}
	
	
	/*
	 * book service 메소드 구현
	 */

	
	/*
	public void book_add(Book book) {
		booklist.add();
		
	}
	*/
	
	//책 등록
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
	
	//책 삭제
	public void delBook (int book_no) throws Exception{
		 bookDao.deleteByBook(book_no);
	}
	
	
	
	//책 정보 수정
	public void updatBook (Book updateBook) throws Exception{
		bookDao.update(updateBook);
		
	}
	
	//도서목록 전부 보기
	public ArrayList<Book> allViewBook() throws Exception{
		return bookDao.selectAll();
		//ArrayList<Book>temp = bookDao.selectAll();
		//return temp;
	}
	
	
	
	//책이름 검색

	
	public ArrayList<Book> searchBook(String book_name) throws Exception{
                   ArrayList<Book> temp = bookDao.selectByBook(book_name);
		           return temp;
			}
	
	//작가이름 검색 
    public ArrayList<Book> searchAuhor(String book_auhor) throws Exception{
    	ArrayList<Book> temp = bookDao.selectByAuthor(book_auhor);
    	return temp;
    }
	
    //도서명 정렬(내림)
  public ArrayList<Book> sortBook_Up() throws Exception{
	  ArrayList<Book> temp = bookDao.sortByBook_Up();
	  return temp;
  }
	
	//도서명 정렬 (오름)
  public ArrayList<Book> sortBook_Down() throws Exception{
	  ArrayList<Book> temp = bookDao.sortByBook_Down();
	  return temp;
  }
  
  //작가명 정렬(내림)
  public ArrayList<Book> sortAuhor_Up() throws Exception{
	  ArrayList<Book> temp = bookDao.sortByauhor_Up();
	  return temp;
  }
  
  //작가명 정렬(오름)
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
