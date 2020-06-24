/*
 객체의 형변환
   1. 부모자식관계에있는 클래스 틀에서만 가능하다.
   
   2. 자식객체를 부모클래스타입으로 형변환
       - 자동으로 이루어진다(묵시적)
       Child c = new Child();
       Parent pppp = c; 
       주소는 바뀌지 않는다
       
       
       
   3. 부모 객체를 자식클래스타입으로 형변환
       - 원칙적으로는 불가능하다
       - 부모의 탈을쓴 자식객체 는 가능하다.
       Parent p=new Parent();
       Child cccc = p;(X)
    public class Parent{}
    public class Child extends Parent{}
 */
public class ParentChildObjectCastingMain 
{
	public static void main(String[] args) 
	{
		System.out.println("------------Child----------");
		Child c1 = new Child();
		c1.method1();
		c1.method2();
		c1.method3();
		c1.method4();
		c1.method5();
		/*  
		   2. 자식객체를 부모클래스타입으로 형변환
		       - 자동으로 이루어진다(묵시적)
		       Child c = new Child();
		       Parent pppp = c; 
		       주소는 바뀌지 않는다
		       
		*/
		System.out.println("------------ Child >> Parent ----------");
		Parent p1 = c1;
		p1.method1();
		p1.method2();
		
		//재정의된 메쏘드는 Parent Type 으로도 자식의 메쏘드가 호출이 된다. 
		p1.method3();
		
		p1.method4();
		//p1.method5();
		
		System.out.println("------------Parent >> Child-----------");
		/************************************************************
		   3. 부모 객체를 자식클래스타입으로 형변환
	       - 자동적으로 이루어지지 않는다(명시적)
	       - 원칙적으로는 불가능하다
	       - 부모의 탈을쓴 자식객체 는 가능하다.
	       Parent p=new Parent();
	       Child cccc = p;(X)
	    public class Parent{}
	    public class Child extends Parent{}
	    */
		Parent p2 = new Parent();
		// 		<<실행시에 ClassCastException 발생>>
		//Child c2 = (Child)p2;  		ERROR
		
		
		//부모의 탈을 쓴 자식객체
		Parent p3 = new Child();
		Child c3 = (Child)p3;	
		c3.method1();
		c3.method2();
		c3.method3();
		c3.method4();
		c3.method5();
	}
}
