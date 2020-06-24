
public class Child extends Parent
{
	
	public Child() 
	{
		/*
		 *  - 클래스의 생성자 첫번째 라인에서는 
		 *    부모클래스의 기본(디폴트)생성자가 호출된다.
		 *  - 생략이 가능하다.
		 */
		super();
		System.out.println("Child()디폴트 생성자");
	}
	
	public int member3;
	public void method3() 
	{
		System.out.println("Child.method3()");
	}
}
