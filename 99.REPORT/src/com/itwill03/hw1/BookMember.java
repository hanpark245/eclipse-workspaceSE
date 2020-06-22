package com.itwill03.hw1;

public class BookMember 
{
	private int id;
	private String name;
	private String number;
	
	Book book = new Book();
	
	public BookMember(int id, String name, String number) 
	{
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public void print()
	{
		
		System.out.println("회원프린트");
		System.out.println("-------------------------------------------");

		System.out.println("회원번호\t이름\t\t전화번호");
		System.out.println(id + "\t\t" + name + "\t\t" + number);;
		book.print();
	}
}
