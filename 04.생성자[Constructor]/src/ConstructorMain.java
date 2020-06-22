class Constructor
{
	private int member1;
	private int member2;
	private int member3;
	
	//생성자 오버로딩	
	public Constructor() 
	{
		System.out.println("Constructor()기본생성자 메소드 실행:" + this);
		this.member1 = 900;
		this.member2 = 700;
	}
	public Constructor(int member)
	{
		System.out.println("Constructor()기본생성자 메소드 실행:" + this);
		this.member1 = member;
		this.member2 = 9999;
	}
	public Constructor(int member1, int member2)
	{
		System.out.println("Constructor()기본생성자 메소드 실행:" + this);
		this.member1 = member1;
		this.member2 = member2;
	}
	public Constructor(int member1, int member2, int member3)
	{
		System.out.println("Constructor()기본생성자 메소드 실행:" + this);
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
	}
	public void print()
	{
		System.out.println("member1: " + this.member1);
		System.out.println("member2: " + this.member2);
	}
	
	
	public int getMember1() 
	{
		return member1;
	}
	public void setMember1(int member1) 
	{
		this.member1 = member1;
	}
	public int getMember2() 
	{
		return member2;
	}
	public void setMember2(int member2) 
	{
		this.member2 = member2;
	}
	public void setConstructorData(int member1,int member2) 
	{
		this.member1=member1;
		this.member2=member2;
	}		
	
}



public class ConstructorMain 
{
	public static void main(String[] args) 
	{
		Constructor c1 = new Constructor();
		//System.out.println(c1);
		c1.print();
		
		Constructor c2 = new Constructor(2309);
		c2.print();
		
		Constructor c3 = new Constructor(323, 2424);
		c3.print();
		
		Constructor c4 = new Constructor();
		c4.print();
		
		Constructor c5 = new Constructor(323, 2424, 2323);
		c5.print();
		DefaultConstructor dc=new DefaultConstructor();
		System.out.println(dc);
	}
}





/*
생성자(constructor)
1. 클래스 이름과동일하며 리턴타입을 명시하지않는 메쏘드(???)
2. 하나의 클래스에는 반드시 하나이상의 생성자가 존재하여야한다
--> 생성자를 정의하지않을경우 컴파일러는 인자가하나도없는
    생성자(디폴트생성자 혹은 기본생성자)를 자동으로 넣어서 컴파일한다.    
3. 객체생성시 단한번 호출된다.
4. 주로 객체 멤버변수 초기화의 용도로 사용한다.
5. 객체를 생성할려면 반드시 생성자를 호출하여야한다.
	
	-형태: 
	 	public class Test{
	 		//생성자의 정의(선언)
	 	    public Test(){
	 	    }
	 	}
	 	
    -사용: 
           Test t = new Test(); 
	 	   클래스명 참조변수이름 = new 클래스명();
	 	   new 라는 연산자는 반드시 생성자 앞에있어야하며
	 	   이연산자에의해 객체를 생성한다.
*/




