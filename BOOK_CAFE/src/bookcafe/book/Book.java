package bookcafe.book;

import java.io.Serializable;

public class Book implements Serializable, Comparable {
	
	/*
	 * 1. 멤버 변수
	 */
	
	/*
	 * 2. 생성자 2개
	 */
	
	/*
	 * 3. getter/setter
	 */
	int book_no;
	String book_name;
	String book_author;
	String book_pos;
    int book_stock;
	
    
    
    
    public Book() {
		// TODO Auto-generated constructor stub
	}
    
    //생성자
    public Book(int book_no, String book_name, String book_author, String book_pos, int book_stock) {
		super();
		this.book_no = book_no;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_pos = book_pos;
		this.book_stock = book_stock;
	}
    
    
    
	//getter,setter
    
    public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_pos() {
		return book_pos;
	}
	public void setBook_pos(String book_pos) {
		this.book_pos = book_pos;
	}
	public int getBook_stock() {
		return book_stock;
	}
	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}
    
    public static final int ASC =0;  
    public static final int DES =1;  
    public static final int ASCC =2;  
    public static final int DESS =3;  
	
    public static int choise= 0;
   
   
	@Override
	public int compareTo(Object o) {
		Book nextBook = (Book)o;
		if(Book.choise==Book.ASC) {
			return nextBook.getBook_name().compareTo(this.getBook_name());
		}else if (Book.choise==Book.DES) {
			return nextBook.getBook_author().compareTo(this.getBook_author());
		}else if(Book.choise==Book.ASCC) {
			return this.getBook_name().compareTo(nextBook.getBook_name());
		}else if(Book.choise==Book.DESS) {
			return this.getBook_author().compareTo(nextBook.getBook_author());
		}
		
		return 0;
	}
	
	/*
	@Override
	public String toString() {
		
		return + book_no+""+  book_name +""+ book_author+""+ book_pos+"" + book_stock+ "\n";
	}
    */
	
	@Override
	public String toString() {
		return book_no+" "+book_name +" "+ book_author+" "+ book_pos+" " + book_stock+ "\n";
	
	}
	
	
	
}
