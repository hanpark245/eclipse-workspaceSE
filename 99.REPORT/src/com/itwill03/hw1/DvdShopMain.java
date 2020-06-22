package com.itwill03.hw1;

public class DvdShopMain 
{
	public static void main(String[] args) 
	{
		DvdMember member1 = new DvdMember(0000, "박강한" , "010-8330-9845");
		Dvd dvd = new Dvd();
		
		
		dvd.setDvd(1234, "인터스텔러" , "Sci-Fi");
		member1.dvd = dvd;		
		System.out.println(member1.dvd.title);
	}
}
