package com.itwill03.hw1;

public class Book 
{
	private int bookNo;
	private String title;
	private String genre;
	private String note;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(int bookNo, String title, String genre, String note) 
	{
		this.bookNo = bookNo;
		this.title = title;
		this.genre = genre;
		this.note = note;
	}
	public void print()
	{
		System.out.println("-------------------------------------------");
		System.out.println("번호\t제목\t\t장르\t설명");
		System.out.println(bookNo + "\t" + title + "\t" + genre + "\t" + note);
		System.out.println("-------------------------------------------");
	}
	
}
