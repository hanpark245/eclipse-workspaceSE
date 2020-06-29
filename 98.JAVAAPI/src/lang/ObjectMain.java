package lang;

import java.util.Date;

public class ObjectMain {

	public static void main(String[] args) {
		/*
		 << Object >>
		 Class Object is the root of the class hierarchy.
		 Every class has Object as a superclass.
		 All objects, including arrays, 
		 implement the methods of this class.
		 */
		Object o1=new Object();
		Object o2=new Object();
		Object o3=o1;
		System.out.println("---------toString()---------");
		/*
		 << Object >>
		 public String toString()
		 */
		String str1= o1.toString();
		System.out.println(str1);
		System.out.println(o2.toString());
		System.out.println(o3.toString());
		
		ObjectChild oc1=new ObjectChild();
		System.out.println("ObjectChild에서 toString()재정의:"+oc1.toString());
		System.out.println(oc1);
		
		Date today=new Date();
		String dateStr = today.toString();
		System.out.println("Date클래스에서 toString()재정의:"+dateStr);
		System.out.println(today);
		System.out.println("---------equals()---------");
		/*
		  public boolean equals(Object obj)
		    -주소가같은지비교  
		 */
		
		boolean isEqual = o1.equals(o2);
		System.out.println("o1.equals(o2)-->"+isEqual);
		if(o1.equals(o3)) {
			System.out.println("o1과 o3의 주소가 동일하다");
		}
		if(o1.equals(o2)) {
			System.out.println("o1과 o2의 주소가 동일하다");
		}else {
			System.out.println("o1과 o2의 주소가 동일하지않다");
		}
		System.out.println("--------비교연산자[==]--------");
		if(o1==o3) {
			System.out.println("o1과 o3의 주소가 동일하다[ == ]");
		}
		
		if(o1!=o2) {
			System.out.println("o1과 o2의 주소가 동일하지않다[ != ]");
		}
		
		
	}

}
