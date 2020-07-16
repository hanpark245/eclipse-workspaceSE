package bookcafe.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * DAO(Data(File,DB,....) Access Object)
 *   - 멤버데이타를 저장하고있는 파일(테이블)에
 *     CRUD(Create,Read,Update,Delete) 단위작업을 하는 메소드
 *     단위메쏘드를 가지고있는 클래스
 *   - MemberService의 요청을받아서 Data Accessing에
 *     관련된 단위기능(Insert,select,update,delete 메쏘드)을 수행하는 객체
 */
public class BookDao {
	private File bookfile;
	public BookDao() throws Exception {
	bookfile=new File("book.dat");
	if(!bookfile.exists()) {bookfile.createNewFile();
		ObjectOutputStream oos = 
				new ObjectOutputStream(
						new FileOutputStream(bookfile));
		oos.writeObject(new ArrayList<Book>());
		oos.close();
	}
	}
	
	/*
	 * 파일읽기(연결)
	 */

	private ArrayList<Book> readData() throws Exception{
		ObjectInputStream ois = 
				new ObjectInputStream(
						new FileInputStream(bookfile));
		ArrayList<Book>booklist = (ArrayList<Book>)ois.readObject();
		return booklist;
	}
	
	
	/*
	 * 파일쓰기(저장)
	 */

	private void saveData(ArrayList<Book>booklist) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookfile));
        oos.writeObject(booklist);
        oos.flush();
        oos.close();
	}
	
	
	
	/*
	 * insert(멤버추가)
	 */
	public void insert(Book addBook)throws Exception{
		System.out.println("BookDao insert");
		ArrayList<Book> booklist =(ArrayList<Book>)this.readData();
		booklist.add(addBook);
		saveData(booklist);
		
		
	}
	/*
	 * select(read): 멤버 1개 select
	 */
	/*
	public Book selectByNo(int book_no)throws Exception{

		ArrayList<Book> booklist = this.readData();
		Book findbook = null;
		for (Book book : booklist) {
			if(book.getBook_no()==book_no) {
				findbook = book;
				break;
			}
		}
		return findbook;
	}
	*/
	
	
	
	 // select : 도서번호로 검색
	 
	
	public Book selectByNumber(int book_number) throws Exception{
		   ArrayList<Book> booklist = readData();
		   Book tempbook = new Book();
		   for (Book book : booklist) {
			   if(book.getBook_no() ==book_number) {
					tempbook=book;
		}
		}
		   return tempbook;
		
	}
	
	
	 // 도서번호로 검색_등록용
	 
	public Book selectByNumber_add(int book_number) throws Exception{
		   ArrayList<Book> booklist = this.readData();
		   Book tempNumber = null;
		   for (Book book : booklist) {
			if(book.getBook_no() == book_number) {
				tempNumber = book;
			}
		}
		   return tempNumber;
		
	}
	
	
	
	/*
	 * select(read) : 책 이름으로 검색(검색 메소드용_부분검색 가능)
	 */
	public ArrayList<Book> selectByBook(String book_name) throws Exception{
		   ArrayList<Book> booklist = readData();
		   ArrayList<Book> tempbook = new ArrayList<Book>();
		   for (Book book : booklist) {
			   if(book.getBook_name().contains(book_name)) {
					tempbook.add(book);
		}
		}
		   return tempbook;
		
	}
	
	/*
	 * select(read) : 책 이름으로 검색(도서등록 메소드용)
	 */
	public Book selectByBook_add(String book_name) throws Exception{
		   ArrayList<Book> booklist = this.readData();
		   Book tempBook = null;
		   for (Book book : booklist) {
			if(book.getBook_name().equals(book_name)) {
				tempBook = book;
				break;
			}
		}
		   return tempBook;
		
	}
	
	/*
	 * select(read) : 작가 이름으로 검색
	 */
	public ArrayList<Book> selectByAuthor(String author_name) throws Exception{
		   ArrayList<Book> booklist = readData();
		   ArrayList<Book> temp = new ArrayList<Book>();
		   for (Book book : booklist) {
			if(book.getBook_author().contains(author_name)) {
				temp.add(book);
			}
		}
		   return temp;
		
	}
	
	/*
	 *  select: 도서 목록 전부 보기
	 */
	
	public ArrayList<Book> selectAll() throws Exception{
		ArrayList<Book>booklist = this.readData();
		return booklist;
	}
	
	
	/*
	 * update :도서수정
	 */
	public void update(Book updateBook) throws Exception{
		System.out.println("BookDao update");
		ArrayList<Book> booklist = this.readData();
		for (Book book : booklist) {
			if(book.getBook_no()==updateBook.getBook_no()) {
				//book.setBook_no(updateBook.getBook_no());
				book.setBook_name(updateBook.getBook_name());
				book.setBook_author(updateBook.getBook_author());
				book.setBook_pos(updateBook.getBook_pos());
				book.setBook_stock(updateBook.getBook_stock());
				break;
			}
		}this.saveData(booklist);
		
		
	}
	
	
	
	/*
	 * delete : 도서삭제
	 */
	public void deleteByBook(int book_no) throws Exception{
		System.out.println("BookDao del");
		ArrayList<Book> booklist = (ArrayList<Book>)readData();
		for (Book book : booklist) {
			if(book.getBook_no()==book_no){
	        booklist.remove(book);
	        break;
		}
		}
		saveData(booklist);
	}
	
	/*
	 * 도서 정렬(도서-내림차순)
	 */
	
     public ArrayList<Book> sortByBook_Up() throws Exception{
    	 ArrayList<Book> booklist = (ArrayList<Book>)readData();
    	 Book.choise=Book.ASC;
    	 Object[] bookTemp = booklist.toArray();
    	 Arrays.sort(bookTemp);
    	 booklist.clear();
    	for (int i = 0; i < bookTemp.length; i++) {
    		Book bookemp = (Book)bookTemp[i];
			booklist.add(bookemp);
		}
    	 return booklist;
     }
	
     
     /*
      * 도서정렬 (도서-오름차순)
      */
     
     public ArrayList<Book> sortByBook_Down() throws Exception{
    	 ArrayList<Book> booklist = (ArrayList<Book>)readData();
    	 Book.choise=Book.ASCC;
    	 Object[] bookTemp = booklist.toArray();
    	 Arrays.sort(bookTemp);
    	 booklist.clear();
    	for (int i = 0; i < bookTemp.length; i++) {
    		Book bookemp = (Book)bookTemp[i];
			booklist.add(bookemp);
		}
    	 return booklist;
     }
     

	/*
	 * 도서정렬(작가-내림차순)
	 */
	
     public ArrayList<Book> sortByauhor_Up() throws Exception{
    	 ArrayList<Book> booklist = (ArrayList<Book>)readData();
    	 Book.choise=Book.DES;
    	 Object[] bookTemp = booklist.toArray();
    	 Arrays.sort(bookTemp);
    	 booklist.clear();
    	for (int i = 0; i < bookTemp.length; i++) {
    		Book bookemp = (Book)bookTemp[i];
			booklist.add(bookemp);
		}
    	 return booklist;
     }
     
     /*
      * 도서정렬(작가-오름차순)
      */
     public ArrayList<Book> sortByauhor_Down() throws Exception{
    	 ArrayList<Book> booklist = (ArrayList<Book>)readData();
    	 Book.choise=Book.DESS;
    	 Object[] bookTemp = booklist.toArray();
    	 Arrays.sort(bookTemp);
    	 booklist.clear();
    	for (int i = 0; i < bookTemp.length; i++) {
    		Book bookemp = (Book)bookTemp[i];
			booklist.add(bookemp);
		}
    	 return booklist;
     }
     
     
     
	
     
    	 
    }
     
     
    

