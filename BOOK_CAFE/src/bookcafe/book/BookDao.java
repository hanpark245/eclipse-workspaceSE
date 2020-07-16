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
 *   - �������Ÿ�� �����ϰ��ִ� ����(���̺�)��
 *     CRUD(Create,Read,Update,Delete) �����۾��� �ϴ� �޼ҵ�
 *     �����޽�带 �������ִ� Ŭ����
 *   - MemberService�� ��û���޾Ƽ� Data Accessing��
 *     ���õ� �������(Insert,select,update,delete �޽��)�� �����ϴ� ��ü
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
	 * �����б�(����)
	 */

	private ArrayList<Book> readData() throws Exception{
		ObjectInputStream ois = 
				new ObjectInputStream(
						new FileInputStream(bookfile));
		ArrayList<Book>booklist = (ArrayList<Book>)ois.readObject();
		return booklist;
	}
	
	
	/*
	 * ���Ͼ���(����)
	 */

	private void saveData(ArrayList<Book>booklist) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(bookfile));
        oos.writeObject(booklist);
        oos.flush();
        oos.close();
	}
	
	
	
	/*
	 * insert(����߰�)
	 */
	public void insert(Book addBook)throws Exception{
		System.out.println("BookDao insert");
		ArrayList<Book> booklist =(ArrayList<Book>)this.readData();
		booklist.add(addBook);
		saveData(booklist);
		
		
	}
	/*
	 * select(read): ��� 1�� select
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
	
	
	
	 // select : ������ȣ�� �˻�
	 
	
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
	
	
	 // ������ȣ�� �˻�_��Ͽ�
	 
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
	 * select(read) : å �̸����� �˻�(�˻� �޼ҵ��_�κа˻� ����)
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
	 * select(read) : å �̸����� �˻�(������� �޼ҵ��)
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
	 * select(read) : �۰� �̸����� �˻�
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
	 *  select: ���� ��� ���� ����
	 */
	
	public ArrayList<Book> selectAll() throws Exception{
		ArrayList<Book>booklist = this.readData();
		return booklist;
	}
	
	
	/*
	 * update :��������
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
	 * delete : ��������
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
	 * ���� ����(����-��������)
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
      * �������� (����-��������)
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
	 * ��������(�۰�-��������)
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
      * ��������(�۰�-��������)
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
     
     
    

