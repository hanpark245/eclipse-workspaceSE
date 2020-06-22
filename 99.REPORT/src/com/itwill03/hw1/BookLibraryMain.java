package com.itwill03.hw1;

public class BookLibraryMain {

	public static void main(String[] args) 
	{
		BookMember member1 = new BookMember(1234, "박강한", "010-8330-9845");
		Book book = new Book(1234, "노인과 바다", "클래식", "꿀잼");
		member1.book = book;
		
		System.out.println(member1);
		
		member1.print();
	}
}	
	
