package lang;

import java.util.Date;

public class objectMain 
{
	public static void main(String[] args) 
	{
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = o1;
		System.out.println("---------------------------toString------------------------");
		String str1 =  o1.toString();
		System.out.println(str1);
		System.out.println(o2.toString());
		System.out.println(o3.toString());
		
		ObjectChild oc1 = new ObjectChild();
		System.out.println("ObjectChild에서 toString()재정의:" + oc1.toString());
		Date today = new Date();
		String dateStr = today.toString();
		System.out.println("Date 클래스에서 toStirng() 재정의: " + dateStr);
		System.out.println(today);
		System.out.println("---------------------------eqauls()------------------------");

		/*
		 * public boolean equals(Object obj)
		 * 	-주소가 같은지 비교
		 */
		boolean isEqual = o1.equals(o3);
		System.out.println("o1.equals()o3  ==> " + isEqual);
		if(o1.equals(o3))
		{
			System.out.println("o1과 o3의 주소가 동일하다");
		}
		if(o1.equals(o2))
		{
			System.out.println("o1과 o2의 주소가 동일하다");
		}
		else
		{
			System.out.println("o1과 o2의 주소가 동일하지 않다");
		}
		System.out.println("------------비교연산자(==)----------");
		if(o1 == o3)
		{
			System.out.println("o1과 o3의 주소가 동일하다 (==)");
		}
		if(o2 != o1)
		{
			System.out.println("o1과 o3의 주소가 동일하지 않다 (!=)");
		}
	}
}
